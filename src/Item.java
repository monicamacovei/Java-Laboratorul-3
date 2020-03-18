//The interface should have at least one default method, for example profitFactor.

//the total weight of the selected items is less than or equal to the capacity and
//the total value is as large as possible.

public interface Item {
    int  profitFactor();

    int getWeight();

    int getValue();

    String getName();
}
