package ru.otus.spring01.homework_1.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.homework_1.services.LocalizationService;
import ru.otus.spring01.homework_1.services.NameService;

import java.util.Scanner;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NameServiceImpl implements NameService {

    private final Scanner sc;
    private final MessageSource messageSourceFirstLastName;
    private final LocalizationService localizationService;

    @Override
    public String askFirstLastName() {
        StringBuilder sb = new StringBuilder();
        try(sc) {
            System.out.println(localizationService.getLocalizedString(messageSourceFirstLastName, "enterFirstNameMsg"));
            sb.append(sc.nextLine());
            sb.append(" ");
            System.out.println(localizationService.getLocalizedString(messageSourceFirstLastName, "enterLastNameMsg"));
            sb.append(sc.nextLine());
        }
        return sb.toString();
    }
}
