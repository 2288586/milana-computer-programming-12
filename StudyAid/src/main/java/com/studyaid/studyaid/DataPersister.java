package com.studyaid.studyaid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;

public class DataPersister {

    public static void save(String fileName, Collection<Quiz> quizzes) throws DataPersisterException {
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

                    bufferedWriter.write(question.getCorrectAnswers().size() + "\n");
                    for (String answer : question.getCorrectAnswers()) {
                        bufferedWriter.write(answer + "\n");
                    }

                    bufferedWriter.write(question.getIncorrectAnswers().size() + "\n");
                    for (String answer : question.getIncorrectAnswers()) {
                        bufferedWriter.write(answer + "\n");
                    }
                }
            }

            bufferedWriter.close();

        } catch (Exception exception) {
            throw new DataPersisterException("Failed to save quizzes due to the following error: '" + exception + "'.");
        }
    }

    public static Collection<Quiz> load(String fileName) throws DataPersisterException {
        ArrayList<Quiz> quizzes;

        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            int numOfQuizzes = Integer.parseInt(line);
            quizzes = new ArrayList<>(numOfQuizzes);

            for (int i = 0; i < numOfQuizzes; i++) {
                line = bufferedReader.readLine();
                Quiz quiz = new Quiz(line);

                line = bufferedReader.readLine();
                int numOfQuestions = Integer.parseInt(line);

                for (int j = 0; j < numOfQuestions; j++) {
                    line = bufferedReader.readLine();
                    Question question = new Question(line);

                    line = bufferedReader.readLine();
                    int numOfCorrectAnswers = Integer.parseInt(line);

                    for (int k = 0; k < numOfCorrectAnswers; k++) {
                        line = bufferedReader.readLine();
                        question.addCorrectAnswer(line);
                    }

                    line = bufferedReader.readLine();
                    int numOfIncorrectAnswers = Integer.parseInt(line);

                    for (int l = 0; l < numOfIncorrectAnswers; l++) {
                        line = bufferedReader.readLine();
                        question.addIncorrectAnswer(line);
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