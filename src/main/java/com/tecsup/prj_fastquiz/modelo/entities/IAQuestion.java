package com.tecsup.prj_fastquiz.modelo.entities;

public class IAQuestion {
    private int id;
    private String questionText; // Texto de la pregunta
    private String timeLimit; // Límite de tiempo para responder
    private int quizId; // Foreign key para la tabla Quizizz
    private int questionTypeId; // Foreign key para la tabla QuestionType

    // Constructor vacío
    public IAQuestion() {}

    // Constructor con parámetros
    public IAQuestion(int id, String questionText, String timeLimit, int quizId, int questionTypeId) {
        this.id = id;
        this.questionText = questionText;
        this.timeLimit = timeLimit;
        this.quizId = quizId;
        this.questionTypeId = questionTypeId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    @Override
    public String toString() {
        return "IAQuestion{" +
                "id=" + id +
                ", questionText='" + questionText + '\'' +
                ", timeLimit='" + timeLimit + '\'' +
                ", quizId=" + quizId +
                ", questionTypeId=" + questionTypeId +
                '}';
    }
}
