package com.example.digishopkart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobResponse {
    @Id
    @Column(name = "job_id", nullable = false)
    private String jobId;

    private boolean success;
    private String jobGroup;
    private String message;

    public JobResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
