package ru.otus.spring01.homework_1.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring01.homework_1.services.MainService;

@ShellComponent
@RequiredArgsConstructor
public class QaCommands {

    private final MainService mainService;

    @ShellMethod("Runs the application")
    public void run() {
        mainService.run();
    }

}
