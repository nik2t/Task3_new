package com.company;

public class Questions {
    protected String first_questions;
    protected String second_question;

    public Questions(String first_questions, String second_question) {
        this.first_questions = first_questions;
        this.second_question = second_question;
    }

    public String getFirst_questions() {
        return first_questions;
    }

    public void setFirst_questions(String first_questions) {
        this.first_questions = first_questions;
    }

    public String getSecond_question() {
        return second_question;
    }

    public void setSecond_question(String second_question) {
        this.second_question = second_question;
    }

}
