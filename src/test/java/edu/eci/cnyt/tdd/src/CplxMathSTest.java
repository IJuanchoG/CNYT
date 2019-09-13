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
            CplxMathS.EspacioSum(matriz1, matriz4);
            fail("no deberia mandar error");
        } catch (CplxException ex) {
            assertTrue(true);
        }
    
    }
    
    @Test
    public void deberiaRestarEspacios() {
        try {
            EspacioComp EspacioResta = CplxMathS.EspacioResta(matriz3, matriz4);
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{0,-1},{-1,0},{-1,-2},{0,-1}});
            assertEquals(EspacioResta,Esperado);
        } catch (CplxException ex) {
            fail("no deberia mandar error");
        }    
    }
    
    
    @Test
    public void noDeberiaRestarEspacios() {
        try {
            CplxMathS.EspacioResta(matriz1, matriz4);
            fail("no deberia mandar error");
        } catch (CplxException ex) {
            assertTrue(true);
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
            EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{2,0},{2,0},{0,2},{0,2}});
            assertEquals(EspacioSum,Esperado);
        } catch (CplxException ex) {
            fail("No deberia enviar error");
        }
    
    }
    
    @Test
    public void noDeberiaHallarMultEspacios() {
        try {
            CplxMathS.EspacioMult(matriz1,matriz3);                     
            fail();
        } catch (CplxException ex) {
            assertTrue(true);
        }
    
    }
    
    @Test
    public void deberiaHallarTransEspacio() {
        //{1,0},{0,1},{0,-1},{1,0}
        EspacioComp EspacioSum = CplxMathS.EspacioTrans(matriz3);
        EspacioComp Esperado = new EspacioComp(matriz3.getN(),matriz3.getM(),new double[][]{{1,0},{0,-1},{0,1},{1,0}});
        matriz3.printear();
        EspacioSum.printear();
        assertEquals(EspacioSum,Esperado);
    
    }
    
    @Test
    public void deberiaHallarConjEspacio() {
        //{1,0},{0,1},{0,-1},{1,0}
        EspacioComp EspacioSum = CplxMathS.EspacioConj(matriz3);
        EspacioComp Esperado = new EspacioComp(matriz3.getM(),matriz3.getN(),new double[][]{{1,0},{0,-1},{0,1},{1,0}});
        assertEquals(EspacioSum,Esperado);
    
    }
    
    @Test
    public void deberiaHallarAdjEspacio() {
        //{1,0},{0,1},{0,-1},{1,0}
        EspacioComp EspacioSum = CplxMathS.EspacioConj(matriz3);
        EspacioComp Esperado = new EspacioComp(matriz3.getN(),matriz3.getM(),new double[][]{{1,0},{0,-1},{0,1},{1,0}});
        EspacioSum.printear();
        assertEquals(EspacioSum,Esperado);
    
    }
    
    @Test
    public void deberiaHallarTrance() {
        //{1,0},{0,1},{0,-1},{1,0}
        Complejo EspacioSum = CplxMathS.Trance(matriz3);
        EspacioSum.printear();
        Complejo Esperado = new Complejo(2,0);
        assertEquals(EspacioSum,Esperado);    
    }
    
    @Test
    public void deberiaHallarCompInner() {
        try {
            //{1,0},{0,1},{0,-1},{1,0}
            Complejo Espacio = CplxMathS.CompInner(matriz3,matriz3);
            Complejo Esperado = new Complejo(4,0);    
            assertEquals(Espacio,Esperado);
        } catch (CplxException ex) {
            fail("No deberia mandar error");
        }
    }
    
    @Test
    public void noDeberiaHallarCompInner() {
        try {
            //{1,0},{0,1},{0,-1},{1,0}
            Complejo Espacio = CplxMathS.CompInner(matriz1,matriz3);
            fail("Deberia mandar error");
        } catch (CplxException ex) {
            assertTrue(true);
        }
    }
    
    @Test
    public void deberiaHallarNorma() {
        try {
            //{1,0},{0,1},{0,-1},{1,0}
            double Espacio = CplxMathS.NormaMatrices(matriz3); 
            assertEquals(Espacio,2,0.03);
        } catch (CplxException ex) {
            fail("No deberia mandar error");
        }
    }
    
    @Test
    public void noDeberiaHallarNorma() {
        try {
            //{1,0},{0,1},{0,-1},{1,0}
            double Espacio = CplxMathS.NormaMatrices(matriz2);
            fail("Deberia mandar error");
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
            fail("No deberia fallar");
        }    
    }
    @Test
    public void noDeberiaUnitaria1() {
        try {
            boolean unitaria = CplxMathS.esUnitaria(matriz1);          
            
            assertFalse(unitaria);
        } catch (CplxException ex) {
            fail("No deberia fallar");
        }    
    }
    
    @Test
    public void noDeberiaUnitaria2() {
        try {
            CplxMathS.esUnitaria(matriz2);               
            fail("No deberia fallar");
        } catch (CplxException ex) {
            assertTrue(true);
        }    
    }
    
    @Test
    public void deberiaHermitian() {
        try {
            boolean Hermitian = CplxMathS.esHermitian(matriz3);          
            
            assertTrue(Hermitian);
        } catch (CplxException ex) {
            fail("No deberia fallar");
        }    
    }
    @Test
    public void noDeberiaHermitian1() {
        try {
            boolean Hermitian = CplxMathS.esHermitian(matriz1);          
            
            assertFalse(Hermitian);
        } catch (CplxException ex) {
            fail("No deberia fallar");
        }    
    }
    
    @Test
    public void noDeberiaHermitian2() {
        try {
            CplxMathS.esHermitian(matriz2);               
            fail("No deberia fallar");
        } catch (CplxException ex) {
            assertTrue(true);
        }    
    }
    
    @Test
    public void deberiaHallarDintancia() {
        try {
            //{1,0},{0,1},{0,-1},{1,0}
            double distancia = CplxMathS.distancia(matriz3, matriz4);
            assertEquals(distancia,2.82,0.02);
        } catch (CplxException ex) {
            fail("no debería lanzar fallo");
        }
        
    }
    
    @Test
    public void noDeberiaHallarDintancia() {
        try {
            //{1,0},{0,1},{0,-1},{1,0}
            CplxMathS.distancia(matriz2, matriz4);            
            fail("no debería lanzar fallo");
        } catch (CplxException ex) {
            assertTrue(true);
        }        
    }
    
    @Test
    public void deberiaHallarProdTensor() {
        EspacioComp Espacio = CplxMathS.productoTensor(matriz1,matriz3);
        Espacio.printear();
        EspacioComp Esperado = new EspacioComp(matriz3.getM()*matriz1.getM(),matriz3.getN()*matriz1.getN(),new double[][]{{ 1 , 2 }, { -2 , 1 }, { 2 , 3 }, { -3 , 2 }, { 3 , 4 }, { -4 , 3 }, 
                                                                                            { 2 , -1 }, { 1 , 2 }, { 3 , -2 }, { 2 , 3 }, { 4 , -3 }, { 3 , 4 }, 
                                                                                            { 4 , 5 }, { -5 , 4 }, { 7 , 5 }, { -5 , 7 }, { 3 , 1 }, { -1 , 3 }, 
                                                                                            { 5 , -4 }, { 4 , 5 }, { 5 , -7 }, { 7 , 5 }, { 1 , -3 }, { 3 , 1 }, 
                                                                                            { 7 , 5 }, { -5 , 7 }, { 3 , 1 }, { -1 , 3 }, { 1 , 2 }, { -2 , 1 }, 
                                                                                            { 5 , -7 }, { 7 , 5 }, { 1 , -3 }, { 3 , 1 }, { 2 , -1 }, { 1 , 2 }, 
                                                                                            { 1 , 2 }, { -2 , 1 }, { 2 , 3 }, { -3 , 2 }, { 3 , 4 }, { -4 , 3 }, 
                                                                                            { 2 , -1 }, { 1 , 2 }, { 3 , -2 }, { 2 , 3 }, { 4 , -3 }, { 3 , 4 }, 
                                                                                            { 4 , 5 }, { -5 , 4 }, { 7 , 5 }, { -5 , 7 }, { 3 , 1 }, { -1 , 3 }, 
                                                                                            { 5 , -4 }, { 4 , 5 }, { 5 , -7 }, { 7 , 5 }, { 1 , -3 }, { 3 , 1 }, 
                                                                                            { 7 , 5 }, { -5 , 7 }, { 3 , 1 }, { -1 , 3 }, { 1 , 2 }, { -2 , 1 }, 
                                                                                            { 5 , -7 }, { 7 , 5 }, { 1 , -3 }, { 3 , 1 }, { 2 , -1 }, { 1 , 2 }});
        assertEquals(Espacio,Esperado);
    }    
    
}
