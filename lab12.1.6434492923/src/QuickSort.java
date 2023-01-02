public class QuickSort {
    public void quickS(int[] a, int f, int l) {
        int splitPoint;
        if (f < l) {
            splitPoint = split(a, f, l);
            quickS(a, f, splitPoint-1);
            quickS(a,splitPoint+1, l);
        }
    }

    public int split(int[] a, int f, int l) {
        int pivot, saveF;
        pivot = a[f];
        saveF = f;
        f++;
        do {
            boolean lessThanPivot = true;
            while ((f <= l) && lessThanPivot) {
                if (a[l] < pivot) {
                    l--;
                }
                else {
                    lessThanPivot = false;
                }
            }
            boolean gPivot = true;
            while ((f <= l) && gPivot) {
                if (a[f] > pivot) {
                    f++;
                }
                else {
                    gPivot = false;
                }
            }
            if (f < l) {
                int tmp = a[f];
                a[f] = a[l];
                a[l] = tmp;
                f++;
                l--;
            }
        }
        while (f <= l);
            int tmp = a[saveF];
            a[saveF] = a[l];
            a[l] = tmp;
            return l;

    }

    public void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}
