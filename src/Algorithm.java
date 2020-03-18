import java.util.List;

public interface Algorithm {
    void setKnapsack(Knapsack knapsack);
    void setItems(List<Item> items);
    float getValue();
}
