public class DSAas {
    static class FenwickTree {
        private final long[] tree;

        FenwickTree(int[] numbers) {
            tree = new long[numbers.length + 1];

            for (int index = 0; index < numbers.length; index++) {
                add(index, numbers[index]);
            }
        }

        void add(int index, long change) {
            for (int position = index + 1; position < tree.length;
                 position += position & -position) {
                tree[position] += change;
            }
        }

        long prefixSum(int count) {
            long sum = 0;

            for (int position = count; position > 0;
                 position -= position & -position) {
                sum += tree[position];
            }

            return sum;
        }

        long rangeSum(int left, int right) {
            return prefixSum(right + 1) - prefixSum(left);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        FenwickTree sums = new FenwickTree(numbers);

        System.out.println(sums.rangeSum(1, 3));

        sums.add(2, 5);

        System.out.println(sums.rangeSum(1, 3));
    }
}