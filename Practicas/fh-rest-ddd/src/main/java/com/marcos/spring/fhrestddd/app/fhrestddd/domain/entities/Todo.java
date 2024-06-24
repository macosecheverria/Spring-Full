package com.marcos.spring.fhrestddd.app.fhrestddd.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String text;

    @Column(name = "completed_at")
    private boolean completedAt;

    public Todo() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(boolean completedAt) {
        this.completedAt = completedAt;
    }

}
