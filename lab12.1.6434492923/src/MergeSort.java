public class MergeSort {
     public void mergeS(int[] a, int f, int l) {
        int mid;
        mid = (f+l)/2;
        if (f < l) {
            mergeS(a, f, mid);
            mergeS(a, mid+1, l);
            merge(a, f, mid, mid+1, l);
        }
     }

     public void merge(int[] a, int lf, int ll, int rf, int rl) {
         int[] temp = new int[a.length];
         int i, saveF;
         i = lf;
         saveF = lf;
         while ((lf <= ll) && (rf <= rl)) {
             if (a[lf] > a[rf]) {
                 temp[i] = a[lf];
                 lf = lf+1;
             }
             else {
                 temp[i] = a[rf];
                 rf = rf + 1;
             }
             i += 1;
         }
         while (lf <= ll) {
             temp[i] = a[lf];
             lf = lf + 1;
             i += 1;
         }
         while (rf <= rl) {
             temp[i] = a[rf];
             rf = rf + 1;
             i += 1;
         }
         for (int j = saveF; j <= rl; j++) {
             a[j] = temp[j];
         }
     }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
