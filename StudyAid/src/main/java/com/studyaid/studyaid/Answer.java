package com.studyaid.studyaid;

public class Answer {
    private String answer;
    private boolean correct;

    public Answer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return answer;
    }

    @Override
    public boolean equals(Object object) {
        Answer answer = (Answer) object;
        boolean isEqual = false;

        if (answer != null && this.answer.equals(answer.getAnswer()) && this.correct == answer.getCorrect()) {
            isEqual = true;
        }

        return isEqual;
    }
}