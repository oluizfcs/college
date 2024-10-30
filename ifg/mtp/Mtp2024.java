/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mtp2024;

import java.util.Scanner;

/**
 *
 * @author 20241070130005
 */
public class Mtp2024 {

    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("n1:");
        Double n1 = sc.nextDouble();
        System.out.print("\nn2:");
        Double n2 = sc.nextDouble();
        
        Calculadora calc = new Calculadora(n1, n2);
        
        System.out.println("soma = " + calc.somar());
        System.out.println("diferença = " + calc.subtrair());
        System.out.println("produto = " + calc.multiplicar());
        System.out.println("razão = " + calc.dividir());
    }
}