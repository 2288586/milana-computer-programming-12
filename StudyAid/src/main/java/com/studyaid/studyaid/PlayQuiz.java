package com.studyaid.studyaid;

import java.util.List;

public class PlayQuiz {

    private final Quiz quiz;
    private int currentQuestionIndex;

    int numOfQuestionsAnswered;
    int numOfCorrectAnswers;

    public PlayQuiz(Quiz quiz) {
        this.quiz = quiz;
        currentQuestionIndex = 0;

        numOfQuestionsAnswered = 0;
        numOfCorrectAnswers = 0;
    }

    public Question getNextQuestion() {
        List<Question> questions = quiz.getQuestions();
        Question currentQuestion = null;

        if (currentQuestionIndex < quiz.getQuestions().size()) {
            currentQuestion = questions.get(currentQuestionIndex);
        }

        currentQuestionIndex++;
        return currentQuestion;
    }

    public void submitAnswer(Answer answer) {
        numOfQuestionsAnswered++;

        if (answer.getCorrect()) {
            numOfCorrectAnswers++;
        }
    }

    public String getCurrentScore() {
        return "Score: " + numOfCorrectAnswers + "/" + numOfQuestionsAnswered;
    }

}