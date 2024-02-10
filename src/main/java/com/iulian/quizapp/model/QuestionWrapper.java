package com.iulian.quizapp.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class QuestionWrapper {

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

    public QuestionWrapper(int id, String category, String questionTitle, String option1, String option2, String option3) {
        this.id = id;
        this.category = category;
        this.questionTitle = questionTitle;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
