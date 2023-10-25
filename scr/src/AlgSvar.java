import java.util.Arrays;

//I could use Array.sort which is a java built - in method that sorts the list in ascending order.
//The time complexity of this is O(n log n).
//The implementation
    /*public static int maximumProduct(int[] nums) {
        //this sorts the list
        Arrays.sort(nums);
        //returns maximum product of the last three elements
        return Math.max(nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }
*/
// another solution i have learned at school and are still learning.
public class AlgSvar {

    public static int maximumProduct(int[] nums) {
        // Sort the array in ascending order using quicksort.
        quicksort(nums);
        //finds the last three highest products
        int highestProduct = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        //Calculates the maximum product of the last three
        // even if it is not sorted
        for (int i = nums.length - 4; i >= 0; i--) {
            highestProduct = Math.max(highestProduct, nums[i] * nums[nums.length - 1] * nums[nums.length - 2]);
        }
        // Return the maximum product of the last three elements in the list
        return highestProduct;


    }
    public static void quicksort(int[] nums){
        quicksort(nums, 0, nums.length-1);
    }
    // this is to sort the list recursively
    private static void quicksort(int[] nums, int left, int right) {

        if (left < right) {
            // Partition the array around the pivot in to two.
            int pivot = partition(nums, left, right);

            //sorts the left and right subarrays.
            quicksort(nums, left, pivot - 1);
            quicksort(nums, pivot + 1, right);


        }
    }

    private static int partition(int[] nums, int left, int right) {
        // Choose the last element as the pivot.
        int pivot = nums[right];

        // Initialize the two pointers.
        int i = left - 1;
        int j = left;

        // Iterate over the array and swap elements smaller than the pivot to the left.
        while (j < right) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }

        // Swap the pivot element to the right of all the smaller elements.
        swap(nums, i + 1, right);

        // Return the index of the pivot element.
        return i + 1;
    }
    //this method takes i and j as parameters and swaps the elements withn the array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // this method takes an array as a parameter and prints the elements separated by spaces.
    public static void printArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

    }
    // A sample array is provided
    // it calls the maximumProduct to find the highest product of three
    //it also prints the list in accending order. This is just to show that it works
    public static void main(String[] args) {
        int[] numbers = {1, -20, -40, -11, 10,-4, 2, 6, 5, 3,-3};
        int highestProduct = maximumProduct(numbers);
        printArray(numbers);
        System.out.println("The highest product is of " + numbers[numbers.length - 1] + " * " + numbers[numbers.length - 2] + " * " + numbers[numbers.length - 3] + " = " + highestProduct);


    }
}

