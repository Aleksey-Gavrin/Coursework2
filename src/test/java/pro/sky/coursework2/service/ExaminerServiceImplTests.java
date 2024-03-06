package pro.sky.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exceptions.InvalidInputException;
import pro.sky.coursework2.model.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTests {

    JavaQuestionService javaTestService = mock(JavaQuestionService.class);
    MathQuestionService mathTestService = mock(MathQuestionService.class);
    ExaminerServiceImpl testService = new ExaminerServiceImpl(javaTestService, mathTestService);
    Set<Question> actualQuestionsSet = new HashSet<>();
    Question javaTestQuestion = new Question("JavaQ", "JavaA");
    Question mathTestQuestion = new Question("MathQ", "MathA");

    @BeforeEach
    void setUp() {

        when(javaTestService.getRandomQuestion()).thenReturn(javaTestQuestion);
        when(mathTestService.getRandomQuestion()).thenReturn(mathTestQuestion);
    }

    @Test
    void get_Questions_positive_2() {

        actualQuestionsSet = testService.getQuestions(2);
        assertEquals(2, actualQuestionsSet.size());
        assertTrue(actualQuestionsSet.contains(javaTestQuestion));
        assertTrue(actualQuestionsSet.contains(mathTestQuestion));
    }

    @Test
    void get_Questions_positive_1() {

        actualQuestionsSet = testService.getQuestions(1);
        assertEquals(1, actualQuestionsSet.size());
        assertTrue(actualQuestionsSet.contains(javaTestQuestion));
    }

    @Test
    void get_Questions_negative_InvalidInput_0() {
        assertThrows(InvalidInputException.class, () ->
                testService.getQuestions(0));
    }

    @Test
    void get_Questions_negative_InvalidInput_minus() {
        assertThrows(InvalidInputException.class, () ->
                testService.getQuestions(-1));
    }

    @Test
    void get_Questions_negative_InvalidInput_over_limit() {
        assertThrows(InvalidInputException.class, () ->
                testService.getQuestions(11));
    }
}
