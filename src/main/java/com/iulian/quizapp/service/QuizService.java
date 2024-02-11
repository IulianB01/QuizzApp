package com.iulian.quizapp.service;

import com.iulian.quizapp.dao.QuestionDao;
import com.iulian.quizapp.dao.QuizDao;
import com.iulian.quizapp.model.Question;
import com.iulian.quizapp.model.QuestionWrapper;
import com.iulian.quizapp.model.Quiz;
import com.iulian.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return  new ResponseEntity<>("Merge", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

      Optional<Quiz> quiz =  quizDao.findById(id);
      List<Question> questionsFromDB = quiz.get().getQuestions();
      List<QuestionWrapper> questionForUser = new ArrayList<>();
      for(Question q: questionsFromDB){

          QuestionWrapper qw = new QuestionWrapper
                   (q.getId(),q.getQuestionTitle(),q.getOption1(), q.getOption2(), q.getOption3(),q.getOption4());
          questionForUser.add(qw);
      }

      return new ResponseEntity<>(questionForUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
          Quiz quiz = quizDao.findById(id).get();
          List<Question> questions = quiz.getQuestions();
          int right=0;
          int i=0;
          for(Response response : responses){
              if(response.getResponse().equals(questions.get(i).getCorrectAnswer()))
                  right++;
              i++;

          }
          return new ResponseEntity<>(right,HttpStatus.OK);


    }
}
