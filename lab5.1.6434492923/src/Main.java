import datastr.ARI;
import datastr.ArrayStack;
import datastr.Stack;

public class Main {
    public static Stack stack = new ArrayStack();
    public static void main(String[] args) {
        String s = "12345";
        System.out.println("Call reverse("+"'"+s+"'"+")\n=== BOTTOM OF STACK ===");
        System.out.println(new ARI(s, "", ""));
        reverse(s);
    }

    public static String reverse(String s) {
        if (s.length() != 1) {
            String back = s.substring(1);
            String backR = s.substring(0,1);
            ARI ari = new ARI(s, back, "");
            stack.push(ari);
            System.out.println("Call reverse("+"'"+back+"'"+")\n=== BOTTOM OF STACK ===");
            System.out.println(stack.toString());
            System.out.println(new ARI(back, "", ""));
            String string = reverse(back);

            ARI ari2 = new ARI(s, back, string);
            stack.pop();
            stack.push(ari2);
            System.out.println("Return reverse("+"'"+s+"'"+")\n=== BOTTOM OF STACK ===");
            System.out.println(stack.toString());
            stack.pop();
            return string+backR;
        }
        else {
            System.out.println("Return reverse("+"'"+s+"'"+")\n=== BOTTOM OF STACK ===");
            System.out.println(stack.toString());
            System.out.println(new ARI(s, "", ""));
            return s;
        }
    }
}
