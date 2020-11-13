package ru.grigoreva.springclientweb.models;

//используется для выделения в отдельный класс логики работы с данными
public class User {
    private String name;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private String surname;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }





}
