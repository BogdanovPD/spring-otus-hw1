package ru.otus.spring01.homework_1;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.AnswerService;
import ru.otus.spring01.homework_1.services.LocalizationService;
import ru.otus.spring01.homework_1.services.NameService;
import ru.otus.spring01.homework_1.services.QuestionsService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        NameService nameService = context.getBean(NameService.class);
        String firstLastName = nameService.askFirstLastName();
        QuestionsService questionsService = context.getBean(QuestionsService.class);
        MultiValueMap<String, String> questionsAndAnswers = questionsService.getQuestionsAndAnswers();
        AnswerService answerService = context.getBean(AnswerService.class);
        int sum = answerService.ask(questionsAndAnswers);
        MessageSource messageSourceQa = context.getBean("messageSourceQa", MessageSource.class);
        LocalizationService localizationService = context.getBean(LocalizationService.class);
        System.out.println(localizationService.getLocalizedStringWithParameters(messageSourceQa, "congratsMsg",
                new String[] {String.valueOf(sum), firstLastName}));
    }
}
