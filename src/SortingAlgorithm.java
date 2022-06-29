import java.util.Random;

public class SortingAlgorithm {
    public static void main(String[] args) throws Exception {
        
        Random random = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Before:");
        printArray(numbers);

        //bubbleSort(numbers);
        //insertionSort(numbers);
        //selectionSort(numbers);
        //mergeSort(numbers);
        //quickSort(numbers, 0 , numbers.length-1);
        heapSort(numbers);

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

    private static void bubbleSort (int[] array) {
        int tmp = 0;
        boolean swaped = true;
        while (swaped) {
            swaped = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    swaped = true;
                }
            }
        }
    }

    private static void selectionSort (int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            //swap
            int tmp = array[i];
            array[i] = min;
            array[minIndex] = tmp;
        }
    }

    private static void mergeSort (int[] array) {
        int length = array.length;
        if (length <=1)
            return;

        int midIndex = length / 2;
        int[] leftArray = new int[midIndex];
        int[] rightArray = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftArray[i] = array[i];
        }
        for (int i = midIndex; i < length; i++) {
            rightArray[i - midIndex] = array[i];
        }

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(array, leftArray, rightArray);
        
    }

    private static void merge (int[] array, int[] leftArray, int[] rightArray) {
        int leftLen = leftArray.length;
        int rightLen = rightArray.length;
        int i = 0, j = 0, k = 0;

        while (i < leftLen && j < rightLen) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < leftLen) {
            array[k++] = leftArray[i++];
        }
        while (j < rightLen) {
            array[k++] = rightArray[j++];
        }
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (end <= begin)
            return;
        int pivit = partition(array, begin, end);
        quickSort(array, begin, pivit-1);
        quickSort(array, pivit+1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        int pivit = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivit]) {
                int tmp = array[counter];
                array[counter] = array[i];
                array[i] = tmp;
                counter++;
            }
        }

        int tmp = array[pivit];
        array[pivit] = array[counter];
        array[counter] = tmp;

        return counter;
    }

    private static void heapSort(int[] array) {
        if (array.length == 0) 
            return;

        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        for (int i = length - 1; i > 0; i--) {
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int length, int i) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int largest = i;

        if (leftChild < length && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < length && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (i != largest) {
            int tmp = array[i];
            array[i] = array[largest];
            array[largest] = tmp;
            heapify(array, length, largest);
        }
    }
}
