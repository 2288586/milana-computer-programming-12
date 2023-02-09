package com.studyaid.studyaid;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PlayQuizTest {

    @Test
    void playQuiz() {
        Quiz quiz = new Quiz("Quiz 1");

        Question questionOne = new Question("Question 1");
        Question questionTwo = new Question("Question 2");
        Question questionThree = new Question("Question 3");
        Question questionFour = new Question("Question 4");

        questionOne.addAnswer(new Answer("Correct Answer", true));
        questionOne.addAnswer(new Answer("Correct Answer", true));

        questionTwo.addAnswer(new Answer("Correct Answer", true));
        questionTwo.addAnswer(new Answer("Incorrect Answer", false));

        questionThree.addAnswer(new Answer("Incorrect Answer", false));
        questionThree.addAnswer(new Answer("Incorrect Answer", false));

        questionFour.addAnswer(new Answer("Correct Answer", true));
        questionFour.addAnswer(new Answer("Incorrect Answer", false));

        quiz.addQuestion(questionOne);
        quiz.addQuestion(questionTwo);
        quiz.addQuestion(questionThree);
        quiz.addQuestion(questionFour);
        PlayQuiz playQuiz = new PlayQuiz(quiz);

        Question question = playQuiz.getNextQuestion();
        Answer answerOne = questionOne.getAnswers().get(0);
        Answer answerTwo = questionOne.getAnswers().get(1);

        ArrayList<Answer> answers = new ArrayList<>();
        answers.add(answerOne);
        answers.add(answerTwo);

        playQuiz.checkSubmittedAnswers(question, answers);
        String currentScore = playQuiz.getCurrentScore();
        assertEquals("Score: " + 1 + "/" + 1, currentScore);

        question = playQuiz.getNextQuestion();
        answerOne = questionTwo.getAnswers().get(0);
        answerTwo = questionTwo.getAnswers().get(1);

        answers.clear();
        answers.add(answerOne);
        answers.add(answerTwo);

        playQuiz.checkSubmittedAnswers(question, answers);
        currentScore = playQuiz.getCurrentScore();
        assertEquals("Score: " + 1 + "/" + 2, currentScore);

        question = playQuiz.getNextQuestion();
        answerOne = questionThree.getAnswers().get(0);
        answerTwo = questionThree.getAnswers().get(1);

        answers.clear();
        answers.add(answerOne);
        answers.add(answerTwo);

        playQuiz.checkSubmittedAnswers(question, answers);
        currentScore = playQuiz.getCurrentScore();
        assertEquals("Score: " + 1 + "/" + 3, currentScore);

        question = playQuiz.getNextQuestion();
        answerOne = questionFour.getAnswers().get(0);

        answers.clear();
        answers.add(answerOne);

        playQuiz.checkSubmittedAnswers(question, answers);
        currentScore = playQuiz.getCurrentScore();
        assertEquals("Score: " + 2 + "/" + 4, currentScore);

        assertNull(playQuiz.getNextQuestion());
    }
}