package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.InvalidInputException;
import pro.sky.coursework2.model.Question;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount <= 0 || 10 < amount) {
            throw new InvalidInputException();
        }
        Set<Question> questionsSet = new HashSet<>();
        while (questionsSet.size() < amount) {
           questionsSet.add(service.getRandomQuestion());
        }
        return questionsSet;
    }
}
