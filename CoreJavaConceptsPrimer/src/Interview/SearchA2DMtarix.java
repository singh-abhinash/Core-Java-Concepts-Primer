package Interview;

public class SearchA2DMtarix {

	public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        int target1 = 3;
        int target2 = 13;

        System.out.println("Is " + target1 + " in matrix? " + searchMatrix(matrix, target1));  // true
        System.out.println("Is " + target2 + " in matrix? " + searchMatrix(matrix, target2));  // false
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Convert 1D index to 2D coordinates
            int row = mid / n;
            int col = mid % n;
            int midElement = matrix[row][col];

            if (midElement == target) {
                return true;
            } else if (target > midElement) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

}
