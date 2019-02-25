package ru.otus.spring01.homework_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.QaService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        QaService qaService = context.getBean(QaService.class);
        MultiValueMap<String, String> questionsAndAnswers = qaService.getQuestionsAndAnswers();
        int sum = qaService.ask(questionsAndAnswers);
        System.out.println("Your result is " + sum + "! Congratulations!");
    }
}
