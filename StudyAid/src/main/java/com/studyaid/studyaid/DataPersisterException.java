package com.studyaid.studyaid;

public class DataPersisterException extends Exception {
    private final String message;

    public DataPersisterException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}