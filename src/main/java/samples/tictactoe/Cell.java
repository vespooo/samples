package samples.tictactoe;

import java.util.concurrent.Callable;

public class Cell {
    private Sign sign;
    private Callable<Boolean> check;

    public Cell(Sign sign) {
        this.sign = sign;
    }

    public Sign getSign() {
        return sign;
    }


    
    public void setSign(Sign sign) throws IllegalSignInsertion, GameOver {
        if(this.sign.getValue() == Sign.Value.EMPTY){
            this.sign = sign;
        } else throw new IllegalSignInsertion();
        try {
            if(check.call()) throw new GameOver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEndOfGameHandler(Callable<Boolean> check) {
        this.check =check;
    }

}
