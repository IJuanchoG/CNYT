/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.tdd.src.excepciones;


public class CplxException extends Exception {
    public static final String DIMENSIONES_INVALIDAS = "Las dimensiones para operar son invalidas";
    public static final String DIVISION_CERO = "Los valores para realizar la division son invalidos";
    
    public CplxException(String message){
        super(message);
        
    }

}
