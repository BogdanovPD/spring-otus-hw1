package ru.otus.spring01.homework_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.MultiValueMap;
import ru.otus.spring01.homework_1.services.NameService;
import ru.otus.spring01.homework_1.services.QuestionsService;
import ru.otus.spring01.homework_1.services.UserInputService;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Main.class)
@TestPropertySource(properties = {
        "qa.filename=qa-test.csv",
        "locale=en-EN"
})
public class QuestionServiceTest {

    @Autowired
    private QuestionsService questionsService;

    @Test
    public void getQuestionsAndAnswersTest() {
        MultiValueMap<String, String> questionsAndAnswers = questionsService.getQuestionsAndAnswers();
        String q1_test = "Q1_TEST";
        assertThat(questionsAndAnswers.keySet().iterator().next(), is(q1_test));
        assertThat(questionsAndAnswers.get(q1_test), containsInAnyOrder("q1a1_test", "q1a2_test", "q1a3_test"));
    }

}
