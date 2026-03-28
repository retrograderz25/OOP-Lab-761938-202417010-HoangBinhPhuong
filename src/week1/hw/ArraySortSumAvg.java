import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAvg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        double[] arr = new double[n];

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextDouble();
        }

        Arrays.sort(arr);

        double sum = 0;
        for (double num : arr) {
            sum += num;
        }
        double avg = sum / n;

        System.out.println("\nSorted array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);

        scanner.close();
    }
}