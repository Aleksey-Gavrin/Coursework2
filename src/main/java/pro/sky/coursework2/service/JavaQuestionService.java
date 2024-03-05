package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.exceptions.QuestionAlreadyAddedException;
import pro.sky.coursework2.exceptions.QuestionNotFoundException;
import pro.sky.coursework2.exceptions.QuestionStorageIsFullException;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.repository.JavaQuestionsRepository;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionsRepository javaRepository;

    public JavaQuestionService(JavaQuestionsRepository javaRepository) {
        this.javaRepository = javaRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question currentQuestion = new Question(question, answer);
        if (javaRepository.getQuestionsList().contains(currentQuestion)) {
            throw new QuestionAlreadyAddedException();
        }
        if (javaRepository.getQuestionsList().size() == javaRepository.getMAX_QUESTIONS_QTY()) {
            throw new QuestionStorageIsFullException();
        }
        javaRepository.getQuestionsList().add(currentQuestion);
        return currentQuestion;
    }

    @Override
    public Question add(Question question) {
        if (javaRepository.getQuestionsList().contains(question)) {
            throw new QuestionAlreadyAddedException();
        }
        if (javaRepository.getQuestionsList().size() == javaRepository.getMAX_QUESTIONS_QTY()) {
            throw new QuestionStorageIsFullException();
        }
        javaRepository.getQuestionsList().add(question);
        return question;
    }

    @Override
    public Question find(Question question){
        if (javaRepository.getQuestionsList().contains(question)) {
            return javaRepository.getQuestionsList().get(javaRepository.getQuestionsList().indexOf(question));
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Question remove(Question question){
        for (Question q: javaRepository.getQuestionsList()) {
            if (q.equals(question)){
                javaRepository.getQuestionsList().remove(q);
                return question;
            }
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAllQuestions(){
        return Collections.unmodifiableList(javaRepository.getQuestionsList());
    }

    @Override
    public Question getRandomQuestion(){
        Random random = new Random();
        int randomID = random.nextInt(10);
        return javaRepository.getQuestionsList().get(randomID);
    }
}
