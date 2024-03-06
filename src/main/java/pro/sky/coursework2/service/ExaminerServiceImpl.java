package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.InvalidInputException;
import pro.sky.coursework2.model.Question;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaService;
    private final QuestionService mathService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaService,
                               @Qualifier("mathQuestionService") QuestionService mathService) {
        this.javaService = javaService;
        this.mathService = mathService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if (amount <= 0 || 10 < amount) {
            throw new InvalidInputException();
        }
        Set<Question> questionsSet = new HashSet<>();
        if (amount == 1) {
            questionsSet.add(javaService.getRandomQuestion());
        } else {
            while (questionsSet.size() < amount) {
                questionsSet.add(javaService.getRandomQuestion());
                if (questionsSet.size() < amount) {
                    questionsSet.add(mathService.getRandomQuestion());
                }
            }
        }
        return questionsSet;
    }
}
