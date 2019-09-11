/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.tdd.src;

import edu.eci.cnyt.tdd.src.excepciones.CplxException;


public class CplxMathS {
    
    public static EspacioComp EspacioSum(EspacioComp C1, EspacioComp C2) throws CplxException {
        int m = C1.getM(), n =  C1.getN();
        if(C2.getM() != m || C2.getN() != n) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
        Complejo[][] resultado = new Complejo[m][n];
        for(int i = 0; i< m; i++) for (int j = 0; j < n; j++) resultado[i][j] = CplxMath.CompSuma(C1.getEspacio()[i][j], C2.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(m,n,resultado);
        return algo;
    }
    
    public static EspacioComp EspacioInv(EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[M][N];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[i][j] = CplxMath.Mult(-1, C.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(M,N,resultado);
    return algo;
    }
    
    public static EspacioComp Mult(double r,EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[M][N];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[i][j] = CplxMath.Mult(r, C.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(M,N,resultado);
    return algo;
    }
     public static EspacioComp EspacioMult(EspacioComp C1,EspacioComp C2) throws CplxException{
        int M = C1.getM(),P = C1.getN(), N = C2.getN();
        if (P != C2.getM()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
        Complejo[][] resultado = new Complejo[M][N];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++){
            Complejo aux = new Complejo(0,0);
            for (int k = 0; k<P; k++) aux  = CplxMath.CompSuma(aux,CplxMath.CompMult(C1.getEspacio()[i][k], C2.getEspacio()[k][j]));
            resultado[i][j] = aux;
        }
        EspacioComp algo = new EspacioComp(M,N,resultado);
    return algo;
    }
     
    public static EspacioComp EspacioTrans(EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[N][M];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[j][i] = C.getEspacio()[i][j];
        EspacioComp algo = new EspacioComp(N,M,resultado);
    return algo;
    }
    public static EspacioComp EspacioConj(EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[M][N];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[i][j] = CplxMath.CompConj(C.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(M,N,resultado);        
    return algo;
    }
    
    public static EspacioComp EspacioAdj(EspacioComp C){
        return CplxMathS.EspacioTrans(CplxMathS.EspacioConj(C));
    }
    
    public static Complejo Trance(EspacioComp C){
        Complejo aux = new Complejo(0,0);
        for(int i = 0; i < C.getM(); i++) aux = CplxMath.CompSuma(aux, C.getEspacio()[i][i]);
        return aux;
    }
    
    public static Complejo CompInner(EspacioComp C1, EspacioComp C2) throws CplxException{
        if(C1.getN()!=C2.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
        return CplxMathS.Trance(CplxMathS.EspacioMult(CplxMathS.EspacioAdj(C1),C2));
    }
    public static double NormaMatrices(EspacioComp C) throws CplxException{
        if (C.getM() != C.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
        Complejo res = CompInner(C,C);
        return Math.sqrt(res.getReal());
    }
    
   public static boolean esUnitaria(EspacioComp C) throws CplxException{
       if(C.getM() != C.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
       C.printear();
       CplxMathS.EspacioAdj(C).printear();
       CplxMathS.EspacioMult(C, CplxMathS.EspacioAdj(C)).printear();
       CplxMathS.EspacioMult(CplxMathS.EspacioAdj(C),C ).printear();
       //return CplxMathS.EspacioMult(C, CplxMathS.EspacioAdj(C)).equals(new EspacioComp(C.getM(),C.getM(),EspacioComp.getUnitaria(C.getM())));   
       return CplxMathS.EspacioMult(C, CplxMathS.EspacioAdj(C)).equals(CplxMathS.EspacioMult(CplxMathS.EspacioAdj(C),C));   
       
   }
   
   public static boolean esHermitian(EspacioComp C) throws CplxException{
       if(C.getM() != C.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
       return C.equals(CplxMathS.EspacioAdj(C));   
   }
}
