package ru.otus.spring01.homework_1.services;

import org.springframework.util.MultiValueMap;

public interface AnswerService {

    int ask(MultiValueMap<String, String> questionsAndAnswers);

}
