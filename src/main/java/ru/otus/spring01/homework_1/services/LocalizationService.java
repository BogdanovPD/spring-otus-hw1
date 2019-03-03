package ru.otus.spring01.homework_1.services;

import org.springframework.context.MessageSource;

public interface LocalizationService {

    String getLocalizedString(MessageSource ms, String s);
    String getLocalizedStringWithParameters(MessageSource ms, String s, String[] parameters);

}
