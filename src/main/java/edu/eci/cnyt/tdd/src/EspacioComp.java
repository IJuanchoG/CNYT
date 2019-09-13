package edu.eci.cnyt.tdd.src;

import java.util.Arrays;



public class EspacioComp {
    private Complejo[][]  espacio;
    private int m, n;

    public EspacioComp(int sizex, int sizey, double[][] datos) {
        m = sizex;
        n = sizey;
        int c = 0;
        espacio = new Complejo[m][n];	
        for (int i= 0; i < m; i++) for (int j=0; j<n; j++) {
            espacio[i][j] = new Complejo(datos[c][0],datos[c][1]);
            c++;
        }

    }	

    public EspacioComp(int size, double[][] datos){
        this(1,size,datos );
    }

    public EspacioComp(int sizex, int sizey, Complejo[][] datos){
        m = sizex;
        n = sizey;
        espacio =  datos;
    }
    
    /**
     * Retorna el valor del tamaño M
     * @return 
     */
    public int getM() {
        return m;
    }
    /**
     * Retorna el valor lado N
     * @return 
     */
    public int getN() {
        return n;
    }
    /**
     * retorna los valores de espacios complejos
     * @return 
     */
    public Complejo[][] getEspacio(){
        return espacio;
    }

    /**
     * Muestra en pantalla los valores de la matriz
     */
    public void printear() {
        for (int i = 0; i < m; i++){ 
            for(int j = 0; j<n; j++) System.out.print("( "+Math.round(espacio[i][j].getReal())+" , "+Math.round(espacio[i][j].getImg())+" i) ");
            
            System.out.println();
            }
    }
    
    
    /**
     * Verifica que el Hashcode de ambos objetos sean iguales para confirmar equivalencia
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }
    
    
    /**
     *Muestra la informacion del Hashcode del objeto
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;        
        hash = 29 * hash + this.m;
        hash = 29 * hash + this.n;
        hash = 29 * hash + Arrays.deepHashCode(this.espacio);
        return hash;
    }
    
}
