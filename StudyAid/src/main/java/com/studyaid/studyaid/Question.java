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

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public String toString() {
        return question;
    }

    @Override
    public boolean equals(Object object) {
        Question question = (Question) object;
        boolean isEqual = false;

        if (question != null && this.question.equals(question.getQuestion()) && this.answers.equals(question.getAnswers())) {
            isEqual = true;
        }

        return isEqual;
    }
}