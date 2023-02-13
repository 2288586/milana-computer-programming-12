package com.studyaid.studyaid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;

import java.util.ArrayList;
import java.util.List;

public class StudyAidController {

    private static final String fileName = "study_aid_quizzes.txt";
    private static List<Quiz> quizzes = new ArrayList<>();

    private boolean handlerIsEnabled = true;
    private QuizPlayer quizPlayer;
    private Question question;

    private Answer answerOne;
    private Answer answerTwo;
    private Answer answerThree;
    private Answer answerFour;

    public Label statusLabel;
    public ChoiceBox<Quiz> allQuizzesChoiceBox;
    public TextField quizNameTextField;
    public ListView<Question> quizQuestionsListView;
    public Button newQuizButton;
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
    public Button deleteQuestionButton;

    public ChoiceBox<Quiz> playQuizzesChoiceBox;

    public Label playQuizNameLabel;
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
        quizNameTextField.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
        questionNameTextField.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
        answerOneTextField.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
        answerTwoTextField.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
        answerThreeTextField.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);
        answerFourTextField.addEventFilter(ContextMenuEvent.CONTEXT_MENU_REQUESTED, Event::consume);

        quizQuestionsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleQuizQuestionsListView());
        allQuizzesChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleAllQuizzesChoiceBox());

        populateQuizzes();

        if (quizzes.size() > 0) {
            allQuizzesChoiceBox.getSelectionModel().select(0);
        } else {
            disableQuestionGrid();
            playQuizButton.setDisable(true);
        }

        playAnswerOneCheckBox.setVisible(false);
        playAnswerTwoCheckBox.setVisible(false);
        playAnswerThreeCheckBox.setVisible(false);
        playAnswerFourCheckBox.setVisible(false);

        submitAnswersButton.setVisible(false);
    }

    public static void loadData() {
        try {
            quizzes = DataPersister.load(fileName);
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    public static void saveData() {
        try {
            DataPersister.save(fileName, quizzes);
        } catch (Exception exception) {
            System.out.println(exception.toString());
        }
    }

    private void handleAllQuizzesChoiceBox() {
        if (handlerIsEnabled) {
            Quiz quiz = allQuizzesChoiceBox.getValue();

            if (quiz != null) {
                quizNameTextField.setText(quiz.getName());
                ObservableList<Question> questions = FXCollections.observableArrayList(quiz.getQuestions());
                quizQuestionsListView.setItems(questions);

                if (questions.size() > 0) {
                    quizQuestionsListView.getSelectionModel().select(0);
                    enableQuestionGrid();
                } else {
                    disableQuestionGrid();
                    newQuestionButton.setDisable(false);
                }
            } else {
                disableQuestionGrid();
            }
        }
    }

    public void handleQuizNameChange() {
        Quiz quiz = allQuizzesChoiceBox.getValue();

        if (quiz != null) {
            String quizName = quizNameTextField.getText();

            if (!quiz.getName().equals(quizName)) {
                quiz.setName(quizName);

                handlerIsEnabled = false;
                Quiz temporaryQuiz = new Quiz("New Quiz");

                quizzes.add(temporaryQuiz);
                populateQuizzes();
                quizzes.remove(temporaryQuiz);
                populateQuizzes();

                allQuizzesChoiceBox.getSelectionModel().select(quiz);
                handlerIsEnabled = true;
            }
        }
    }

    private void handleQuizQuestionsListView() {
        if (handlerIsEnabled) {
            Quiz quiz = allQuizzesChoiceBox.getValue();

            if (quiz != null) {
                Question question = quizQuestionsListView.getSelectionModel().getSelectedItem();

                if (question != null) {
                    List<Answer> answers = question.getAnswers();

                    questionNameTextField.setText(question.getQuestion());

                    answerOneTextField.setText(answers.get(0).getAnswer());
                    answerOneCheckBox.setSelected(answers.get(0).isCorrect());

                    answerTwoTextField.setText(answers.get(1).getAnswer());
                    answerTwoCheckBox.setSelected(answers.get(1).isCorrect());

                    answerThreeTextField.setText(answers.get(2).getAnswer());
                    answerThreeCheckBox.setSelected(answers.get(2).isCorrect());

                    answerFourTextField.setText(answers.get(3).getAnswer());
                    answerFourCheckBox.setSelected(answers.get(3).isCorrect());
                } else {
                    disableQuestionGrid();
                    newQuestionButton.setDisable(false);
                }
            }
        }
    }

    private void populateQuizzes() {
        ObservableList<Quiz> allQuizzesChoices = FXCollections.observableArrayList(quizzes);
        allQuizzesChoiceBox.setItems(allQuizzesChoices);

        ObservableList<Quiz> playQuizzesChoices = FXCollections.observableArrayList(quizzes);
        playQuizzesChoiceBox.setItems(playQuizzesChoices);

        if (quizzes.size() > 0) {
            playQuizzesChoiceBox.getSelectionModel().select(0);
        }
    }

    public void onNewQuizButtonClick() {
        Quiz quiz = new Quiz("Untitled");
        quizzes.add(quiz);
        populateQuizzes();

        allQuizzesChoiceBox.getSelectionModel().select(quiz);
        playQuizButton.setDisable(false);
    }

    public void onDeleteQuizButtonClick() {
        Quiz quiz = allQuizzesChoiceBox.getValue();

        if (quiz != null) {
            quizzes.remove(quiz);
            populateQuizzes();

            if (quizzes.size() > 0) {
                allQuizzesChoiceBox.getSelectionModel().select(0);
            } else {
                disableQuestionGrid();
                playQuizButton.setDisable(true);
            }
        }
    }

    public void handleQuestionGridChange() {
        Question question = quizQuestionsListView.getSelectionModel().getSelectedItem();

        if (question != null) {
            String questionQuestion = questionNameTextField.getText();

            if (!question.getQuestion().equals(questionQuestion)) {
                question.setQuestion(questionQuestion);

                handlerIsEnabled = false;
                quizQuestionsListView.getSelectionModel().clearSelection();
                quizQuestionsListView.getSelectionModel().select(question);
                handlerIsEnabled = true;
            }

            updateAnswer(answerOneTextField, answerOneCheckBox, question.getAnswers().get(0));
            updateAnswer(answerTwoTextField, answerTwoCheckBox, question.getAnswers().get(1));
            updateAnswer(answerThreeTextField, answerThreeCheckBox, question.getAnswers().get(2));
            updateAnswer(answerFourTextField, answerFourCheckBox, question.getAnswers().get(3));
        }
    }

    public void updateAnswer(TextField textField, CheckBox checkBox, Answer answer) {
        String answerAnswer = textField.getText();
        boolean answerIsCorrect = checkBox.isSelected();

        if (!answer.getAnswer().equals(answerAnswer)) {
            answer.setAnswer(answerAnswer);
        }

        if (answer.isCorrect() != answerIsCorrect) {
            answer.setCorrect(answerIsCorrect);
        }
    }

    public void onNewQuestionButtonClick() {
        Quiz quiz = allQuizzesChoiceBox.getValue();

        if (quiz != null) {
            Question question = new Question("");

            for (int i = 0; i < 4; i++) {
                question.addAnswer(new Answer("", false));
            }

            quiz.addQuestion(question);
            populateQuizzes();

            allQuizzesChoiceBox.getSelectionModel().select(quiz);
            quizQuestionsListView.getSelectionModel().select(question);
        }
    }

    public void onDeleteQuestionButtonClick() {
        Quiz quiz = allQuizzesChoiceBox.getValue();

        if (quiz != null) {
            Question question = quizQuestionsListView.getSelectionModel().getSelectedItem();

            if (question != null) {
                quiz.removeQuestion(question);
                populateQuizzes();

                allQuizzesChoiceBox.getSelectionModel().select(quiz);

                if (quiz.getQuestions().size() > 0) {
                    quizQuestionsListView.getSelectionModel().select(0);
                } else {
                    disableQuestionGrid();
                    newQuestionButton.setDisable(false);
                }
            }
        }
    }

    public void onPlayButtonQuizClick() {
        playQuizzesChoiceBox.setVisible(false);
        playQuizButton.setVisible(false);
        playQuizNameLabel.setVisible(true);

        Quiz quiz = playQuizzesChoiceBox.getSelectionModel().getSelectedItem();
        playQuizNameLabel.setText("Currently Playing: '" + quiz.getName() + "'");

        quizPlayer = new QuizPlayer(quiz);
        scoreLabel.setText(quizPlayer.getCurrentScore());

        onNextQuestionButtonClick();
    }

    public void onNextQuestionButtonClick() {
        question = quizPlayer.getNextQuestion();

        if (question != null) {
            enableAnswerQuestion();
            clearPlayCheckboxes();
            displayQuestion();
        } else {
            scoreLabel.setText(quizPlayer.getCurrentScore());
            enableAnswerResult();

            playQuizStatusLabel.setText("Quiz '" + quizPlayer.getQuiz().getName() + "' Completed. Final " + quizPlayer.getCurrentScore());
            nextQuestionButton.setVisible(false);

            playQuizNameLabel.setVisible(false);
            playQuizzesChoiceBox.setVisible(true);
            playQuizButton.setVisible(true);
        }
    }

    public void onSubmitAnswersButtonClick() {
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

        boolean isCorrect = quizPlayer.checkSubmittedAnswers(question, answers);
        scoreLabel.setText(quizPlayer.getCurrentScore());

        enableAnswerResult();
        if (isCorrect) {
            playQuizStatusLabel.setText("Correct!");
        } else {
            playQuizStatusLabel.setText("Incorrect...");
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

    private void enableQuestionGrid() {
        setQuestionGrid(false);
    }

    private void disableQuestionGrid() {
        clearQuestionGrid();
        setQuestionGrid(true);
    }

    private void setQuestionGrid(boolean disable) {
        questionNameTextField.setDisable(disable);
        answerOneTextField.setDisable(disable);
        answerOneCheckBox.setDisable(disable);
        answerTwoTextField.setDisable(disable);
        answerTwoCheckBox.setDisable(disable);
        answerThreeTextField.setDisable(disable);
        answerThreeCheckBox.setDisable(disable);
        answerFourTextField.setDisable(disable);
        answerFourCheckBox.setDisable(disable);

        newQuestionButton.setDisable(disable);
        deleteQuestionButton.setDisable(disable);
    }

    private void enableAnswerQuestion() {
        togglePlayVisibility(true, false);
    }

    private void enableAnswerResult() {
        togglePlayVisibility(false, true);
    }

    private void togglePlayVisibility(boolean answerQuestionIsVisible, boolean answerResultIsVisible) {
        playQuestionNameLabel.setVisible(answerQuestionIsVisible);
        submitAnswersButton.setVisible(answerQuestionIsVisible);

        playAnswerOneLabel.setVisible(answerQuestionIsVisible);
        playAnswerTwoLabel.setVisible(answerQuestionIsVisible);
        playAnswerThreeLabel.setVisible(answerQuestionIsVisible);
        playAnswerFourLabel.setVisible(answerQuestionIsVisible);

        playAnswerOneCheckBox.setVisible(answerQuestionIsVisible);
        playAnswerTwoCheckBox.setVisible(answerQuestionIsVisible);
        playAnswerThreeCheckBox.setVisible(answerQuestionIsVisible);
        playAnswerFourCheckBox.setVisible(answerQuestionIsVisible);

        playQuizStatusLabel.setVisible(answerResultIsVisible);
        nextQuestionButton.setVisible(answerResultIsVisible);
    }

    private void displayQuestion() {
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
    }

    private void clearPlayCheckboxes() {
        playAnswerOneCheckBox.setSelected(false);
        playAnswerTwoCheckBox.setSelected(false);
        playAnswerThreeCheckBox.setSelected(false);
        playAnswerFourCheckBox.setSelected(false);
    }
}