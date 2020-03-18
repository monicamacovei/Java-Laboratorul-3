//Each item has at least the following properties: a name, a weight and a value.
//The name of a weapon is actually its type, described by an enum

public class Weapon implements Item {
    protected String name;
    protected int weight;
    protected int value;

    public Weapon(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
    public int profitFactor() {
        return this.value/this.weight;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
