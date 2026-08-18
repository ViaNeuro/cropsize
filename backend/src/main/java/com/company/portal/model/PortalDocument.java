package com.company.portal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class PortalDocument {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String title;
    @NotBlank @Column(nullable = false)
    private String category;
    @NotBlank @Column(nullable = false)
    private String url;

    public PortalDocument() {}
    public PortalDocument(String title, String category, String url) { this.title = title; this.category = category; this.url = url; }
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}
