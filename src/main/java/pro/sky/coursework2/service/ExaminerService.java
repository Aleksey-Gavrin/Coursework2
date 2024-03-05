package pro.sky.coursework2.service;

import pro.sky.coursework2.model.Question;

import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
