package com.iulian.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "question_title")
    private String questionTitle;

    @Column(name = "option1")
    private String option1;

    @Column(name = "option2")
    private String option2;

    @Column(name = "option3")
    private String option3;

    @Column(name = "option4")
    private String option4;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "difficultylevel")
    private String difficultyLevel;

    // Constructors, getters, setters, etc.
}
