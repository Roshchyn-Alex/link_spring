package com.example.diplom_spring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Link {
    @Id
//  IDENTITY - для AUTO INCREMENT
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullLink, shortLink;

    public Link() {
    }

    public Link(String fullLink, String shortLink) {
        this.fullLink = fullLink;
        this.shortLink = shortLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullLink() {
        return fullLink;
    }

    public void setFullLink(String fullLink) {
        this.fullLink = fullLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}
