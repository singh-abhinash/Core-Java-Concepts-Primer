package JavaCollections;

public class TwoDArrayOperations {

    public static void main(String[] args) {
        // 1. Declare and initialize a 3x3 matrix
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int rows = arr.length;
        int cols = arr[0].length;

        // 2. Traverse and print the matrix
        System.out.println("Original Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // 3. Sum of all elements
        int totalSum = 0;
        for (int[] row : arr) {
            for (int val : row) {
                totalSum += val;
            }
        }
        System.out.println("Sum of all elements: " + totalSum);

        // 4. Transpose of matrix
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = arr[i][j];
            }
        }
        System.out.println("Transpose of Matrix:");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j] + " ");
            }
            System.out.println();
        }

        // 5. Row-wise sum
        System.out.println("Row-wise Sum:");
        for (int i = 0; i < rows; i++) {
            int rowSum = 0;
            for (int j = 0; j < cols; j++) {
                rowSum += arr[i][j];
            }
            System.out.println("Row " + i + " sum: " + rowSum);
        }

        // 6. Column-wise sum
        System.out.println("Column-wise Sum:");
        for (int j = 0; j < cols; j++) {
            int colSum = 0;
            for (int i = 0; i < rows; i++) {
                colSum += arr[i][j];
            }
            System.out.println("Column " + j + " sum: " + colSum);
        }

        // 7. Search for a specific element
        int key = 5;
        boolean found = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == key) {
                    System.out.println("Element " + key + " found at (" + i + "," + j + ")");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Element " + key + " not found.");
        }

        // 8. Find Maximum and Minimum elements
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int[] row : arr) {
            for (int val : row) {
                if (val > max) max = val;
                if (val < min) min = val;
            }
        }
        System.out.println("Maximum Element: " + max);
        System.out.println("Minimum Element: " + min);
    }
}

