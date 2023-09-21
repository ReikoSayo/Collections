package ru.netology.javaqa.javaqamvn.services;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {
        super(message);
    }
}
