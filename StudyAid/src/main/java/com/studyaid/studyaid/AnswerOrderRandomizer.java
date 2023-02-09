package com.studyaid.studyaid;

import java.util.ArrayList;
import java.util.List;

public class AnswerOrderRandomizer {

    public static List<Answer> randomize(List<Answer> answers) {
        ArrayList<Answer> answersToRandomize = new ArrayList<>(answers);
        ArrayList<Answer> randomizedAnswers = new ArrayList<>();

        int indexToRemove;
        Answer answer;

        while (answersToRandomize.size() != 0) {
            indexToRemove = (int) (Math.random() * answersToRandomize.size());
            answer = answersToRandomize.remove(indexToRemove);
            randomizedAnswers.add(answer);
        }

        return randomizedAnswers;
    }
}