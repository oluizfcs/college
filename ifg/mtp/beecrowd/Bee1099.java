import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Bee1099 {
 
    public static void main(String[] args) throws IOException {
 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            Integer x = sc.nextInt();
            Integer y = sc.nextInt();
            ArrayList<Integer> numerosImpares = new ArrayList<Integer>();

            if (x > y) {
                for(int j = y+1; j < x; j++) {
                    if(j % 2 != 0) {
                        numerosImpares.add(j);
                    }
                }
            } else if (y > x) {
                for(int k = x+1; k < y; k++) {
                    if(k % 2 != 0) {
                        numerosImpares.add(k);
                    }
                }
            } else {
                numerosImpares.add(0);
            }

            int somaNumerosImpares = 0;

            for(int l = 0; l < numerosImpares.size(); l++) {
                somaNumerosImpares += numerosImpares.get(l);
            }

            System.out.println(somaNumerosImpares);
        }

        sc.close();
    }
}
