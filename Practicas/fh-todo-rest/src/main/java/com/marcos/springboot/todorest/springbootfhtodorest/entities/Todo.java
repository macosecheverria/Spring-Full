package com.marcos.springboot.todorest.springbootfhtodorest.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    public Todo() {
    }

    public Todo(Long id, String text, LocalDateTime completedAt) {
        this.id = id;
        this.text = text;
        this.completedAt = completedAt;
    }

    @PrePersist
    public void prePersist(){
        this.completedAt =  LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.completedAt = LocalDateTime.now();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", text=" + text + ", completedAt=" + completedAt + "]";
    };

}
