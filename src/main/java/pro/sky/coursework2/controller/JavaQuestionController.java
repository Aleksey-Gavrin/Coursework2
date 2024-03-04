package pro.sky.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.Coursework2Application;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class JavaQuestionController {

    private final JavaQuestionService service = Coursework2Application.service;

    public JavaQuestionController() {
    }

    @GetMapping
    public String showInfo() {
        return "Программа для генерации списка вопросов по языку Java.<br>" +
                "Команды и параметры:<br>" +
                "/java/add?question=...&answer=...<br>" +
                "/java/find?question=...&answer=...<br>" +
                "/java/remove?question=...&answer=...<br>" +
                "Команда /java без параметров выводит полний список вопросов.";
    }

    @GetMapping(path = "/java/add")
    public String add(@RequestParam("question") String question, @RequestParam("answer") String answer){
        service.add(question, answer);
        return "Вопрос успешно добавлен.";
    }

    @GetMapping(path = "/java/find")
    public String find(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question questionToFind = new Question(question, answer);
        return service.find(questionToFind).toString();
    }

    @GetMapping(path = "/java/remove")
    public String remove(@RequestParam("question") String question, @RequestParam("answer") String answer){
        Question questionToRemove = new Question(question, answer);
        service.remove(questionToRemove);
        return "Вопрос успешно удален.";
    }

    @GetMapping(path = "/java")
    public Collection<Question> getAll(){
        return  service.getAll();
    }
}
