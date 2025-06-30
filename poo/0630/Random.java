public class Random
{
    public static void main(String[] args) {
        double sum = 0;
        double n = Math.pow(10, 9);
        
        for(int i = 0; i < n; i++) {
            sum += random();
        }

        System.out.println(sum / n);
    }

    public static double random() {
        return Math.random() * 10;
    }
}