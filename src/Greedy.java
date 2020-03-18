import java.util.ArrayList;
import java.util.List;

public class Greedy implements Algorithm {
    protected Knapsack knapsack;
    protected List<Item> items = new ArrayList<>();
    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Greedy(Knapsack knapsack,List<Item> items) {
        this.knapsack = knapsack;
        this.items = items;
    }

    public float getValue() {
        float Weight[], Profit[];
        float Ratio[], temp, finalValue = (float) 0.0, Capacity, Percentage[];

        int itemsNumber,i;
        Capacity = knapsack.getCapacity();
        itemsNumber = items.size();
        Weight = new float[itemsNumber];
        Profit = new float[itemsNumber];
        Ratio = new float[itemsNumber];
        Percentage = new float[itemsNumber];
        for (i = 0; i < itemsNumber; i++) {
            Profit[i] = items.get(i).getValue();
            Weight[i] = items.get(i).getWeight();
            Ratio[i] = Profit[i] / Weight[i];
        }

        for (i = 0; i < itemsNumber; i++) {
            for (int j = i + 1; j < itemsNumber; j++) {
                if (Ratio[i] < Ratio[j]) {
                    temp = Ratio[j];
                    Ratio[j] = Ratio[i];
                    Ratio[i] = temp;

                    temp = Weight[j];
                    Weight[j] = Weight[i];
                    Weight[i] = temp;

                    temp = Profit[j];
                    Profit[j] = Profit[i];
                    Profit[i] = temp;
                }
            }
        }
        for (i = 0; i < itemsNumber; i++)
            Percentage[i] = (float) 0.0;

        for (i = 0; i < itemsNumber; i++) {
            if (Weight[i] > Capacity)
                break;
            else {
                Percentage[i] = (float) 1.0;
                finalValue = finalValue + Profit[i];
                Capacity = Capacity - Weight[i];
            }
        }

        if (i < itemsNumber)
            Percentage[i] = Capacity / Weight[i];
        finalValue = finalValue + (Percentage[i] * Profit[i]);
        return finalValue;
    }
}