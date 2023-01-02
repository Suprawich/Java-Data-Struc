package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
public class ArrayList implements List {
    private Object[] elementData;
    private int size;
    public ArrayList(int cap) {
        elementData = new Object[cap];
        size = 0;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }
    public void add(Object e) {
        add(size, e);
    }
    public void remove(Object e) {
        int i = indexOf(e);
        if (i >= 0) remove(i);
    }
    public Object get(int index) {
        return elementData[index];
    }
    public void set(int index, Object e) {
        elementData[index] = e;
    }
    public void add(int index, Object e) {
        ensureCapacity(size+1);
        for(int i=size; i>index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = e;
        size++;
    }
    public void remove(int index) {
        for(int i=index+1; i<size; i++) {
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[size] = null;
    }
    public int indexOf(Object e) {
        for(int i=0; i<size; i++)
            if (elementData[i].equals(e)) return i;
        return -1;
    }
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            Object[] arr = new Object[s];
            for(int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++) {
            a[i] = elementData[i];
        }
        return a;
    }

    public void swap(int firstNode, int secondNode) {
        Object firstElem = elementData[firstNode];
        Object secondElem = elementData[secondNode];
        elementData[firstNode] = secondElem;
        elementData[secondNode] = firstElem;
    }

    public void reverse() {
        int last = size;
        for (int i = 0; i < size/2; i++) {
            this.swap(i,last-1);
            last--;
        }
    }

    public void removeRange(int first, int last) {
        for (int i = first; i < last; i++) {
            this.remove(first);
        }
    }
}
