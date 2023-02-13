package com.studyaid.studyaid;

import java.util.List;

public class QuizPlayer {

    private final Quiz quiz;
    private int currentQuestionIndex;

    int numOfQuestionsAnswered;
    int numOfCorrectAnswers;

    public QuizPlayer(Quiz quiz) {
        this.quiz = quiz;
        currentQuestionIndex = 0;

        numOfQuestionsAnswered = 0;
        numOfCorrectAnswers = 0;
    }

    public Quiz getQuiz() {
        return quiz;
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

    public boolean checkSubmittedAnswers(Question question, List<Answer> answers) {
        numOfQuestionsAnswered++;
        boolean correctAnswer = true;

        for (Answer answer : answers) {
            if (!answer.isCorrect()) {
                correctAnswer = false;
                break;
            }
        }

        if (answers.size() != question.getCorrectAnswers().size()) {
            correctAnswer = false;
        }

        if (correctAnswer) {
            numOfCorrectAnswers++;
            return true;
        }

        return false;
    }

    public String getCurrentScore() {
        return "Score: " + numOfCorrectAnswers + "/" + numOfQuestionsAnswered;
    }
}