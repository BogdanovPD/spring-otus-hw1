package ru.otus.spring01.homework_1.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.homework_1.services.LocalizationService;

import java.util.Locale;

@Service
public class LocalizationServiceImpl implements LocalizationService {

    @Value("${locale}")
    private String locale;

    @Override
    public String getLocalizedString(MessageSource ms, String s) {
        String[] localeParts = locale.split("-");
        return ms.getMessage(s, null, new Locale(localeParts[0], localeParts[1]));
    }

    @Override
    public String getLocalizedStringWithParameters(MessageSource ms, String s, String[] parameters) {
        String[] localeParts = locale.split("-");
        return ms.getMessage(s, parameters, new Locale(localeParts[0], localeParts[1]));
    }
}
