package com.studyaid.studyaid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DataPersister {

    public static void save(String fileName, List<Quiz> quizzes) throws DataPersisterException {
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(quizzes.size() + "\n");

            for (Quiz quiz : quizzes) {
                bufferedWriter.write(quiz.getName() + "\n");
                bufferedWriter.write(quiz.getQuestions().size() + "\n");

                for (Question question : quiz.getQuestions()) {
                    bufferedWriter.write(question.getQuestion() + "\n");

                    bufferedWriter.write(question.getAnswers().size() + "\n");
                    for (Answer answer : question.getAnswers()) {
                        bufferedWriter.write(answer.getAnswer() + "\n");
                        bufferedWriter.write(answer.isCorrect() + "\n");
                    }
                }
            }

            bufferedWriter.close();

        } catch (Exception exception) {
            throw new DataPersisterException("Failed to save quizzes due to the following error: '" + exception + "'.");
        }
    }

    public static List<Quiz> load(String fileName) throws DataPersisterException {
        ArrayList<Quiz> quizzes;

        String line;
        int numOfQuizzes;

        Quiz quiz;
        int numOfQuestions;

        Question question;
        int numOfAnswers;

        String answerAnswer;
        boolean answerCorrect;
        Answer answer;

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            line = bufferedReader.readLine();
            numOfQuizzes = Integer.parseInt(line);
            quizzes = new ArrayList<>(numOfQuizzes);

            for (int i = 0; i < numOfQuizzes; i++) {
                line = bufferedReader.readLine();
                quiz = new Quiz(line);

                line = bufferedReader.readLine();
                numOfQuestions = Integer.parseInt(line);

                for (int j = 0; j < numOfQuestions; j++) {
                    line = bufferedReader.readLine();
                    question = new Question(line);

                    line = bufferedReader.readLine();
                    numOfAnswers = Integer.parseInt(line);

                    for (int k = 0; k < numOfAnswers; k++) {
                        answerAnswer = bufferedReader.readLine();
                        line = bufferedReader.readLine();
                        answerCorrect = Boolean.parseBoolean(line);

                        answer = new Answer(answerAnswer, answerCorrect);
                        question.addAnswer(answer);
                    }

                    quiz.addQuestion(question);
                }

                quizzes.add(quiz);
            }

            bufferedReader.close();

        } catch (Exception exception) {
            throw new DataPersisterException("Failed to load quizzes due to the following error: '" + exception + "'.");
        }

        return quizzes;
    }
}