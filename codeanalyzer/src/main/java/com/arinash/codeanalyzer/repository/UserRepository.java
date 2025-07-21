package com.arinash.codeanalyzer.repository;

import com.arinash.codeanalyzer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // nothing to add yet
}
