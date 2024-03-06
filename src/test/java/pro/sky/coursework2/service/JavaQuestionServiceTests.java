package pro.sky.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exceptions.QuestionAlreadyAddedException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;
import pro.sky.coursework2.exceptions.QuestionStorageIsFullException;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.JavaQuestionsRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTests {

    JavaQuestionsRepository repositoryMock = mock(JavaQuestionsRepository.class);
    JavaQuestionService testService = new JavaQuestionService(repositoryMock);
    List<Question> testQuestionsList = new ArrayList<>();
    Question controlTestQuestion = new Question("CntrlQ", "CntrlA");

    @BeforeEach
    void setUp() {

        testQuestionsList.add(new Question("TestQ1", "TestA1"));
        testQuestionsList.add(new Question("TestQ2", "TestA2"));
        testQuestionsList.add(new Question("TestQ3", "TestA3"));
        testQuestionsList.add(new Question("TestQ4", "TestA4"));
        testQuestionsList.add(new Question("TestQ5", "TestA5"));
        testQuestionsList.add(new Question("TestQ6", "TestA6"));
        testQuestionsList.add(new Question("TestQ7", "TestA7"));
        testQuestionsList.add(new Question("TestQ8", "TestA8"));
        testQuestionsList.add(new Question("TestQ9", "TestA9"));

        when(repositoryMock.getQuestionsList()).thenReturn(testQuestionsList);
        when(repositoryMock.getMAX_QUESTIONS_QTY()).thenReturn(10);
    }

    @Test
    void add_withStringParams_positive() {
        testService.add("CntrlQ", "CntrlA");
        assertEquals(10, testQuestionsList.size());
        assertEquals(controlTestQuestion, testQuestionsList.get(9));
    }

    @Test
    void add_withStringParams_negative_alreadyAdded() {
        assertThrows(QuestionAlreadyAddedException.class, () ->
                testService.add("TestQ1", "TestA1"));
    }

    @Test
    void add_withStringParams_negative_storageIsFull() {
        testService.add("TestQ10", "TestA10");
        assertThrows(QuestionStorageIsFullException.class, () ->
                testService.add("CntrlQ", "CntrlA"));
    }

    @Test
    void add_withQuestionParam_positive() {
        testService.add(controlTestQuestion);
        assertEquals(10, testQuestionsList.size());
        assertEquals("CntrlQ", testQuestionsList.get(9).getQuestion());
        assertEquals("CntrlA", testQuestionsList.get(9).getAnswer());
    }

    @Test
    void add_withQuestionParam_negative_alreadyAdded() {
        testService.add(controlTestQuestion);
        assertThrows(QuestionAlreadyAddedException.class, () ->
                testService.add(controlTestQuestion));
    }

    @Test
    void add_withQuestionParam_negative_storageIsFull() {
        testService.add("TestQ10", "TestA10");
        assertThrows(QuestionStorageIsFullException.class, () ->
                testService.add(controlTestQuestion));
    }

    @Test
    void find_positive() {
        testService.add(controlTestQuestion);
        Question actualQuestion = testService.find(controlTestQuestion);
        assertEquals(controlTestQuestion, actualQuestion);
    }

    @Test
    void find_negative_NotFound() {
        assertThrows(QuestionNotFoundException.class, () ->
                testService.find(controlTestQuestion));
    }

    @Test
    void remove_positive() {
        testService.add(controlTestQuestion);
        assertEquals(10, testQuestionsList.size());
        testService.remove(controlTestQuestion);
        assertEquals(9, testQuestionsList.size());
    }

    @Test
    void remove_negative_NotFound() {
        assertThrows(QuestionNotFoundException.class, () ->
                testService.remove(controlTestQuestion));
    }

    @Test
    void get_random_question() {
        testService.add("TestQ10", "TestA10");
        Question actualRandomQuestion = testService.getRandomQuestion();
        assertNotNull(actualRandomQuestion);
        assertTrue(actualRandomQuestion.getQuestion().contains("TestQ"));
        assertTrue(actualRandomQuestion.getAnswer().contains("TestA"));
    }
}
