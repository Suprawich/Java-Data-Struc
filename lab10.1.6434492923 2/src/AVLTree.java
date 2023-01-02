import java.util.Stack;

public class AVLTree extends BST{

    public AVLTree() {
        super();
    }

    public void updateWeight(AVLNode r) {
        AVLNode pLeft, pRight;
        pRight = (AVLNode) r.getRight();
        pLeft = (AVLNode) r.getLeft();
        if (pLeft != null) {
            r.setLH(Math.max(pLeft.getLH(), pLeft.getRH())+1);
        }
        else {
            r.setLH(0);
        }
        if (pRight != null) {
            r.setRH(Math.max(pRight.getLH(), pRight.getRH())+1);
        }
        else {
            r.setRH(0);
        }
        r.setWeight(r.getLH()-r.getRH());
    }

    public void add(Object newElement) {
        AVLNode start, p, t;
        t = new AVLNode((Integer) newElement, null, null, 0, 0, 0);
        Stack s = new Stack();
        if (root == null) {
            root =  t;
        }
        else {
            start = (AVLNode) root;
            while (start != null) {
                s.push(start);
                if (t.getElement() > start.getElement()) {
                    start = (AVLNode) start.getRight();
                }
                else {
                    start = (AVLNode) start.getLeft();
                }
            }
            start = (AVLNode) s.pop();
            if (t.getElement() < start.getElement()) {
                start.setLeft(t);
            }
            else {
                start.setRight(t);
            }
            updateWeight(start);
            p = start;
            while (!s.isEmpty()) {
                start = (AVLNode) s.pop();
                start = Rotate(start, p, s);
                p = start;
            }
        }
    }

    public AVLNode Rotate(AVLNode start, AVLNode p, Stack st){
        updateWeight(start);
        if(Math.abs(start.getWeight()) > 1){
            if(start.getWeight() > 0){
                if(p.getWeight() >= 0)
                    start = singleRightRotate(start,p);
                else
                    start = doubleRightRotate(start,p);
            }
        }
        else{
            if(p.getWeight() <= 0)
                start = singleLeftRotate(start,p);
            else
                start = doubleLeftRotate(start,p);
            updatePreNode(st,start);
        }
        return start;
    }

    public void updatePreNode(Stack s, AVLNode start) {
        AVLNode pre;
        if(!s.isEmpty()){
            pre = (AVLNode) s.peek();
            if(start.getElement() < pre.getElement())
                pre.setLeft(start);
            else
                pre.setRight(start);
        }
        else {
            root = start;
        }
    }

    public AVLNode singleRightRotate(AVLNode start, AVLNode p){
        start.setLeft(p.getRight());
        p.setRight(start);
        updateWeight(start);
        updateWeight(p);
        start = p;
        return start;
    }

    public AVLNode singleLeftRotate(AVLNode start, AVLNode p){
        start.setRight(p.getLeft());
        p.setLeft(start);
        updateWeight(start);
        updateWeight(p);
        start = p;
        return start;
    }

    public AVLNode doubleRightRotate(AVLNode start, AVLNode p){
        AVLNode q = (AVLNode) p.getRight();
        p.setRight(q.getLeft());
        start.setLeft(q.getRight());
        q.setRight(start);
        q.setLeft(p);
        updateWeight(start);
        updateWeight(p);
        updateWeight(q);
        start = q;
        return start;
    }

    public AVLNode doubleLeftRotate(AVLNode start, AVLNode p){
        AVLNode q = (AVLNode) p.getLeft();
        p.setLeft(q.getRight());
        start.setLeft(q.getLeft());
        q.setLeft(start);
        q.setRight(p);
        updateWeight(start);
        updateWeight(p);
        updateWeight(q);
        start = q;
        return start;
    }

    public void remove(Object e){
        AVLNode start, pre, cur;
        start = (AVLNode) root;
        Stack s = new Stack();
        pre = start;
        while (start != null && start.getElement() != (Integer) e){
            s.push(start);
            if (start.getElement() == (Integer) e) {
                return;
            }
            else if (start.getElement() > (Integer) e) {
                pre = start;
                start = (AVLNode) start.getLeft();
            }
            else {
                pre = start;
                start = (AVLNode) start.getRight();
            }
        }
        if (start == null) {
            return;
        }
        if (start.getLeft() == null && start.getRight() == null) {
            if(start == root)
                root = null;
            else
            if(pre.getLeft() == start)
                pre.setLeft(null);
            else
                pre.setRight(null);
        }
        else if(start.getLeft() != null && start.getRight() != null){
            pre = start;
            cur = (AVLNode) start.getLeft();
            s.push(cur);
            while(cur.getRight() != null){
                pre = cur;
                s.push(cur);
                cur = (AVLNode) cur.getRight();
            }
            start.setElement(cur.getElement());
            if(pre == start)
                pre.setLeft(cur.getLeft());
            else
                pre.setRight(cur.getLeft());
        }
        else{
            if(start.getLeft() != null)
                if(start == root)
                    root = start.getLeft();
                else
                if(pre.getLeft() == start)
                    pre.setLeft(start.getLeft());
                else
                    pre.setRight(start.getLeft());
            else
            if(start == root)
                root = start.getRight();
            else
            if(pre.getRight() == start)
                pre.setRight(start.getRight());
            else
                pre.setLeft(start.getRight());
        }
        s.pop();
        AVLNode p;
        while(!s.isEmpty()){
            start = (AVLNode) s.pop();
            updateWeight((AVLNode) start);
            if(Math.abs(start.getWeight()) > 1){
                if(start.getLH() < start.getRH())
                    p = (AVLNode) start.getRight();
                else
                    p = (AVLNode) start.getLeft();
                Rotate(start,p,s);
            }
        }
    }
}
