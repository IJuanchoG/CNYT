package edu.eci.cnyt.tdd.src.principal;


import edu.eci.cnyt.tdd.src.CplxMathS;
import edu.eci.cnyt.tdd.src.EspacioComp;
import edu.eci.cnyt.tdd.src.excepciones.CplxException;


public class principal {
	public static void main(String args[]) {
            double R3 =  Math.sqrt(3), R15 = Math.sqrt(15), R2 = Math.sqrt(2);
            double[][]  datos = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1},{7,5},{3,1},{1,2}}, 
                    datos2 = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1}},
                    datos3 = {{1,0},{0,1},{0,-1},{1,0}},
                    datos5 = {{1/R2,0},{0,1/R2},{0,1/R2},{1/R2,0}};
            EspacioComp matriz1 = new EspacioComp(3,3,datos), 
                    matriz2 = new EspacioComp(3,2,datos2),
                    matriz3 = new EspacioComp(2,2,datos3),
                    matriz5 = new EspacioComp(2,2,datos5);
            CplxMathS.productoTensor(matriz5, matriz1);
	}
        
}
