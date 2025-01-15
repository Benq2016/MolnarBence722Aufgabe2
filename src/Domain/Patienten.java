package src.Domain;

import java.util.List;

public class Patienten implements HasID {
    Integer id;
    String name;
    Integer age;
    String diagnose;
    List<Medikamente> medikamente;

    public Patienten(Integer id, String name, Integer age, String diagnose, List<Medikamente> medikamente) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnose = diagnose;
        this.medikamente = medikamente;
    }

    public List<Medikamente> getMedikamente() {
        return medikamente;
    }

    public String getDiagnose() {
        return diagnose;
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + diagnose + " " + medikamente;
    }
}
