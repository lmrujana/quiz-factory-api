package com.company.quizfactoryservice.controller;

import com.company.quizfactoryservice.dao.QuestionRepository;
import com.company.quizfactoryservice.dao.QuizRepository;
import com.company.quizfactoryservice.dto.Question;
import com.company.quizfactoryservice.dto.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/quizzes")
public class QuizController {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Quiz addQuiz(@RequestBody Quiz newQuiz){

        Quiz savedQuiz =  quizRepository.save(newQuiz);
        final int savedQuizId = savedQuiz.getId();
        if(newQuiz.getQuestions() != null){
            newQuiz.getQuestions().forEach(q -> q.setQuizId(savedQuizId));
        }


        Set<Question> newQuestions = newQuiz.getQuestions();
        for(Question question : newQuestions){
            final int questionId = question.getId();
            question.getChoices().forEach(choice -> choice.setQuestionId(questionId));
            questionRepository.save(question);
        }

        savedQuiz.setQuestions(newQuestions);

        Quiz finalSavedQuiz = quizRepository.save(savedQuiz);

        return finalSavedQuiz;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Quiz> getAllQuizzes(@RequestParam(required = false) String difficulty, @RequestParam(required = false) String category){
        if(difficulty != null && category != null){
            return  quizRepository.findByDifficultyAndCategory(difficulty, category);
        } else if(difficulty != null){
            return quizRepository.findByDifficulty(difficulty);
        } else if(category != null){
            return  quizRepository.findByCategory(category);
        } else {
            return quizRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Quiz getQuizById(@PathVariable int id){
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()){
            return quiz.get();
        } else {
            return null;
        }
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateQuiz(@RequestBody Quiz updatedQuiz){
        quizRepository.save(updatedQuiz);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoaster(@PathVariable int id){
        quizRepository.deleteById(id);
    }
}
