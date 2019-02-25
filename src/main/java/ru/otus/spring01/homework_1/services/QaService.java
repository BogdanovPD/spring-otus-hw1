package ru.otus.spring01.homework_1.services;

import org.springframework.util.MultiValueMap;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface QaService {

    MultiValueMap<String, String> getQuestionsAndAnswers();
    int ask(MultiValueMap<String, String> questionsAndAnswers);

}
