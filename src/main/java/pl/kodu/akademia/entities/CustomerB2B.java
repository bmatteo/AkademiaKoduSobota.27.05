package pl.kodu.akademia.entities;

import javax.persistence.*;

@Entity
@Table(name = "tcustomerB2B")
public class CustomerB2B {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "nip")
    private String nip;
    @Column(name = "nationality")
    private String nationality;

    public CustomerB2B() {
    }

    public CustomerB2B(int id, String name, String nip, String nationality) {
        this.id = id;
        this.name = name;
        this.nip = nip;
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

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
