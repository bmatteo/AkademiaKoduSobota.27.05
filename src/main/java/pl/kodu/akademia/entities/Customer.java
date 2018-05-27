package pl.kodu.akademia.entities;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private String nationality;

    public Customer() {
    }

    public Customer(int id, String name, String surname, String nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
