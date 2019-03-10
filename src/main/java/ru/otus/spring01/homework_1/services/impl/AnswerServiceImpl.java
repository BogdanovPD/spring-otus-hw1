package ru.otus.spring01.homework_1.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.AnswerService;
import ru.otus.spring01.homework_1.services.LocalizationService;
import ru.otus.spring01.homework_1.services.UserInputService;

import java.util.Scanner;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final UserInputService userInputService;
    private final MessageSource messageSourceQa;
    private final LocalizationService localizationService;

    @Override
    public int ask(MultiValueMap<String, String> questionsAndAnswers) {
        int[] sum = new int[1];
            System.out.println(localizationService.getLocalizedString(messageSourceQa, "introMsg"));
            questionsAndAnswers.forEach((q, as) -> {
                System.out.println(q.concat("???"));
                as.forEach(System.out::println);
                int input;
                do {
                    input = userInputService.getNextInt();
                }
                while (input > as.size() || input < 1);
                sum[0] += input;
            });
        return sum[0];
    }
}
