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
    
    /**
     * Resta dos matrices de numeros complejos
     *
     * @param A Primera matriz de numeros complejos
     * @param B Segunda matriz de numeros complejos
     * @return Una matriz de numeros complejos resultante de la resta de las matrices a y b
     * @throws edu.eci.cnyt.tdd.src.excepciones.CplxException
     */
    public static EspacioComp EspacioResta(EspacioComp A, EspacioComp B) throws CplxException {
        int m = A.getM(), n =  B.getN();
        if(B.getM() != m || B.getN() != n) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
        Complejo[][] resta = new Complejo[m][n];
        for(int i = 0; i < A.getM(); i++) {
            for(int j = 0; j < B.getN(); j++) {
            	resta[i][j] = CplxMath.CompResta(A.getEspacio()[i][j], B.getEspacio()[i][j]);
            }
        }
        return new EspacioComp(m,n,resta);
    }
    
    /**
     * Halla la inversa de una matriz
     * @param C
     * @return 
     */
    public static EspacioComp EspacioInv(EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[M][N];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[i][j] = CplxMath.Mult(-1, C.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(M,N,resultado);
    return algo;
    }
    
    /**
     * Calcula la matriz resultado de la multiplicación de una matriz y un escalar
     * @param r escalar
     * @param C matriz
     * @return boolean
     */
    public static EspacioComp Mult(double r,EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[M][N];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[i][j] = CplxMath.Mult(r, C.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(M,N,resultado);
    return algo;
    }
    
    /**
     * Calcula la matriz resultado de la multiplicacion de dos espacios complejos
     * @param C1 matriz1
     * @param C2 matriz2
     * @return Espacio Complejos
     * @throws edu.eci.cnyt.tdd.src.excepciones.CplxException
     */
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
    
     /**
     * Calcula la transpuesta de un espacio Complejo
     * @param C matriz
     * @return Espacio complejo
     */
    public static EspacioComp EspacioTrans(EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[N][M];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[j][i] = C.getEspacio()[i][j];
        EspacioComp algo = new EspacioComp(N,M,resultado);
    return algo;
    }
    
    /**
     * Calcula el conjugado de una matriz de complejos
     * @param C matriz
     * @return Espacio Complejo
     */
    public static EspacioComp EspacioConj(EspacioComp C){
        int M = C.getM(),N = C.getN();
        Complejo[][] resultado = new Complejo[N][M];
        for(int i = 0; i< M; i++) for (int j = 0; j < N; j++) resultado[i][j] = CplxMath.CompConj(C.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(N,M,resultado);        
    return algo;
    }
    
    /**
     * Calcula la Adjunta de una matriz hallando su transpuesta y calculando el conjugado
     * @param C matriz
     * @return Espacio Complejo
     */
    public static EspacioComp EspacioAdj(EspacioComp C){
        return CplxMathS.EspacioTrans(CplxMathS.EspacioConj(C));
    }
    
    /**
     * Calcula el trace de una matriz, es decir, suma su diagonal
     * @param C matriz
     * @return Complejo
     */
    public static Complejo Trance(EspacioComp C){
        Complejo aux = new Complejo(0,0);
        for(int i = 0; i < C.getM(); i++) aux = CplxMath.CompSuma(aux, C.getEspacio()[i][i]);
        return aux;
    }
    
    /**
     * Calcula el producto interno de dos matrices usando el Trace(adjunta(A)*B)
     * @param C1 Matriz 1
     * @param C2 Matriz 2
     * @return boolean
     * @throws edu.eci.cnyt.tdd.src.excepciones.CplxException
     */
    public static Complejo CompInner(EspacioComp C1, EspacioComp C2) throws CplxException{
        if(C1.getN()!=C2.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
        return CplxMathS.Trance(CplxMathS.EspacioMult(CplxMathS.EspacioAdj(C1),C2));
    }
    
    /**
     * Calcula la normal de una matriz
     * @param C matriz para hacerle norma
     * @return double
     * @throws edu.eci.cnyt.tdd.src.excepciones.CplxException
     */
    public static double NormaMatrices(EspacioComp C) throws CplxException{
        if (C.getM() != C.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
        Complejo res = CompInner(C,C);
        return Math.sqrt(res.getReal());
    }
    
    
    /**
     * Verifica si una matriz es unitaria, es decir <C,C> = I
     * @param C
     * @return boolean
     * @throws edu.eci.cnyt.tdd.src.excepciones.CplxException
     */
   public static boolean esUnitaria(EspacioComp C) throws CplxException{
       if(C.getM() != C.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
       return CplxMathS.EspacioMult(C, CplxMathS.EspacioAdj(C)).equals(CplxMathS.EspacioMult(CplxMathS.EspacioAdj(C),C));   
       
   }
   /**
     * Verifica si una matriz es Hermitian 
     * @param C Matriz 
     * @return Booleano
     * @throws edu.eci.cnyt.tdd.src.excepciones.CplxException
     */
   public static boolean esHermitian(EspacioComp C) throws CplxException{
       if(C.getM() != C.getN()) throw new CplxException(CplxException.DIMENSIONES_INVALIDAS);
       return C.equals(CplxMathS.EspacioAdj(C));   
   }
   
   /**
     * Calcula y retorna la distancia entre dos vectores
     * @param A Matriz 1
     * @param B Matriz 2
     * @return Distancia entre A y B
     */
    public static double distancia(EspacioComp A, EspacioComp B) throws CplxException {
        double distancia;
        distancia = NormaMatrices(EspacioResta(A, B));
        return distancia;
    }
    
   /**
     * Calcula el producto tensor entre dos matrices
     * @param A Matriz 1 de numeros complejos
     * @param B Matriz 2 de numeros complejos
     * @return Producto tensor entre A y B
     */
    public static EspacioComp productoTensor(EspacioComp A, EspacioComp B) {
        int m = A.getM(), n = A.getN(), p = B.getM(), q = B.getN();
        int Ft = m*p, Ct = n*q;        
        Complejo[][] productoTensor = new Complejo[Ft][Ct];
        for(int i = 0; i < Ft; i++) for(int j = 0; j < Ct; j++) 
            productoTensor[i][j] = CplxMath.CompMult((A.getEspacio()[i/p] [j/q]), B.getEspacio()[i%p][j%q]);
        EspacioComp espacioComp = new EspacioComp(Ft,Ct,productoTensor);
        espacioComp.printear();
        return espacioComp;
    }
    /**
     * retorna una matriz unitaria dada un tamaño
     * @param n
     * @return 
     */
    public static Complejo[][] getUnitaria(int n){        
        Complejo[][] resultado = new Complejo[n][n];
        for(int i = 0; i< n; i++) for (int j = 0; j < n; j++) 
        {
            if (i == j) resultado[j][i] = new Complejo(1,0);
            else resultado[j][i] = new Complejo(0,0);
        }
        return resultado;
    }
}
