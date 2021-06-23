package com.company.quizfactoryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "choice")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String choiceText;
    private Boolean isCorrect;
    private Integer questionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChoiceText() {
        return choiceText;
    }

    public void setChoiceText(String choiceText) {
        this.choiceText = choiceText;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choice choice = (Choice) o;
        return Objects.equals(id, choice.id) && Objects.equals(choiceText, choice.choiceText) && Objects.equals(isCorrect, choice.isCorrect) && Objects.equals(questionId, choice.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, choiceText, isCorrect, questionId);
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id=" + id +
                ", choiceText='" + choiceText + '\'' +
                ", isCorrect=" + isCorrect +
                ", questionId=" + questionId +
                '}';
    }
}
