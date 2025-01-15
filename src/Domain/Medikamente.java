package src.Domain;

/**
 * Medics Object with its attributes
 */
public class Medikamente implements HasID {
    Integer id;
    String name;
    Integer price;
    String krankheit;

    /**
     * @param id a unique identifier
     * @param name the name of the medicine
     * @param price the price of the medicine
     * @param krankheit the illness the medicine can cure
     */
    public Medikamente(Integer id, String name, Integer price, String krankheit) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.krankheit = krankheit;
    }

    /**
     * @return the illness
     */
    public String getKrankheit() {
        return krankheit;
    }

    /**
     * @return the medicine price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @return the medicine ID
     */
    @Override
    public Integer getID() {
        return id;
    }

    /**
     * @return a string with the medicine data
     */
    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + krankheit;
    }
}
