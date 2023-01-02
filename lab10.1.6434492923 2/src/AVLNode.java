public class AVLNode extends BTNode {
    private int leftH, rightH, weight;
    public AVLNode(int element, BTNode left, BTNode right, int lH, int rH, int w) {
        super(element, left, right);
        leftH = lH;
        rightH = rH;
        weight = w;
    }

    public void setLH(int l) {
        leftH = l;
    }

    public void setRH(int r) {
        rightH = r;
    }

    public void setWeight(int w) {
        weight = w;
    }

    public int getLH() {
        return leftH;
    }

    public int getRH() {
        return rightH;
    }

    public int getWeight() {
        return weight;
    }
}
