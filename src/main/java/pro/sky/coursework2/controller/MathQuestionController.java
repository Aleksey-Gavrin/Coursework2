package pro.sky.coursework2.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class MathQuestionController {
    private final QuestionService service;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @GetMapping(path = "/math")
    public String showInfo() {
        return "Программа для генерации случайного вопроса по математике.<br>" +
                "Команды и параметры:<br>" +
                "Команда /get без параметров выводит случайный вопрос.";
    }

    @GetMapping(path = "/math/add")
    public String add(@RequestParam("question") String question, @RequestParam("answer") String answer){
        service.add(question, answer);
        return "Вопрос успешно добавлен.";
    }

    @GetMapping(path = "/math/find")
    public String find(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question questionToFind = new Question(question, answer);
        return service.find(questionToFind).toString();
    }

    @GetMapping(path = "/math/remove")
    public String remove(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question questionToRemove = new Question(question, answer);
        service.remove(questionToRemove);
        return "Вопрос успешно удален.";
    }

    @GetMapping(path = "/math/all")
    public Collection<Question> getAll(){
        return  service.getAllQuestions();
    }

    @GetMapping(path = "/math/get")
    public String getRandomQuestion() {
        return service.getRandomQuestion().toString();
    }
}
