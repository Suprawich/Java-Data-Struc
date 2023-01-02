package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

public class LinkedCollection implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }
    private LinkedNode header = new LinkedNode(null, null);
    private int size;

    public LinkedCollection() {}
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void add(Object e) {
        header.next = new LinkedNode(e, header.next);
        ++size;
    }
    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while( node != null ) {
            if (node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while( p.next != null &&
                ! p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next; --size;
        }
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while (p != null) {
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }

    public boolean equals(Object o) {
        if (o instanceof LinkedCollection) {
            LinkedCollection lc = (LinkedCollection) o;
            LinkedNode node1 = lc.header.next;
            while (node1 != null) {
                if (this.contains(node1.element)) {
                    node1 = node1.next;
                }
                else {
                    return false;
                }
            }
            LinkedNode node2 = this.header.next;
            while (node2 != null) {
                if (lc.contains(node2.element)) {
                    node2 = node2.next;
                }
                else {
                    return false;
                }
            }
            return true;
        }
        else { return false; }
    }

    public boolean containsDup() {
        LinkedNode node1 = header.next;
        while (node1 != null) {
            LinkedNode node2 = node1.next;
            while (node2 != null) {
                if (node1.element.equals(node2.element)) {
                    return true;
                }
                node2 = node2.next;
            }
            node1 = node1.next;
        }
        return false;
    }

    public void removeDup() {
        while (this.containsDup()) {
            LinkedNode node1 = header.next;
            while (node1 != null) {
                LinkedNode node2 = node1.next;
                while (node2 != null) {
                    if ((node1.element).equals(node2.element)) {
                        this.remove(node2.element);
                    }
                    node2 = node2.next;
                }
                node1 = node1.next;
            }
        }
    }

    public void removeAll(Object o) {
        LinkedNode node = header.next;
        while (node != null) {
            if (node.element.equals(o)) {
                this.remove(o);
            }
            node = node.next;
        }
    }

}