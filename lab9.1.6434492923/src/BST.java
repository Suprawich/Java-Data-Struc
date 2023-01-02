

class BST {
    private BTNode root;

    BST(){
        this.root=null;
    }

    /**
     * @return the root
     */
    private BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    private void setRoot(BTNode root) {
        this.root = root;
    }

    public void add(int newElement) {
        if ((Object) newElement != null) {
            BTNode start = root, pre = null;
            BTNode tmp = new BTNode(newElement, null, null);
            if (root == null) {
                root = tmp;
            }
            else {
                while (start != null) {
                    pre = start;
                    int BTNode = (int) start.getElement();
                    if (BTNode == newElement) {
                        System.out.println("Object : "+newElement+" has existed in the tree.");
                        start = null;
                        return;
                    }
                    else {
                        if (BTNode > newElement) {
                            start = start.getLeft();
                        }
                        else {
                            start = start.getRight();
                        }
                    }
                }
                int curNode = (int) pre.getElement();
                if (curNode > newElement) {
                    pre.setLeft(tmp);
                }
                else if (curNode < newElement) {
                    pre.setRight(tmp);
                }
            }
        }
    }

    public int getMax() {
        BTNode start = root;
        while (start.getRight() != null) {
            start = start.getRight();
        }
        return start.getElement();
    }



    public void remove(int newElement) {
        BTNode start = root;
        BTNode p = null;
        while (start != null) {
            int BTNode = start.getElement();
            if (BTNode == newElement) {
                break;
            }
            else if (newElement < BTNode) {
                p = start;
                start = start.getLeft();
            }
            else {
                p = start;
                start = start.getRight();
            }
        }
        if (start.getLeft() == null && start.getRight() == null) {
            if (start == root) {
                root = null;
            }
            else if (p.getLeft() == start) {
                p.setLeft(null);
            }
            else {
                p.setRight(null);
            }
        }
        else if (start.getLeft() != null && start.getRight() != null) {
            BTNode q = start.getLeft();
            BTNode pq = null;
            while (q.getRight() != null) {
                pq = q;
                q = q.getRight();
            }
            start.setElement(q.getElement());
            if (pq != start) {
                pq.setRight(q.getLeft());
            }
            else {
                pq.setLeft(q.getLeft());
            }
        }
        else {
            if (start == root) {
                if (start.getLeft() == null) {
                    root = start.getRight();
                }
                else {
                    root = start.getLeft();
                }
            }
            else if (p.getRight() == start) {
                if (start.getLeft() == null) {
                    p.setRight(start.getRight());
                }
                else {
                    p.setRight(start.getLeft());
                }
            }
            else {
                if (start.getLeft() == null) {
                    p.setLeft(start.getRight());
                }
                else {
                    p.setRight(start.getLeft());
                }
            }
        }
    }

    public void printTree(){
        inOrder(root);
        System.out.println();
    }
    public void inOrder(BTNode r) {
        if (r != null) {
            inOrder(r.getLeft());
            System.out.print(r.getElement()+",");
            inOrder(r.getRight());
        }
    }


}