package samples.carddeck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Samples {
    public static void main(String[] args) {
//        try {
//            //int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
//            System.out.println(N);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
}