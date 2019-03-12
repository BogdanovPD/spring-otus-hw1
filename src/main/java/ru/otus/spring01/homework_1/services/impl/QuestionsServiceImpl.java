package ru.otus.spring01.homework_1.services.impl;

import com.opencsv.CSVReader;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.LocalizationService;
import ru.otus.spring01.homework_1.services.QuestionsService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {

    private final MessageSource messageSourceQa;
    private final LocalizationService localizationService;

    @Value("${qa.filename}")
    @Setter
    private String fileName;

    @Override
    public MultiValueMap<String, String> getQuestionsAndAnswers() {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        URL resource = getClass().getClassLoader().getResource(fileName);
        try (CSVReader csvReader = new CSVReader(new FileReader(new File(resource.getFile())))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                List<String> answers = Arrays.asList(values[1].split(";")).stream()
                        .map(a -> localizationService.getLocalizedString(messageSourceQa, a))
                        .collect(Collectors.toList());
                multiValueMap.put(localizationService.getLocalizedString(messageSourceQa, values[0]), answers);
            }
        } catch (FileNotFoundException e) {
            log.error(e.getLocalizedMessage());
        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
        return multiValueMap;
    }
}
