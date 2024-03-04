package pro.sky.coursework2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.coursework2.service.JavaQuestionService;

@SpringBootApplication
public class Coursework2Application {

	public static final JavaQuestionService service = new JavaQuestionService();

	public static void main(String[] args) {

		SpringApplication.run(Coursework2Application.class, args);


		service.add("Продолжите фразу. Если в цикле for первое и последнее условие пустые, то...",
				"такой цикл можно заменить на цикл while");
		service.add("Что такое индекс?", "номер ячейки массива");
		service.add("Как происходит нумерация индексов в массиве?", "с нуля");
		service.add("Что такое Exception'ы?", "ошибки в Java");
		service.add("Продолжите фразу. Итерация — это...", "очередной проход цикла");
		service.add("Как создать строку?", "с помощью присваивания String текстового значения в кавычках");
		service.add("Что такое метод?", "код, который решает определенную задачу и может использоваться" +
				" много раз в разных местах");
		service.add("Что такое пул строк?", "механизм, который позволяет хранить в памяти компьютера" +
				" только один экземпляр строки с идентичным содержанием");
		service.add("Что такое переиспользование кода?", "использование существующего метода в новом коде");
		service.add("Как можно сравнивать объекты?", "с помощью метода equals");
	}

}
