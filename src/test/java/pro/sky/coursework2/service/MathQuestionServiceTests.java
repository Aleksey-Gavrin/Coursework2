package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.exceptions.MethodNotAllowedException;
import pro.sky.coursework2.model.Question;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MathQuestionServiceTests {

    MathQuestionService testService = new MathQuestionService();
    Question controlTestQuestion = new Question("CntrlQ", "CntrlA");

    @Test
    void add_withStringParams_negative_methodNotAllowed() {
        assertThrows(MethodNotAllowedException.class, () ->
                testService.add("TestQ1", "TestA1"));
    }

    @Test
    void add_withQuestionParam_negative_methodNotAllowed() {
        assertThrows(MethodNotAllowedException.class, () ->
                testService.add(controlTestQuestion));
    }

    @Test
    void find_negative_methodNotAllowed() {
        assertThrows(MethodNotAllowedException.class, () ->
                testService.find(controlTestQuestion));
    }

    @Test
    void remove_negative_methodNotAllowed() {
        assertThrows(MethodNotAllowedException.class, () ->
                testService.remove(controlTestQuestion));
    }

    @Test
    void get_random_question() {
        Question actualRandomQuestion = testService.getRandomQuestion();
        assertNotNull(actualRandomQuestion);
        assertTrue(actualRandomQuestion.getQuestion().contains(" = "));
        }
}
