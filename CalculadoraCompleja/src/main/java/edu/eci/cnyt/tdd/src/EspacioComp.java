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

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }
    public Complejo[][] getEspacio(){
        return espacio;
    }

    
    public void printear() {
        for (int i = 0; i < m; i++){ 
            for(int j = 0; j<n; j++) System.out.print("("+espacio[i][j].getReal()+","+espacio[i][j].getImg()+"i)");
            System.out.println();
            }
        System.out.println("___________________________________________");
    }
    
    public static Complejo[][] getUnitaria(int n){        
        Complejo[][] resultado = new Complejo[n][n];
        for(int i = 0; i< n; i++) for (int j = 0; j < n; j++) 
        {
            if (i == j) resultado[j][i] = new Complejo(1,0);
            else resultado[j][i] = new Complejo(0,0);
        }
        return resultado;
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
