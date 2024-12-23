/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mtp.projetofinal.controller;

import java.util.HashMap;

/**
 *
 * @author luizf
 */
public class CadastrarUsuario {
    
    
    public static boolean cadastrar(HashMap dados) {
        
        if (dados.get("nome").equals("") || dados.get("email").equals("") || dados.get("senha").equals("") || dados.get("confirmarSenha").equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
