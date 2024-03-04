package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.QuestionAlreadyAddedException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;
import pro.sky.coursework2.exceptions.QuestionStorageIsFullException;
import pro.sky.coursework2.model.Question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final Map<Integer, Question> questionMap = new HashMap<>();
    private final int MAX_QUESTIONS_QTY = 10;

    @Override
    public Question add(String question, String answer) {
        Question currentQuestion = new Question(question, answer);
        if (questionMap.containsValue(currentQuestion)) {
            throw new QuestionAlreadyAddedException();
        }
        if (questionMap.size() == MAX_QUESTIONS_QTY) {
            throw new QuestionStorageIsFullException();
        }
        for (int i = 1; i < 11; i++) {
            if (!questionMap.containsKey(i)){
                currentQuestion.setQuestionID(i);
            }
        }
        questionMap.put(currentQuestion.getQuestionID(), currentQuestion);
        return currentQuestion;
    }

    @Override
    public Question add(Question question) {
        if (questionMap.containsValue(question)) {
            throw new QuestionAlreadyAddedException();
        }
        if (questionMap.size() == MAX_QUESTIONS_QTY) {
            throw new QuestionStorageIsFullException();
        }
        for (int i = 1; i < 11; i++) {
            if (!questionMap.containsKey(i)){
                question.setQuestionID(i);
            }
        }
        questionMap.put(question.getQuestionID(), question);
        return question;
    }

    @Override
    public Question find(Question question){
        for (int i = 1; i < 11; i++) {
            if (questionMap.get(i).equals(question)){
                return questionMap.get(i);
            }
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Question remove(Question question){
        for (int i = 1; i < 11; i++) {
            if (questionMap.get(i).equals(question)){
                return questionMap.remove(i);
            }
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll(){
        return questionMap.values().stream().toList();
    }

    @Override
    public Question getRandomQuestion(){
        Random random = new Random();
        int randomID = random.nextInt(11);
        return questionMap.get(randomID);
    }
}
