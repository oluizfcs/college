/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mtp.telas;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author luizf
 */
public class Telas {

    public static void main(String[] args) throws InterruptedException {
        
        Carregar carregar = new Carregar();
        for(int i = 0; i <= 100; i += 10) {
            carregar.setProgress(i);
            TimeUnit.MILLISECONDS.sleep(150);
        }
        
        new Cadastro();
        carregar.dispose();
    }
}
