public class l001_Sorting {

    // Swapping two numbers
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Move the largest number in the given array to the last index 
    public static void moveToLast(int[] arr, int si, int ei) {
        for (int i = si + 1; i <= ei; i++) {
            if (arr[i - 1] > arr[i])
                swap(arr, i - 1, i);
        }
    }

    // Bubble sort algorithm
    public static void bubble(int arr[], int n) {
        int ei = n - 1;
        for (int i = 0; i < n; i++) {
            moveToLast(arr, 0, ei - i);
        }

    }

    // Move the small element in the array to the first index
    public static void moveToStart(int[] arr, int si, int ei) {
        for (int i = si + 1; i <= ei; i++) {
            if (arr[si] > arr[i])
                swap(arr, si, i);
        }
    }

    // Selection Sort Algorithm
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        int ei = n - 1;
        for (int i = 0; i < n - 1; i++) {
            moveToStart(arr, i, ei);
        }
    }

    // Check whether the value is greater than the previous value of sorted array --> for insertion sort
    public static void isGreater(int arr[], int i, int j){
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
        }
    }

    // Insertion Sort Algorithm
    public static void insertionSort(int[] arr, int i, int j){
        for(int i = 1; i < arr.length ; i++){
            for(int j = i - 1; j >= 0; j--){
                if(isGreater(arr, j, j + 1)){
                    swap(arr, j, j + 1);
                }   else {
                    break;
                }
            }
        }
    }

}
