package com.studyaid.studyaid;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

class DataPersisterTest {

    @Test
    void saveAndLoadQuizzes() throws DataPersisterException {
        Quiz quizOne = new Quiz("Quiz 1");
        Quiz quizTwo = new Quiz("Quiz 2");

        Question questionOne = new Question("Question 1");
        Question questionTwo = new Question("Question 2");
        Question questionThree = new Question("Question 3");

        questionOne.addAnswer(new Answer("Correct Answer 1", true));
        questionTwo.addAnswer(new Answer("Correct Answer 2", true));
        questionThree.addAnswer(new Answer("Correct Answer 3", true));

        questionOne.addAnswer(new Answer("Incorrect Answer 1", false));
        questionTwo.addAnswer(new Answer("Incorrect Answer 2", false));
        questionThree.addAnswer(new Answer("Incorrect Answer 3", false));

        quizOne.addQuestion(questionOne);
        quizOne.addQuestion(questionTwo);

        quizTwo.addQuestion(questionOne);
        quizTwo.addQuestion(questionThree);

        Collection<Quiz> expectedQuizzes = new ArrayList<>();
        expectedQuizzes.add(quizOne);
        expectedQuizzes.add(quizTwo);

        DataPersister.save("study_aid_quizzes_test.txt", expectedQuizzes);
        Collection<Quiz> actualQuizzes = DataPersister.load("study_aid_quizzes_test.txt");

        assertEquals(expectedQuizzes, actualQuizzes);
    }
}