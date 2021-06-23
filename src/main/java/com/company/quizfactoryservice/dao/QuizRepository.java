package com.company.quizfactoryservice.dao;

import com.company.quizfactoryservice.dto.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    List<Quiz> findByDifficultyAndCategory(String difficulty, String Category);
    List<Quiz> findByDifficulty(String difficulty);
    List<Quiz> findByCategory(String Category);
}
