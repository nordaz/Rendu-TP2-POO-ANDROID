package com.example.myapplication1;

public class Preferences {
    String surname;

    public Preferences(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
