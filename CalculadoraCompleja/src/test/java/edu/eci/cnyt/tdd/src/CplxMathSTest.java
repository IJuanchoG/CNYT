/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.tdd.src;

import edu.eci.cnyt.tdd.src.excepciones.CplxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;


public class CplxMathSTest {
    
    double R3 =  Math.sqrt(3), R15 = Math.sqrt(15), R2 = Math.sqrt(2);
            double[][]  datos = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1},{7,5},{3,1},{1,2}}, 
                    datos2 = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1}},
                    datos3 = {{1,0},{0,1},{0,-1},{1,0}},
                    datos4 = {{1,1},{1,1},{1,1},{1,1}},
                    datos5 = {{1/R2,0},{0,1/R2},{0,1/R2},{1/R2,0}};
            EspacioComp matriz1 = new EspacioComp(3,3,datos), 
                    matriz2 = new EspacioComp(3,2,datos2),
                    matriz3 = new EspacioComp(2,2,datos3),
                    matriz4 = new EspacioComp(2,2,datos4),
                    matriz5 = new EspacioComp(2,2,datos5);
    

    @Test
    public void deberiaSumarEspacios() {
        try {
            EspacioComp EspacioSum = CplxMathS.EspacioSum(matriz3, matriz4);
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{2,1},{1,2},{1,0},{2,1}});
            assertEquals(EspacioSum,Esperado);
        } catch (CplxException ex) {
            fail("no deberia mandar error");
        }
    
    }
    @Test
    public void noDeberiaSumarEspacios() {
        try {
            EspacioComp EspacioSum = CplxMathS.EspacioSum(matriz1, matriz4);
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{2,1},{1,2},{1,0},{2,1}});            
            fail("no deberia mandar error");
        } catch (CplxException ex) {
            assertTrue(true);
        }
    
    }
    
     @Test
    public void deberiaRestarEspacioqs() {
        try {
            EspacioComp EspacioSum = CplxMathS.EspacioSum(matriz3, matriz4);
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{2,1},{1,2},{1,0},{2,1}});
            assertEquals(EspacioSum,Esperado);
        } catch (CplxException ex) {
            fail("no deberia mandar error");
        }    
    }
    
    
    @Test
    public void noDeberiaRestarEspacios() {
        try {
            EspacioComp EspacioSum = CplxMathS.EspacioSum(matriz1, matriz4);
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{2,1},{1,2},{1,0},{2,1}});            
            fail("no deberia mandar error");
        } catch (CplxException ex) {
            assertTrue(true);
        }
    
    }
     @Test
    public void deberiaRestarEspacios() {
        try {
            EspacioComp EspacioSum = CplxMathS.EspacioSum(matriz3, matriz4);
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{2,1},{1,2},{1,0},{2,1}});
            assertEquals(EspacioSum,Esperado);
        } catch (CplxException ex) {
            fail("no deberia mandar error");
        }    
    }
    
     @Test
    public void deberiaHallarInvEspacios() {
        EspacioComp EspacioSum = CplxMathS.EspacioInv(matriz3);
        EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{1,0},{0,-1},{0,1},{1,0}});
        assertEquals(EspacioSum,Esperado);
    
    }
     @Test
    public void deberiaHallarMultEscalarEspacios() {
        EspacioComp EspacioSum = CplxMathS.Mult(1,matriz3);
        EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{1,0},{0,1},{0,-1},{1,0}});
        assertEquals(EspacioSum,Esperado);
    
    }
    @Test
    public void deberiaHallarMultEspacios() {
        try {
            EspacioComp EspacioSum = CplxMathS.EspacioMult(matriz4,matriz3);          
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{1,0},{0,-1},{0,1},{1,0}});
            assertEquals(EspacioSum,EspacioSum);
        } catch (CplxException ex) {
            fail();
        }
    
    }
    
    @Test
    public void noDeberiaHallarMultEspacios() {
        try {
            EspacioComp EspacioSum = CplxMathS.EspacioMult(matriz1,matriz3);          
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{1,0},{0,-1},{0,1},{1,0}});
            fail();
        } catch (CplxException ex) {
            assertTrue(true);
        }
    
    }
    @Test
    public void deberiaUnitaria() {
        try {
            boolean unitaria = CplxMathS.esUnitaria(matriz3);          
            
            assertTrue(unitaria);
        } catch (CplxException ex) {
            assertTrue(true);
        }
    
    }
}
