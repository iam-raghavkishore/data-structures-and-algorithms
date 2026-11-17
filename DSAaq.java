import java.util.Arrays;

public class DSAaq {
    static void mergeSort(int[] numbers, int[] buffer, int start, int end) {
        // The range includes start and excludes end.
        if (end - start <= 1) {
            return;
        }

        int middle = start + (end - start) / 2;
        mergeSort(numbers, buffer, start, middle);
        mergeSort(numbers, buffer, middle, end);

        int left = start;
        int right = middle;
        int write = start;

        while (left < middle && right < end) {
            if (numbers[left] <= numbers[right]) {
                buffer[write++] = numbers[left++];
            } else {
                buffer[write++] = numbers[right++];
            }
        }

        while (left < middle) {
            buffer[write++] = numbers[left++];
        }

        while (right < end) {
            buffer[write++] = numbers[right++];
        }

        System.arraycopy(buffer, start, numbers, start, end - start);
    }

    public static void main(String[] args) {
        int[] numbers = {8, 3, 7, 1, 5, 2};

        mergeSort(numbers, new int[numbers.length], 0, numbers.length);

        System.out.println(Arrays.toString(numbers));
    }
}