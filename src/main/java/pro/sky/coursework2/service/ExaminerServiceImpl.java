package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.InvalidInputException;
import pro.sky.coursework2.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> services;

    public ExaminerServiceImpl(List<QuestionService> services) {
        this.services = services;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount <= 0 || 10 < amount) {
            throw new InvalidInputException();
        }
        Set<Question> questionsSet = new HashSet<>();
        if (amount == 1) {
            questionsSet.add(services.get(0).getRandomQuestion());
        } else {
            Random random = new Random();
            while (questionsSet.size() < amount) {
                int index = random.nextInt(services.size());
                questionsSet.add(services.get(index).getRandomQuestion());
            }
        }
        return questionsSet;
    }
}
