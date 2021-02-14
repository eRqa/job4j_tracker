package ru.job4j.examples.professions;

public class Profession {

    private String name;
    private String surname;
    private String education;

    public Profession(String name, String surname, String education) {
        this.name = name;
        this.surname = surname;
        this.education = education;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

}
