
import java.util.Arrays;

public class Main {

    public static int smallest(int[] array) {
        int[] temp = array.clone();
        int min_i = 0;
        int min = temp[0];

        for (int i = 1; i < temp.length; i++) {
            if (temp[i] < min) {
                min_i = i;
                min = temp[i];
            }
        }

        return temp[min_i];
    }

    public static int indexOfTheSmallest(int[] array) {
        // code goes here
        int smallest = smallest(array);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == smallest) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int[] newArray = new int[array.length - index];
        int[] indexes = new int[newArray.length];
        int counter = 0;

        for (int i = index; i < array.length; i++) {
            newArray[counter] = array[i];
            indexes[counter] = i;
            counter++;
        }

        int smallest = indexOfTheSmallest(newArray);

        return indexes[smallest];

    }

    public static void swap(int[] array, int index1, int index2) {
        int a = array[index1];
        int b = array[index2];

        array[index1] = b;
        array[index2] = a;

    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = indexOfTheSmallestStartingFrom(array, i);
            swap(array, temp, i);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);

    }

}
