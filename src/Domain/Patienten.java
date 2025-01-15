package src.Domain;

import java.util.List;

/**Object Patient with its attributes*/
public class Patienten implements HasID {
    Integer id;
    String name;
    Integer age;
    String diagnose;
    List<Medikamente> medikamente;

    /**Constructor for the Patient Object
     * @param id a unique identifier
     * @param name a name for the person
     * @param age the age of the person
     * @param diagnose the diagnosed illness
     * @param medikamente a list of prescribed medics
     */
    public Patienten(Integer id, String name, Integer age, String diagnose, List<Medikamente> medikamente) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnose = diagnose;
        this.medikamente = medikamente;
    }

    /**
     * @return a list of prescribed medics
     */
    public List<Medikamente> getMedikamente() {
        return medikamente;
    }

    /**
     * @return the diagnosis
     */
    public String getDiagnose() {
        return diagnose;
    }

    /**
     * @return returns the id of the patient
     */
    @Override
    public Integer getID() {
        return id;
    }

    /**
     * @return a string of the patient data
     */
    @Override
    public String toString() {
        return id + " " + name + " " + age + " " + diagnose + " " + medikamente;
    }
}
