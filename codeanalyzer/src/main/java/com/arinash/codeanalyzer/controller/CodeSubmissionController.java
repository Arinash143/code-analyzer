package com.arinash.codeanalyzer.controller;

import com.arinash.codeanalyzer.entity.CodeSubmission;
import com.arinash.codeanalyzer.entity.User;
import com.arinash.codeanalyzer.repository.CodeSubmissionRepository;
import com.arinash.codeanalyzer.repository.UserRepository;
import com.arinash.codeanalyzer.service.CodeAnalysisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/codesubmit")
public class CodeSubmissionController {

    @Autowired
    private CodeSubmissionRepository codeRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CodeAnalysisService analysisService;

    @PostMapping
    public ResponseEntity<CodeSubmission> submitCode(@RequestParam Long userId, @RequestBody String codeText) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        CodeSubmission submission = new CodeSubmission();
        submission.setUser(user);
        submission.setCodeText(codeText);
        submission.setAnalysisScore(analysisService.analyzeWithPMD(codeText));
        submission.setIssuesFound(analysisService.analyzeWithCheckstyle(codeText));

        codeRepo.save(submission);

        return ResponseEntity.ok(submission);
    }

    @GetMapping("/{userId}")
    public List<CodeSubmission> getSubmissions(@PathVariable Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return codeRepo.findByUser(user);
    }
}
