package anton;

public class Cell {
    int hightWidh;
    Boolean sign;

    public Cell(int hightWidh) {
        this.hightWidh = hightWidh;
    }

    void drawCell(){
        System.out.println("drawing cell with high and widht=" + hightWidh);
    }

    void drawSign() {
        System.out.println("drawing sign-" + getSign());
    }

    public void setSign(boolean sign) {
        this.sign = sign;
    }

    public String getSign() {
        if(sign==null)
            return " ";
        return (sign? "X": "O");
    }
}
