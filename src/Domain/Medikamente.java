package src.Domain;

public class Medikamente implements HasID {
    Integer id;
    String name;
    Integer price;
    String krankheit;

    public Medikamente(Integer id, String name, Integer price, String krankheit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.krankheit = krankheit;
    }

    public String getKrankheit() {
        return krankheit;
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + krankheit;
    }
}
