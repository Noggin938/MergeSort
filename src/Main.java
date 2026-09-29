import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Assist from ChatGPT
        //
        // Lab Work: Ask the user how many integer numbers to be sorted
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers to be sorted: ");
        int input_size = scanner.nextInt();

        // Declare the array and populate the array
        int[] input = new int[input_size];

        // Take input from the user using a loop
        for (int i = 0; i < input_size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            input[i] = scanner.nextInt();
        }

        // Display the original array
        System.out.println("\nOriginal array:");
        for (int value : input) {
            System.out.print(value + " ");
        }

        int low = 0;
        int high = input.length - 1;

        // Sort the array
        MergeSort(input, low, high);

        // Display the sorted array
        System.out.println("\n\nSorted array:");
        for (int value : input) {
            System.out.print(value + " ");
        }

        scanner.close();
    }

    public static void MergeSort(int[] A, int low, int high) {
        if (low < high) {

            // Divide
            int mid = low + (high - low) / 2;

            MergeSort(A, low, mid);
            MergeSort(A, mid + 1, high);

            // Merge the two sorted subarrays
            Merge(A, low, mid, high);
        }
    }

    public static void Merge(int[] A, int low, int mid, int high) {

        // Temporary array
        int[] temp = new int[high - low + 1];

        int i = low;       // Beginning of left subarray
        int j = mid + 1;   // Beginning of right subarray
        int k = 0;         // Index for temporary array

        // Compare elements from both subarrays
        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                temp[k] = A[i];
                i++;
            } else {
                temp[k] = A[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left subarray
        while (i <= mid) {
            temp[k] = A[i];
            i++;
            k++;
        }

        // Copy remaining elements from the right subarray
        while (j <= high) {
            temp[k] = A[j];
            j++;
            k++;
        }

        // Copy the sorted temporary array back into A
        for (k = 0; k < temp.length; k++) {
            A[low + k] = temp[k];
        }
    }

}
