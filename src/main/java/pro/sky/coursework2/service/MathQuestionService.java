package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.MethodNotAllowedException;
import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    @Override
    public Question getRandomQuestion() {
        String question;
        String answer;
        int x, y, operation, result;
        Random random = new Random();
        x = random.nextInt(100);
        y = random.nextInt(100);
        operation = random.nextInt(4);
        switch (operation) {
            case 0: result = x + y;
                    question = x + " + " + y + " = ";
                    answer = String.valueOf(result);
                    break;
            case 1: result = x - y;
                    question = x + " - " + y + " = ";
                    answer = String.valueOf(result);
                    break;
            case 2: result = x * y;
                    question = x + " * " + y + " = ";
                    answer = String.valueOf(result);
                    break;
            case 3: result = x / y;
                    question = x + " / " + y + " = ";
                    answer = String.valueOf(result);
                    break;
            default: question = "something";
                     answer = "wrong";
                    break;
        }
        return new Question(question, answer);
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question find(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAllQuestions() {
        throw new MethodNotAllowedException();
    }
}
