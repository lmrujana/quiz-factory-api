package com.company.quizfactoryservice.dao;

import com.company.quizfactoryservice.dto.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
