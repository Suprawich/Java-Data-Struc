public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {0, 20, 9, 32, 6, 15, 25, 50, 5, 8, 13, 18};
        //int[] arr = {0,20,13,25,5,6,50,2,16,9,1};
        int numNode = arr.length-1;
        Heap h = new Heap();
        System.out.print("Data Array: ");
        System.out.print(h.printHeap(arr, numNode));
        System.out.println();
        h.buildHeap(arr, numNode);
        System.out.print("Heap Array: ");
        System.out.print(h.printHeap(arr, numNode));
    }
}
