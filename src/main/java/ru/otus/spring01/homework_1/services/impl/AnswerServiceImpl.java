package ru.otus.spring01.homework_1.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.AnswerService;
import ru.otus.spring01.homework_1.services.LocalizationService;

import java.io.FilterInputStream;
import java.util.Scanner;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AnswerServiceImpl implements AnswerService {

    private final Scanner sc;
    private final MessageSource messageSourceQa;
    private final LocalizationService localizationService;

    @Override
    public int ask(MultiValueMap<String, String> questionsAndAnswers) {
        int[] sum = new int[1];
        try (sc) {
            System.out.println(localizationService.getLocalizedString(messageSourceQa, "introMsg"));
            questionsAndAnswers.forEach((q, as) -> {
                System.out.println(q.concat("???"));
                as.forEach(System.out::println);
                int input = 0;
                do {
                    if (sc.hasNextInt()) {
                        input = sc.nextInt();
                    } else {
                        sc.next();
                    }
                }
                while (input > as.size() || input < 1);
                sum[0] += input;
            });
        }
        return sum[0];
    }
}
