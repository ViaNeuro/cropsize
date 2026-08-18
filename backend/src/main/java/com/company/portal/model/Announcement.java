package com.company.portal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Announcement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String title;
    @NotBlank @Column(nullable = false, length = 4000)
    private String content;
    @Column(nullable = false)
    private LocalDateTime publishedAt;

    public Announcement() {}
    public Announcement(String title, String content, LocalDateTime publishedAt) { this.title = title; this.content = content; this.publishedAt = publishedAt; }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getPublishedAt() { return publishedAt; }
    public void setPublishedAt(LocalDateTime publishedAt) { this.publishedAt = publishedAt; }
}
