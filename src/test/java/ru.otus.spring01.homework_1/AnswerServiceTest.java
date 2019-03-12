package ru.otus.spring01.homework_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring01.homework_1.services.AnswerService;
import ru.otus.spring01.homework_1.services.QuestionsService;
import ru.otus.spring01.homework_1.services.UserInputService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
@TestPropertySource(properties = {
        "qa.filename=qa-test.csv",
        "locale=en-EN"
})
public class AnswerServiceTest {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private AnswerService answerService;
    @MockBean
    private UserInputService userInputService;

    @Test
    public void askFirstLastNameTest() {
        when(userInputService.getNextInt()).thenReturn(1);
        int result = answerService.ask(questionsService.getQuestionsAndAnswers());
        assertEquals(result, 1);
    }

}
