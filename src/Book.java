//Each item has at least the following properties: a name, a weight and a value.
//The weight of a book is computed as the number of pages divided by 100.

public class Book implements Item {
    protected String name;
    protected int weight;
    protected  int value;

    public Book(String name, int weight, int value) {
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
        return "Book{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
