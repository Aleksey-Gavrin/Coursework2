package pro.sky.coursework2.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pro.sky.coursework2.model.Question;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JavaQuestionsRepository {

    private final List<Question> questionsList = new ArrayList<>();
	public static final int MAX_QUESTIONS_QTY = 10;

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    @PostConstruct
    public void init() {
        questionsList.add(new Question("Продолжите фразу. Если в цикле for первое и последнее условие пустые, то...",
                "такой цикл можно заменить на цикл while"));
        questionsList.add(new Question("Что такое индекс?",
                "номер ячейки массива"));
		questionsList.add(new Question("Как происходит нумерация индексов в массиве?",
                "с нуля"));
		questionsList.add(new Question("Что такое Exception'ы?",
                "ошибки в Java"));
		questionsList.add(new Question("Продолжите фразу. Итерация — это...",
                "очередной проход цикла"));
		questionsList.add(new Question("Как создать строку?",
                "с помощью присваивания String текстового значения в кавычках"));
		questionsList.add(new Question("Что такое метод?",
                "код, который решает определенную задачу и может использоваться" +
				" много раз в разных местах"));
		questionsList.add(new Question("Что такое пул строк?",
                "механизм, который позволяет хранить в памяти компьютера" +
				" только один экземпляр строки с идентичным содержанием"));
		questionsList.add(new Question("Что такое переиспользование кода?",
                "использование существующего метода в новом коде"));
		questionsList.add(new Question("Как можно сравнивать объекты?",
                "с помощью метода equals"));
    }
}
