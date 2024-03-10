package pro.sky.coursework2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.coursework2.model.Question;
import pro.sky.coursework2.service.ExaminerService;

import java.util.Set;

@RestController
public class ExamController {

    private final ExaminerService service;

    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping(path = "/exam/examiner")
    public String showInfo() {
        return "Генерация случайного списка вопросов.<br>Введите через '/' желаемое количество вопросов в диапазоне " +
                "от 1 до 10";

    }

    @GetMapping(path = "/exam/examiner/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
       return service.getQuestions(amount);
    }
}
