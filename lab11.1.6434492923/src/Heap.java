import java.util.Enumeration;

public class Heap {
    public void buildHeap(int[] arr, int numNode) {
        for (int i = numNode/2; i > 0; i--) {
            reHeap(arr, i, numNode);
        }
    }

    public  void reHeap(int[] arr, int root, int numNode) {
        int maxChild, tmp;
        boolean isHeap = false;
        while ((2*root <= numNode) && (!isHeap)) {
            if (root*2 == numNode) {
                maxChild = root*2;
            }
            else {
                if (arr[root*2] > arr[(root*2)+1]) {
                    maxChild = root*2;
                }
                else {
                    maxChild = (root*2)+1;
                }
            }
            if (arr[root] < arr[maxChild]) {
                tmp = arr[root];
                arr[root] = arr[maxChild];
                arr[maxChild] = tmp;
                root = maxChild;
            }
            else {
                isHeap = true;
            }
        }
    }

    public String printHeap(int[] arr, int numNode) {
        String s = "";
        for (int i = 1; i <= numNode; i++) {
            s += arr[i]+" ";
        }
        return s;
    }
}
