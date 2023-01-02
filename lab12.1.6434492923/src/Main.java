public class Main {
    public static void main(String[] args) {
        /*int arr[] = { 12, 11, 13, 5, 6, 7 };
        MergeSort ob = new MergeSort();
        System.out.println("Given Array");
        ob.printArray(arr);


        ob.mergeS(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        ob.printArray(arr);*/
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        int n = arr.length;
        QuickSort  qs = new QuickSort();
        qs.quickS(arr, 0, n - 1);
        System.out.println("Sorted array: ");
        qs.printArray(arr, n);
    }
}
