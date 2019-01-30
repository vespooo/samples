package anton;

public class Programm {
    public static void main(String[] args) {
        Cell boba= new Cell(40);
        boba.drawCell();
        boba.drawSign();
        boba.setSign(true);
        boba.drawSign();
    }
}
