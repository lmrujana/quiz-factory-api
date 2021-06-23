package com.company.quizfactoryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String quizName;
    private Integer maxScore;
    private String category;
    private String difficulty;
    private Integer userId;

    @OneToMany(mappedBy = "quizId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Question> questions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Integer getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Integer maxScore) {
        this.maxScore = maxScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiz quiz = (Quiz) o;
        return Objects.equals(id, quiz.id) && Objects.equals(quizName, quiz.quizName) && Objects.equals(maxScore, quiz.maxScore) && Objects.equals(category, quiz.category) && Objects.equals(difficulty, quiz.difficulty) && Objects.equals(userId, quiz.userId) && Objects.equals(questions, quiz.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quizName, maxScore, category, difficulty, userId, questions);
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", quizName='" + quizName + '\'' +
                ", maxScore=" + maxScore +
                ", category='" + category + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", userId=" + userId +
                ", questions=" + questions +
                '}';
    }
}
