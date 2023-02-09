package com.studyaid.studyaid;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnswerOrderRandomizerTest {

    @Test
    void randomize() {
        ArrayList<Answer> answers = new ArrayList<>(3);

        Answer answerOne = new Answer("Correct Answer 1", true);
        Answer answerTwo = new Answer("Correct Answer 2", true);
        Answer answerThree = new Answer("Incorrect Answer 1", false);

        answers.add(answerOne);
        answers.add(answerTwo);
        answers.add(answerThree);

        List<Answer> randomizedAnswers = AnswerOrderRandomizer.randomize(answers);

        assertEquals(answers.size(), randomizedAnswers.size());

        assertTrue(randomizedAnswers.contains(answerOne));
        assertTrue(randomizedAnswers.contains(answerTwo));
        assertTrue(randomizedAnswers.contains(answerThree));
    }
}