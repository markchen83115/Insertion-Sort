import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) throws Exception {
        
        Random random = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000);
        }

        System.out.println("Before:");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("After:");
        printArray(numbers);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];

            int j = i - 1;
            while (j >= 0 && currentValue < array[j]) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = currentValue;
        }
    }
}
