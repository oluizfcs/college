
import java.util.concurrent.TimeUnit;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author 20241070130005
 */
public class Telas {

    public static void main(String[] args) throws InterruptedException {
        Carregando mpc = new Carregando();
        
        int contador = 0;
        while(true) {
            mpc.progress(contador);
            contador += 49;
            TimeUnit.SECONDS.sleep(1);
            if(contador >= 100) {
                mpc.dispose();
                break;
            }
        }

        new TelaInicial();
    }
}