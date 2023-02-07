package com.studyaid.studyaid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.Collection;
import java.util.List;

public class StudyAidController {

    private final String fileName = "study_aid_quizzes.txt";

    public Label statusLabel;
    public ChoiceBox<Quiz> allQuizzesChoiceBox;
    public ListView<Question> quizQuestionsListView;

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
            Collection<Quiz> quizzes = DataPersister.load(fileName);
            statusLabel.setText("Successfully loaded data.");

            quizQuestionsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleQuizQuestionsListView());
            allQuizzesChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleAllQuizzesChoiceBox());

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
            quizQuestionsListView.getSelectionModel().select(0);
        }
    }

    private void populateData(Collection<Quiz> quizzes) {
        ObservableList<Quiz> allQuizzesChoices = FXCollections.observableArrayList(quizzes);

        allQuizzesChoiceBox.setItems(allQuizzesChoices);
        allQuizzesChoiceBox.setValue(allQuizzesChoices.get(0));
    }
}