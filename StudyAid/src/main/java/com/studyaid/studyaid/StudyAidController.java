package com.studyaid.studyaid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StudyAidController {

    private final String fileName = "study_aid_quizzes.txt";
    Collection<Quiz> quizzes = new ArrayList<>();
    private boolean inCreateQuizMode = false;

    public Label statusLabel;
    public ChoiceBox<Quiz> allQuizzesChoiceBox;
    public TextField newQuizTextField;
    public ListView<Question> quizQuestionsListView;
    public Button newQuizButton;
    public Button saveQuizButton;
    public Button deleteQuizButton;

    public TextField questionNameTextField;

    public TextField answerOneTextField;
    public TextField answerTwoTextField;
    public TextField answerThreeTextField;
    public TextField answerFourTextField;

    public CheckBox answerOneCheckBox;
    public CheckBox answerTwoCheckBox;
    public CheckBox answerThreeCheckBox;
    public CheckBox answerFourCheckBox;

    @FXML
    private void initialize() {
        try {
            quizzes = DataPersister.load(fileName);
            statusLabel.setText("Successfully loaded data.");

            quizQuestionsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleQuizQuestionsListView());
            allQuizzesChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleAllQuizzesChoiceBox());

            saveQuizButton.setDisable(true);
            populateData(quizzes);

        } catch (Exception exception) {
            System.out.println(exception.toString());
            statusLabel.setText("Failed to load data.");
        }
    }

    private void handleQuizQuestionsListView() {
        Question currentQuestion = quizQuestionsListView.getSelectionModel().getSelectedItem();
        if (currentQuestion != null) {
            List<Answer> answers = currentQuestion.getAnswers();

            questionNameTextField.setText(currentQuestion.getQuestion());

            answerOneTextField.setText(answers.get(0).getAnswer());
            answerOneCheckBox.setSelected(answers.get(0).getCorrect());

            answerTwoTextField.setText(answers.get(1).getAnswer());
            answerTwoCheckBox.setSelected(answers.get(1).getCorrect());

            answerThreeTextField.setText(answers.get(2).getAnswer());
            answerThreeCheckBox.setSelected(answers.get(2).getCorrect());

            answerFourTextField.setText(answers.get(3).getAnswer());
            answerFourCheckBox.setSelected(answers.get(3).getCorrect());
        }
    }

    private void handleAllQuizzesChoiceBox() {
        Quiz currentQuiz = allQuizzesChoiceBox.getValue();
        if (currentQuiz != null) {
            ObservableList<Question> allQuestions = FXCollections.observableArrayList(currentQuiz.getQuestions());

            quizQuestionsListView.setItems(allQuestions);
            if (allQuestions.size() > 0) {
                quizQuestionsListView.getSelectionModel().select(0);
            } else {
                clearQuestionGrid();
            }
        }
    }

    private void populateData(Collection<Quiz> quizzes) {
        ObservableList<Quiz> allQuizzesChoices = FXCollections.observableArrayList(quizzes);

        allQuizzesChoiceBox.setItems(allQuizzesChoices);
        if (quizzes.size() > 0) {
            allQuizzesChoiceBox.setValue(allQuizzesChoices.get(0));
        } else {
            clearQuestionGrid();
        }
    }

    public void onNewQuizButtonClick() {
        inCreateQuizMode = true;

        allQuizzesChoiceBox.setVisible(false);
        newQuizTextField.setVisible(true);

        ObservableList<Question> allQuestions = FXCollections.observableArrayList(new ArrayList<>());
        quizQuestionsListView.setItems(allQuestions);

        clearQuestionGrid();

        newQuizButton.setDisable(true);
        saveQuizButton.setDisable(false);
    }

    public void onSaveQuizButtonClick() {
        String quizName = newQuizTextField.getText();

        if (quizName == null || quizName.equals("")) {
            statusLabel.setText("Cannot save, quiz name is required.");
        } else {
            Quiz quiz = new Quiz(quizName);

            for (Question question : quizQuestionsListView.getItems()) {
                quiz.addQuestion(question);
            }
            quizzes.add(quiz);

            try {
                DataPersister.save(fileName, quizzes);
                statusLabel.setText("Successfully saved quiz.");

                inCreateQuizMode = false;
                allQuizzesChoiceBox.setVisible(true);
                newQuizTextField.setText("");
                newQuizTextField.setVisible(false);

                newQuizButton.setDisable(false);
                saveQuizButton.setDisable(true);

                populateData(quizzes);
                allQuizzesChoiceBox.setValue(quiz);

            } catch (Exception exception) {
                statusLabel.setText("Failed to save quiz.");
            }
        }
    }

    public void onDeleteQuizButtonClick() {
        if (inCreateQuizMode) {

            inCreateQuizMode = false;
            allQuizzesChoiceBox.setVisible(true);
            newQuizTextField.setText("");
            newQuizTextField.setVisible(false);

            newQuizButton.setDisable(false);
            saveQuizButton.setDisable(true);

            statusLabel.setText("Successfully deleted quiz.");
            populateData(quizzes);
            
        } else {
            Quiz quiz = allQuizzesChoiceBox.getValue();

            if (quiz != null) {
                quizzes.remove(quiz);

                try {
                    DataPersister.save(fileName, quizzes);
                    statusLabel.setText("Successfully deleted quiz.");
                    populateData(quizzes);

                } catch (Exception exception) {
                    statusLabel.setText("Failed to delete quiz.");
                }
            }
        }
    }

    private void clearQuestionGrid() {
        questionNameTextField.setText("");
        answerOneTextField.setText("");
        answerOneCheckBox.setSelected(false);
        answerTwoTextField.setText("");
        answerTwoCheckBox.setSelected(false);
        answerThreeTextField.setText("");
        answerThreeCheckBox.setSelected(false);
        answerFourTextField.setText("");
        answerFourCheckBox.setSelected(false);
    }
}