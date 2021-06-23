package com.company.quizfactoryservice.dao;

import com.company.quizfactoryservice.dto.Choice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
}
