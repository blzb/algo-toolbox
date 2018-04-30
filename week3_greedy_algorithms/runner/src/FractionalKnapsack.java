import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        //write your code here
        double totalValue = 0;
        Item items[] = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        Arrays.sort(items, (o1, o2) -> Double.compare(o2.unitValue, o1.unitValue));
        int current = 0;
        while (capacity > 0 && current < items.length) {
            if (capacity > items[current].weight) {
                totalValue = totalValue + items[current].value;
                capacity = capacity - items[current].weight;
            } else {
                totalValue = totalValue + items[current].unitValue * capacity;
                capacity = 0;
            }
            current++;
        }
        return totalValue;
    }

    private static class Item {
        int value;
        int weight;
        double unitValue;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.unitValue = ((double) value / (double) weight);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
