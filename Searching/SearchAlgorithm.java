package Searching;

public class SearchAlgorithm {


    // ############### TIME COMPLEXITY FOR LINEAR SEARCH IS O(n)
    public int linearSearch(int[] array,int target) {
        for (var index = 0; index < array.length; index++) {
            if (array[index] == target)
                return index;
        }
        return -1;
    }


    // ################## TIME COMPLEXITY FOR BINARY SEARCH IS O(log2n)

    public int binarySearchRecursive(int[] array,int target) {
          return binarySearchRecursive(array,target,0,array.length);
    }

    // Recursive Implementation of Binary Search
    private int binarySearchRecursive(int[] array,int target,int left,int right) {
        if (left > right)
            return -1;

        int middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        if (array[middle] < target)
            return binarySearchRecursive(array,target,middle+1,right);

        return binarySearchRecursive(array, target,left,middle-1);
    }

    // Iterative Implementation of Binary Search
    public int binarySearchIterative(int[] array,int target) {
        var left = 0;
        var right = array.length -1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target)
                return middle;
            if (array[middle] < target)
                left = middle + 1;
            else
                right = middle - 1;
        }
        return -1;
    }

    // ################## TIME COMPLEXITY FOR BINARY SEARCH IS O(log3n)
    public int ternarySearch(int[] array,int target) {
        return 1;
    }

    public int jumpSearch(int[] array,int target) {
        return 1;
    }
}
