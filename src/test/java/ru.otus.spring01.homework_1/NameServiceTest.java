package ru.otus.spring01.homework_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring01.homework_1.services.NameService;
import ru.otus.spring01.homework_1.services.UserInputService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
public class NameServiceTest {

    @Autowired
    private NameService nameService;
    @MockBean
    private UserInputService userInputService;

    @Test
    public void askFirstLastNameTest() {
        when(userInputService.getNextLine()).thenReturn("My").thenReturn("Name");
        String input = "My Name";
        String firstLastName = nameService.askFirstLastName();
        assertEquals(input, firstLastName);
    }

}
