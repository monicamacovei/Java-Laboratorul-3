import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack(10);
        Knapsack knapsackDynamic = new Knapsack(8);
        List<Item> items = new ArrayList<>();
        Item book1 = new Book("Dragon Rising", 3, 5);
        items.add(book1);
        Item book2 = new Book("A Blade in the Dark",3,5);
        items.add(book2);
        Item food1 = new Food("Cabbage",2,4);
        items.add(food1);
        Item food2 = new Food("Rabbit",2,4);
        items.add(food2);
        Item weapon = new Weapon("Sword",5,10);
        items.add(weapon);
        knapsack.setItems(book1, food1, weapon);
        System.out.println(knapsack.getItems());

        Algorithm firstAlgorithm = new Greedy(knapsack,items);
        System.out.println("Final value with greedy algorithm: " + firstAlgorithm.getValue());
        Algorithm secondAlgorithm = new Dynamic(knapsackDynamic,items);
        System.out.println("Final value with dynamic programming: " + secondAlgorithm.getValue());
    }
}
