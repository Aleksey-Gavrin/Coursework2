package pro.sky.coursework2.model;

import java.util.Objects;

public class Question {

    private final String question;
    private final String answer;
    private int questionID;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.questionID = 0;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getQuestionID() {
        return questionID;
    }
    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    @Override
    public String toString() {
        return "Вопрос: " + question + "\n" + "Ответ: " + answer;
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
