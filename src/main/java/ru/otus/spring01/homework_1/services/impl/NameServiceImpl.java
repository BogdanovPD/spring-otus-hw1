package ru.otus.spring01.homework_1.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.homework_1.services.LocalizationService;
import ru.otus.spring01.homework_1.services.NameService;
import ru.otus.spring01.homework_1.services.UserInputService;

@Service
@RequiredArgsConstructor
public class NameServiceImpl implements NameService {

    private final UserInputService userInputService;
    private final MessageSource messageSourceFirstLastName;
    private final LocalizationService localizationService;

    @Override
    public String askFirstLastName() {
        StringBuilder sb = new StringBuilder();
        System.out.println(localizationService.getLocalizedString(messageSourceFirstLastName, "enterFirstNameMsg"));
        sb.append(userInputService.getNextLine());
        sb.append(" ");
        System.out.println(localizationService.getLocalizedString(messageSourceFirstLastName, "enterLastNameMsg"));
        sb.append(userInputService.getNextLine());
        return sb.toString();
    }
}
