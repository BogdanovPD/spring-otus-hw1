package ru.otus.spring01.homework_1.services.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring01.homework_1.services.UserInputService;

import javax.annotation.PreDestroy;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

@Service
public class UserInputServiceImpl implements UserInputService {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String getNextLine() {
        return scanner.nextLine();
    }

    @Override
    public int getNextInt() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
            }
        }
    }

    @PreDestroy
    public void destroy() {
        scanner.close();
    }
}
