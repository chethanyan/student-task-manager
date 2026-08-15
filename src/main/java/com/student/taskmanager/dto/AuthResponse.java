package com.student.taskmanager.dto;

public class AuthResponse {
    private String token;
    private String username;
    private Integer userId;

    public AuthResponse(String token, String username, Integer userId) {
        this.token = token;
        this.username = username;
        this.userId = userId;
    }

    // Getters
    public String getToken() { return token; }
    public String getUsername() { return username; }
    public Integer getUserId() { return userId; }
}