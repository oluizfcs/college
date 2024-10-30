import java.io.IOException;
import java.util.Scanner;

public class Bee1101 {
 
    public static void main(String[] args) throws IOException {
 
        Scanner sc = new Scanner(System.in);

        while(true) {
            Integer m = sc.nextInt();
            Integer n = sc.nextInt();

            Integer soma = 0;

            if(m <= 0 || n <= 0) {
                break;
            }

            if(m > n) {
                for(int i = n; i <= m; i++) {
                    System.out.print(i + " ");
                    soma += i;
                }
            } else if(m < n) {
                for(int i = m; i <= n; i++) {
                    System.out.print(i + " ");
                    soma += i;
                }
            } else {
                System.out.print(m + " " + n + " ");
                soma += (m + n);
            }

            System.out.println("Sum=" + soma);
        }
 
        sc.close();
    }
}