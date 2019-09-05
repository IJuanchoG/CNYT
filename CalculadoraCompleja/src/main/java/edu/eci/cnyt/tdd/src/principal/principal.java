package edu.eci.cnyt.tdd.src.principal;


import edu.eci.cnyt.tdd.src.CplxMathS;
import edu.eci.cnyt.tdd.src.EspacioComp;
import edu.eci.cnyt.tdd.src.excepciones.CplxException;


public class principal {
	public static void main(String args[]) {
            try {
                double R3 =  Math.sqrt(3), R15 = Math.sqrt(15);
                double[][] datos = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1},{7,5},{3,1},{1,2}}, 
                        datos2 = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1}},
                        datos3 = {{1,0},{0,1},{0,-1},{1,0}},
                        datos4 = {{1/2,1/2},{0,1/R3},{3/(2*R15),1/(2*R15)},{-1/2,0},{1/R3,0},
                            {4/(2*R15),3/(2*R15)},{1/2,0},{0,-1/R3},{0,5/(2*R15)}};
                EspacioComp matriz1 = new EspacioComp(3,3,datos), 
                        matriz2 = new EspacioComp(3,2,datos2),
                        matriz3 = new EspacioComp(2,2,datos3),
                        matriz4 = new EspacioComp(2,2,datos4);
                CplxMathS.CompInner(matriz4, matriz4).printear();
                System.out.print(CplxMathS.esUnitaria(matriz4)+"\n");
                
                System.out.print(CplxMathS.esHermitian(matriz3)+"\n");
                
            } catch (CplxException ex) {
                System.out.println("mando error");
               
            }
	}
        
}
