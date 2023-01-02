package datastr;

public class ARI {

    private String start, back, backR;

    public ARI(String s, String b, String r) {
        start = s;
        back = b;
        backR = r;
    }

    public String getStart() {
        return start;
    }

    public String getBackR() {
        return backR;
    }

    public String getBack() {
        return back;
    }

    public String toString() {
        return ("S = "+start+"\n"+
                "Back = "+back+"\n"+
                "BackR = "+backR+"\n"+
                "--------------------------------\n");
    }
}
