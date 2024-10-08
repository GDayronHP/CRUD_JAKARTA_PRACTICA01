package com.tecsup.prj_fastquiz.modelo.entities;

public class IAAnswers {
    private int id;
    private String answerText; // Texto de la respuesta
    private boolean isCorrect; // Si es correcta o no (true = correcta, false = incorrecta)
    private int questionId; // Foreign key para la tabla IAQuestion

    // Constructor vacío
    public IAAnswers() {}

    // Constructor con parámetros
    public IAAnswers(int id, String answerText, boolean isCorrect, int questionId) {
        this.id = id;
        this.answerText = answerText;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "IAAnswers{" +
                "id=" + id +
                ", answerText='" + answerText + '\'' +
                ", isCorrect=" + isCorrect +
                ", questionId=" + questionId +
                '}';
    }
}
