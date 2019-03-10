package ru.otus.spring01.homework_1.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.*;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

    private final NameService nameService;
    private final QuestionsService questionsService;
    private final AnswerService answerService;
    private final LocalizationService localizationService;
    private final MessageSource messageSourceQa;

    @Override
    public void run() {
        String firstLastName = nameService.askFirstLastName();
        MultiValueMap<String, String> questionsAndAnswers = questionsService.getQuestionsAndAnswers();
        int sum = answerService.ask(questionsAndAnswers);
        System.out.println(getFinalMessage(sum, firstLastName));
    }

    @Override
    public String getFinalMessage(int sum, String firstLastName) {
        return localizationService.getLocalizedStringWithParameters(messageSourceQa, "congratsMsg",
                new String[] {String.valueOf(sum), firstLastName});
    }
}
