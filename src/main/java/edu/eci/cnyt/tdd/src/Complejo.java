package edu.eci.cnyt.tdd.src;


public class Complejo {
    private double pReal;
    private double pImg;

    /**
     * Constructor
     * @param r - Valor Real
     * @param j - Valor Complejo
     */
    public Complejo(double r, double j) {
        pReal = r;
        pImg = j;		
	}
	
    /**
     *Muestra la parte real del complejo
     * @return
     */
    public double getReal() {
        return pReal;		
    }

    /**
     *Muestra la parte imaginaria del Complejo
     * @return
     */
    public double getImg() {
        return pImg;
    }
    public void printear(){
        System.out.println("("+getReal()+","+getImg()+"i)");
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
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.pReal) ^ (Double.doubleToLongBits(this.pReal) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.pImg) ^ (Double.doubleToLongBits(this.pImg) >>> 32));
        return hash;
    }
	
}
