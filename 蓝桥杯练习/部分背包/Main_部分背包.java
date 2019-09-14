import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_部分背包 {


    static class Item {

        int value;
        int weight;
        double costPerformance;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.costPerformance = value / (weight * 1.0);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int capacity = scanner.nextInt();
        int res = 0;
        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            items[i] = new Item(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item itemO1, Item itemO2) {
                return (int) (itemO2.costPerformance - itemO1.costPerformance);
            }
        });
        for (int i = 0; capacity > 0 || i < N; i++) {
            capacity -= items[i].weight;
            if (capacity <= 0) {
                res += (capacity += items[i].weight) * items[i].costPerformance;
                break;
            }
            res += items[i].value;
        }
    }


}
