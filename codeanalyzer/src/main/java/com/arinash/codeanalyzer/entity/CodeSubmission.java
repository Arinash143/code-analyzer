package com.arinash.codeanalyzer.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "code_submission")
public class CodeSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeText() {
		return codeText;
	}

	public void setCodeText(String codeText) {
		this.codeText = codeText;
	}

	public int getAnalysisScore() {
		return analysisScore;
	}

	public void setAnalysisScore(int analysisScore) {
		this.analysisScore = analysisScore;
	}

	public String getIssuesFound() {
		return issuesFound;
	}

	public void setIssuesFound(String issuesFound) {
		this.issuesFound = issuesFound;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	private String codeText;

    private int analysisScore;

    private String issuesFound;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt = LocalDateTime.now();

    public CodeSubmission() {
    }

    // getters and setters
    // Right-click → Source → Generate Getters/Setters
}
