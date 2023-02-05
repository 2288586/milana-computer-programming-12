package com.studyaid.studyaid;

import java.util.ArrayList;
import java.util.Collection;

public class Quiz {
    private String name;
    private final ArrayList<Question> questions;

    public Quiz(String name) {
        this.name = name;
        questions = new ArrayList<>();
    }

    public Collection<Question> getQuestions() {
        return questions;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void removeQuestion(Question question) {
        questions.remove(question);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}