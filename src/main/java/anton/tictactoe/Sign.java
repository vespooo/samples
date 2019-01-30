package anton.tictactoe;

public class Sign {
    private Value value;

    public Sign(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }

    enum Value{
      X,O,EMPTY;
    }
}
