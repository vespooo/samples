package samples.tictactoe;

public class Signs {
    private final Sign empty;
    private final Sign x;
    private final Sign o;

    public Signs() {
        empty = new Sign(Sign.Value.EMPTY);
        x = new Sign(Sign.Value.X);
        o = new Sign(Sign.Value.O);
    }

    public Sign getX() {
        return x;
    }

    public Sign getEmpty() {
        return empty;
    }
}
