package com.company.quizfactoryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionText;
    private Integer quizId;

    @OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Choice> Choices;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public List<Choice> getChoices() {
        return Choices;
    }

    public void setChoices(List<Choice> Choices) {
        this.Choices = Choices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(questionText, question.questionText) && Objects.equals(quizId, question.quizId) && Objects.equals(Choices, question.Choices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, questionText, quizId, Choices);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", quizId=" + quizId +
                ", Choices=" + Choices +
                '}';
    }
}
