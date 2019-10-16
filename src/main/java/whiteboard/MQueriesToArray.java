package whiteboard;

import java.util.AbstractMap;
import java.util.Map;

/** ????
 *
 */
public class MQueriesToArray {

    private int[] arr;
    private int[] result;
    private static int N;
    private int[] places ;

    public MQueriesToArray(int[] arr) {
        N = arr.length;
        this.places = new int[N];
        this.arr = arr;
        this.result = new int[N];
        initPlaces();
    }

    private void initPlaces() {
        for (int i=0; i<N; i++) {
            places[i] = i;
        }
    }

    public int[] resolveQueries(int[][] opArr) throws WrongOperationFormatException, WrongOperationTypeException, WrongElementNumberException {
        for (int[] op : opArr) {
            if (op.length == 3) {
                executeOP(op);
            } else {
                throw new WrongOperationFormatException();
            }
        }
        reorderArray();
        return result;
    }

    private void reorderArray() {
        for (int i=0; i<N; i++) {
            result[places[i]] = arr[i];
        }
    }

    void executeOP(int[] op) throws WrongOperationTypeException, WrongElementNumberException {
        if (op[1]< N && op[2]< N){
            if (op[0] == 1) {
                executeOPType1(op);
            } else if (op[0] == 2 ) {
                executeOPType2(op);
            } else throw new WrongOperationTypeException();

        } else throw new WrongElementNumberException();
    }

    private void executeOPType2(int[] op) throws WrongElementNumberException {

    }

    private void executeOPType1(int[] op) {
        Map.Entry<Integer, Integer> I = new AbstractMap.SimpleEntry<Integer, Integer>(op[1], 0);
        Map.Entry<Integer, Integer> J = new AbstractMap.SimpleEntry<Integer, Integer>(op[2], 0);
        if (op[1] < op[2]){
            I.setValue(op[1]);
            J.setValue(op[2]);
        }else if (op[1] >op[2]){
            I.setValue(op[2]);
            J.setValue(op[1]);
        } else {
            I.setValue(-1);
            J.setValue(op[2]);
        }

        int iPlace=0, jPlace=0;
        for(int i=0; i< N; i++){
            if(places[i]<I.getValue()){
                places[i] +=2;
            } else if (places[i] == I.getValue()){
                iPlace = i;
            }else if (places[i]< J.getValue()) {
                places[i] += 1;
            } else if (places[i] == J.getValue()){
                jPlace = i;
            }
        }
        double d = 0.01;
        long l =1;
        d=l;

        places[iPlace] = 0;
        if (I.getValue() > 0){
            places[jPlace] = 1;
        }


    }


    public class WrongOperationFormatException extends Throwable {
    }

    public class WrongOperationTypeException extends Throwable {
    }

    public class WrongElementNumberException extends Throwable{
    }
}
