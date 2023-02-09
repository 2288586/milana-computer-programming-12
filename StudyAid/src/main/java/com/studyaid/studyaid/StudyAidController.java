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
    private Collection<Quiz> quizzes = new ArrayList<>();
    private boolean inCreateQuizMode = false;
    private boolean inPlayQuizMode = false;

    private PlayQuiz playQuiz;
    private Question question;

    private Answer answerOne;
    private Answer answerTwo;
    private Answer answerThree;
    private Answer answerFour;

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

    public Button newQuestionButton;
    public Button saveQuestionButton;
    public Button deleteQuestionButton;

    public ChoiceBox<Quiz> playQuizzesChoiceBox;
    public Button playQuizButton;

    public Label playQuestionNameLabel;

    public Label playAnswerOneLabel;
    public Label playAnswerTwoLabel;
    public Label playAnswerThreeLabel;
    public Label playAnswerFourLabel;

    public CheckBox playAnswerOneCheckBox;
    public CheckBox playAnswerTwoCheckBox;
    public CheckBox playAnswerThreeCheckBox;
    public CheckBox playAnswerFourCheckBox;

    public Button submitAnswersButton;
    public Label playQuizStatusLabel;
    public Button nextQuestionButton;
    public Label scoreLabel;

    @FXML
    private void initialize() {
        try {
            quizzes = DataPersister.load(fileName);
            statusLabel.setText("Successfully loaded data.");

            quizQuestionsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleQuizQuestionsListView());
            allQuizzesChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleAllQuizzesChoiceBox());

            saveQuizButton.setDisable(true);
            populateData(quizzes);

            playAnswerOneCheckBox.setVisible(false);
            playAnswerTwoCheckBox.setVisible(false);
            playAnswerThreeCheckBox.setVisible(false);
            playAnswerFourCheckBox.setVisible(false);

            submitAnswersButton.setVisible(false);

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
            answerOneCheckBox.setSelected(answers.get(0).isCorrect());

            answerTwoTextField.setText(answers.get(1).getAnswer());
            answerTwoCheckBox.setSelected(answers.get(1).isCorrect());

            answerThreeTextField.setText(answers.get(2).getAnswer());
            answerThreeCheckBox.setSelected(answers.get(2).isCorrect());

            answerFourTextField.setText(answers.get(3).getAnswer());
            answerFourCheckBox.setSelected(answers.get(3).isCorrect());
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

        //TODO: Call populateData After Finishing Quiz
        if (!inPlayQuizMode) {
            playQuizzesChoiceBox.setItems(allQuizzesChoices);

            if (quizzes.size() > 0) {
                playQuizzesChoiceBox.setValue(allQuizzesChoices.get(0));
                playQuizButton.setDisable(false);
            } else {
                playQuizButton.setDisable(true);
            }
        }
    }

    public void onNewQuizButtonClick() {
        inCreateQuizMode = true;

        allQuizzesChoiceBox.setVisible(false);
        newQuizTextField.setVisible(true);

        ObservableList<Question> allQuestions = FXCollections.observableArrayList(new ArrayList<>());
        quizQuestionsListView.setItems(allQuestions);

        clearQuestionGrid();
        disableQuestionGrid(true);

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

                disableQuestionGrid(false);

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

            disableQuestionGrid(false);
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

    public void onPlayButtonQuizClick() {
        inPlayQuizMode = true;

        playQuizButton.setDisable(true);
        playQuizzesChoiceBox.setDisable(true);

        playAnswerOneCheckBox.setVisible(true);
        playAnswerTwoCheckBox.setVisible(true);
        playAnswerThreeCheckBox.setVisible(true);
        playAnswerFourCheckBox.setVisible(true);

        submitAnswersButton.setVisible(true);

        Quiz quiz = playQuizzesChoiceBox.getSelectionModel().getSelectedItem();
        playQuiz = new PlayQuiz(quiz);

        question = playQuiz.getNextQuestion();

        if (question != null) {
            List<Answer> answers = question.getAnswers();
            List<Answer> randomizedAnswers = AnswerOrderRandomizer.randomize(answers);

            playQuestionNameLabel.setText(question.getQuestion());

            answerOne = randomizedAnswers.get(0);
            answerTwo = randomizedAnswers.get(1);
            answerThree = randomizedAnswers.get(2);
            answerFour = randomizedAnswers.get(3);

            playAnswerOneLabel.setText(answerOne.getAnswer());
            playAnswerTwoLabel.setText(answerTwo.getAnswer());
            playAnswerThreeLabel.setText(answerThree.getAnswer());
            playAnswerFourLabel.setText(answerFour.getAnswer());
        } else {
            //TODO: Handle No Questions
        }
    }

    public void onSubmitAnswersButtonClick() {
        submitAnswersButton.setVisible(false);
        playQuestionNameLabel.setVisible(false);

        playAnswerOneLabel.setVisible(false);
        playAnswerTwoLabel.setVisible(false);
        playAnswerThreeLabel.setVisible(false);
        playAnswerFourLabel.setVisible(false);

        playAnswerOneCheckBox.setVisible(false);
        playAnswerTwoCheckBox.setVisible(false);
        playAnswerThreeCheckBox.setVisible(false);
        playAnswerFourCheckBox.setVisible(false);

        playQuizStatusLabel.setVisible(true);
        nextQuestionButton.setVisible(true);

        ArrayList<Answer> answers = new ArrayList<>();

        if (playAnswerOneCheckBox.isSelected()) {
            answers.add(answerOne);
        }
        if (playAnswerTwoCheckBox.isSelected()) {
            answers.add(answerTwo);
        }
        if (playAnswerThreeCheckBox.isSelected()) {
            answers.add(answerThree);
        }
        if (playAnswerFourCheckBox.isSelected()) {
            answers.add(answerFour);
        }

        boolean isCorrect = playQuiz.checkSubmittedAnswers(question, answers);
        scoreLabel.setText(playQuiz.getCurrentScore());

        if (isCorrect) {
            playQuizStatusLabel.setText("Correct!");
        } else {
            playQuizStatusLabel.setText("Incorrect...");
        }

        //TODO: Handle Last Question
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

    private void disableQuestionGrid(boolean disable) {
        questionNameTextField.setDisable(disable);
        answerOneTextField.setDisable(disable);
        answerOneCheckBox.setDisable(disable);
        answerTwoTextField.setDisable(disable);
        answerTwoCheckBox.setDisable(disable);
        answerThreeTextField.setDisable(disable);
        answerThreeCheckBox.setDisable(disable);
        answerFourTextField.setDisable(disable);
        answerFourTextField.setDisable(disable);

        newQuestionButton.setDisable(disable);
        saveQuestionButton.setDisable(disable);
        deleteQuestionButton.setDisable(disable);
    }
}