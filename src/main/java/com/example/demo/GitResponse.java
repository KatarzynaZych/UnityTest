package com.example.demo;

record GitResponse(
        String fullName,
        String description,
        String cloneUrl,
        int stars,
        String createdAt
) {
}
