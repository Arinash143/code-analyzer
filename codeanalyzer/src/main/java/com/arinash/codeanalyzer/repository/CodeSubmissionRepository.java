package com.arinash.codeanalyzer.repository;


import com.arinash.codeanalyzer.entity.CodeSubmission;
import com.arinash.codeanalyzer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeSubmissionRepository extends JpaRepository<CodeSubmission, Long> {
    List<CodeSubmission> findByUser(User user);
}
