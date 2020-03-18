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
    public float knapsack(int n, float[] weight, float[] profit, float capacity) {
        float x[], tp = 0;
        x= new float [20];
        int i;
        int j;
        float u;
        u = capacity;

        for (i = 0; i < n; i++)
            x[i] = (float) 0.0;

        for (i = 0; i < n; i++) {
            if (weight[i] > u)
                break;
            else {
                x[i] = (float) 1.0;
                tp = tp + profit[i];
                u = u - weight[i];
            }
        }

        if (i < n)
            x[i] = u / weight[i];

        tp = tp + (x[i] * profit[i]);

        return tp;

    }

    public float getValue() {
        float weight[], profit[];
        float ratio[], temp, finalValue = (float) 0.0, Capacity, Percentage[];

        int itemsNumber,i;
        Capacity = knapsack.getCapacity();
        itemsNumber = items.size();
        weight = new float[itemsNumber];
        profit = new float[itemsNumber];
        ratio = new float[itemsNumber];
        Percentage = new float[itemsNumber];
        for (i = 0; i < itemsNumber; i++) {
            profit[i] = items.get(i).getValue();
            weight[i] = items.get(i).getWeight();
            ratio[i] = profit[i] / weight[i];
        }

        for (i = 0; i < itemsNumber; i++) {
            for (int j = i + 1; j < itemsNumber; j++) {
                if (ratio[i] < ratio[j]) {
                    temp = ratio[j];
                    ratio[j] = ratio[i];
                    ratio[i] = temp;

                    temp = weight[j];
                    weight[j] = weight[i];
                    weight[i] = temp;

                    temp = profit[j];
                    profit[j] = profit[i];
                    profit[i] = temp;
                }
            }
        }
        for (i = 0; i < itemsNumber; i++)
            Percentage[i] = (float) 0.0;

        for (i = 0; i < itemsNumber; i++) {
            if (weight[i] > Capacity)
                break;
            else {
                Percentage[i] = (float) 1.0;
                finalValue = finalValue + profit[i];
                Capacity = Capacity - weight[i];
            }
        }

        if (i < itemsNumber)
            Percentage[i] = Capacity / weight[i];
        finalValue = finalValue + (Percentage[i] * profit[i]);
        return finalValue;
    }
}