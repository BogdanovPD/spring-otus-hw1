package ru.otus.spring01.homework_1.services.impl;

import com.opencsv.CSVReader;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.QaService;

import java.io.*;
import java.net.URL;
import java.util.*;

public class QaServiceImpl implements QaService {

    private String fileName;

    public QaServiceImpl(String fileName) {
        this.fileName = fileName;
    }

    public MultiValueMap<String, String> getQuestionsAndAnswers() {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        URL resource = getClass().getClassLoader().getResource(fileName);
        try (CSVReader csvReader = new CSVReader(new FileReader(new File(resource.getFile())))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                List<String> answers = Arrays.asList(values[1].split(";"));
                multiValueMap.put(values[0], answers);
            }
        } catch (FileNotFoundException e) {
            //some logging here
        } catch (IOException e) {
            //some logging here
        }
        return multiValueMap;
    }

    @Override
    public int ask(MultiValueMap<String, String> questionsAndAnswers) {
        int[] sum = new int[1];
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Please, enter an order number of the answer (starts from 1):");
            questionsAndAnswers.forEach((q, as) -> {
                System.out.println(q.concat("???"));
                as.forEach(System.out::println);
                int input = 0;
                do {
                    if (scan.hasNextInt()) {
                        input = scan.nextInt();
                    } else {
                        scan.next();
                    }
                }
                while (input > as.size() || input < 1);
                sum[0] += input;
            });
        }
        return sum[0];
    }
}
