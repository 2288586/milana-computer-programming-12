package com.studyaid.studyaid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayQuizTest {

    @Test
    void playQuiz() {
        Quiz quiz = new Quiz("Quiz 1");

        Question questionOne = new Question("Question 1");
        Question questionTwo = new Question("Question 2");
        Question questionThree = new Question("Question 3");

        questionOne.addAnswer(new Answer("Correct Answer 1", true));
        questionTwo.addAnswer(new Answer("Correct Answer 2", true));
        questionThree.addAnswer(new Answer("Correct Answer 3", true));

        questionOne.addAnswer(new Answer("Incorrect Answer 1", false));
        questionTwo.addAnswer(new Answer("Incorrect Answer 2", false));
        questionThree.addAnswer(new Answer("Incorrect Answer 3", false));

        quiz.addQuestion(questionOne);
        quiz.addQuestion(questionTwo);

        PlayQuiz playQuiz = new PlayQuiz(quiz);
        Question question;
        Answer answer;

        int answerCounter = 0;
        int correctAnswerCounter = 0;

        while ((question = playQuiz.getNextQuestion()) != null) {
            answerCounter++;
            answer = question.getAnswers().get(0);

            if (answer.getCorrect()) {
                correctAnswerCounter++;
            }

            playQuiz.submitAnswer(answer);
            String currentScore = playQuiz.getCurrentScore();

            assertEquals("Score: " + correctAnswerCounter + "/" + answerCounter, currentScore);
        }
    }
}