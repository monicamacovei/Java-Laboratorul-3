import java.util.ArrayList;
import java.util.List;

public class Dynamic implements Algorithm {
    protected Knapsack knapsack;
    protected List<Item> items = new ArrayList<>();

    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Dynamic(Knapsack knapsack,List<Item> items) {
        this.knapsack = knapsack;
        this.items = items;
    }

    public float getValue() {
        int Weight, Value, Capacity, itemsNumber;
        Capacity = knapsack.getCapacity();
        itemsNumber = items.size();
        if (itemsNumber <= 0 || Capacity <= 0) {
            return 0;
        }

        int[][] finalValue = new int[itemsNumber + 1][Capacity + 1];
        for (int j = 0; j <= Capacity; j++) {
            finalValue[0][j] = 0;
        }

        for (int i = 1; i <= itemsNumber; i++) {
            for (int j = 1; j <= Capacity; j++) {
                Weight = items.get(i-1).getWeight();
                Value = items.get(i-1).getValue();

                if (Weight > j) {
                    finalValue[i][j] = finalValue[i - 1][j];
                } else {
                    finalValue[i][j] = Math.max(finalValue[i - 1][j], finalValue[i - 1][j - Weight] + Value);
                }
            }
        }
        return finalValue[itemsNumber][Capacity];
    }
}
