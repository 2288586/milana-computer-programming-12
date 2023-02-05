package com.studyaid.studyaid;

import java.util.ArrayList;
import java.util.Collection;

public class Question {
    private String question;
    private final ArrayList<String> correctAnswers;
    private final ArrayList<String> incorrectAnswers;

    public Question(String question, Collection<String> correctAnswers, Collection<String> incorrectAnswers) {
        this.question = question;
        this.correctAnswers = new ArrayList<>(correctAnswers);
        this.incorrectAnswers = new ArrayList<>(incorrectAnswers);
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

    public Collection<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    @Override
    public String toString() {
        return question;
    }
}