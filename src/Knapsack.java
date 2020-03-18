//Consider a knapsack of a given capacity and a set of items that could be added in the knapsack
//The profit factor of an item is defined as value / weight.
/*
available items:
     book1: Dragon Rising, weight = 3, value = 5 (profit factor = 1.66)
     book2: A Blade in the Dark, weight = 3, value = 5
     food1: Cabbage, weight = 2, value = 4 (profit factor = 2)
     food2: Rabbit, weight = 2, value = 4
     weapon: Sword, weight = 5, value = 10 (profit factor = 2)
 */

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    protected int capacity;
    protected int totalWeight;
    protected int totalValue;
    protected List<Item> items = new ArrayList();
    public Knapsack(int capacity) {
        this.capacity=capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(Item ... items) {
        for(Item item : items) {
            this.items.add(item);
            this.totalWeight = this.totalWeight + item.getWeight();
            this.totalValue = this.totalValue + item.getValue();
        }
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getCapacity() {
        return capacity;
    }
}
