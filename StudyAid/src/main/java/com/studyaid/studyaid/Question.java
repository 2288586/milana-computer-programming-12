package com.studyaid.studyaid;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private final ArrayList<Answer> answers;

    public Question(String question) {
        this.question = question;
        this.answers = new ArrayList<>();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Answer> getCorrectAnswers() {
        ArrayList<Answer> correctAnswers = new ArrayList<>();

        for (Answer answer : answers) {
            if (answer.isCorrect()) {
                correctAnswers.add(answer);
            }
        }

        return correctAnswers;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public String toString() {
        return question;
    }
}