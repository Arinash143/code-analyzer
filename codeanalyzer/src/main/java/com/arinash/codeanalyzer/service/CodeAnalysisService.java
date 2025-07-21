package com.arinash.codeanalyzer.service;

import org.springframework.stereotype.Service;

@Service
public class CodeAnalysisService {

    public int analyzeWithPMD(String code) {
        int score = 100;

        if (code.length() < 30) {
            score -= 10;  // too short
        }

        if (code.contains("System.out.println")) {
            score -= 15;  // discouraged
        }
      

        if (!code.contains("class")) {
            score -= 20;  // no class defined
        }

        if (!code.contains("main")) {
            score -= 10;  // no main method
        }
        if (code.contains("{}")) {
            score += 5;  
        }
        return Math.max(score, 50);  // I set minimum 50
    }

    public String analyzeWithCheckstyle(String code) {
        if (code.contains("System.out.println")) {
            return "Avoid System.out in production code";
        }
        if (!code.contains("class")) {
            return "Code missing class definition";
        }
            if (!code.contains("{}")) {
                return "Code missing curly braces";
        }
            if (!code.contains("main")) {
                return "main method missing";
        }
        return "No major issues";
    }
}
