package com.studyaid.studyaid;

import java.util.ArrayList;
import java.util.Collection;

public class Question {
    private String question;
    private final ArrayList<String> correctAnswers;
    private final ArrayList<String> incorrectAnswers;

    public Question(String question) {
        this.question = question;
        this.correctAnswers = new ArrayList<>();
        this.incorrectAnswers = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Collection<String> getCorrectAnswers() {
        return correctAnswers;
    }

    public void addCorrectAnswer(String correctAnswer) {
        correctAnswers.add(correctAnswer);
    }

    public Collection<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void addIncorrectAnswer(String incorrectAnswer) {
        incorrectAnswers.add(incorrectAnswer);
    }

    @Override
    public String toString() {
        return question;
    }

    @Override
    public boolean equals(Object object) {
        Question question = (Question) object;
        boolean isEqual = false;

        if (this.question.equals(question.getQuestion()) && this.correctAnswers.equals(question.getCorrectAnswers()) && this.incorrectAnswers.equals(question.getIncorrectAnswers())) {
            isEqual = true;
        }

        return isEqual;
    }
}