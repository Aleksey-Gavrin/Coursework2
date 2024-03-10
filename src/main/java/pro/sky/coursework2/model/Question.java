package pro.sky.coursework2.model;

import java.util.Objects;

public class Question {

    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "Вопрос: " + question + "<br>" + "Ответ: " + answer;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question q = (Question) obj;
        return Objects.equals(question, q.question) && Objects.equals(answer, q.answer);
    }

    @Override
    public int hashCode(){
        return java.util.Objects.hash(question, answer);
    }
}
