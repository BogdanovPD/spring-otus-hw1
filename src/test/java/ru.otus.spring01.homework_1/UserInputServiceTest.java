package ru.otus.spring01.homework_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring01.homework_1.services.NameService;
import ru.otus.spring01.homework_1.services.UserInputService;
import ru.otus.spring01.homework_1.services.impl.UserInputServiceImpl;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
public class UserInputServiceTest {

    @Test
    public void getNextLineTest() {
        String test = "Test";
        System.setIn(new ByteArrayInputStream(test.getBytes()));
        UserInputServiceImpl inputService = new UserInputServiceImpl();
        assertEquals(inputService.getNextLine(), test);
    }

    @Test
    public void getNextIntTest() {
        int testInt = 100;
        String test = "Test\n" + testInt;
        System.setIn(new ByteArrayInputStream(test.getBytes()));
        UserInputServiceImpl inputService = new UserInputServiceImpl();
        assertEquals(inputService.getNextInt(), testInt);
    }

}
