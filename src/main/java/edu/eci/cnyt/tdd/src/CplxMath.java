package edu.eci.cnyt.tdd.src;

import edu.eci.cnyt.tdd.src.excepciones.CplxException;


public class CplxMath {
	
    /**
     * Tiene Por funcion realizar la suma entre dos complejos
     * @param C1 - Primer complejo a sumar
     * @param C2 - Segundo complejo a sumar
     * @return
     */
    public static Complejo CompSuma(Complejo C1, Complejo C2 ) {
        return new Complejo(C1.getReal()+C2.getReal(), C1.getImg()+C2.getImg());
    }
    
    /**
     * tiene por funcion realizar la resta entre dos complejos
     * @param C1 - Primer complejo a restar
     * @param C2 - Segundo complejo a restar
     * @return
     */
    public static Complejo CompResta(Complejo C1, Complejo C2 ) {
        return new Complejo(C1.getReal()-C2.getReal(), C1.getImg()-C2.getImg());		
    }
    
    /**
     * tiene por funcion multiplicar un complejo con un escalar
     * @param r - Valor de un escalar
     * @param C1 - Complejo a multiplicar
     * @return
     */
    public static Complejo Mult(double r, Complejo C1){
        return new Complejo(r*C1.getReal(), r*C1.getImg());
    }
    
    /**
     * tiene por funcion multiplicar dos complejos
     * @param C1 - Primer complejo a multiplicar
     * @param C2 - Segundo complejo a multiplicar
     * @return
     */
    public static Complejo CompMult(Complejo C1, Complejo C2) {
        double pR = ((double)Math.round((C1.getReal()*C2.getReal()) * 100d) / 100d)  -  ((double)Math.round((C1.getImg()*C2.getImg()) * 100d) / 100d),
               pI = ((double)Math.round((C1.getReal()*C2.getImg()) * 100d) / 100d) + ((double)Math.round((C1.getImg()*C2.getReal()) * 100d) / 100d);
        return new Complejo(pR,pI);
    }
    
    /**
     * Tiene por funcion dividir dos complejos 
     * @param C1 - Primer complejo a dividir (Dividendo)
     * @param C2 - Segundo complejo a dividir (Divisor)
     * @return
     * @throws edu.eci.cnyt.tdd.src.excepciones.CplxException
     */
    public static Complejo CompDiv(Complejo C1, Complejo C2) throws CplxException {
        if(C1.getReal() == 0 && C2.getImg() == 0) throw new CplxException(CplxException.DIVISION_CERO);
        double a = C1.getReal(),b = C1.getImg(),c = C2.getReal(),d = C2.getImg(),
                   pR = (a*c+b*d)/(Math.pow(c, 2)+Math.pow(d, 2)), pI = (b*c-a*d)/(Math.pow(c, 2)+Math.pow(d, 2));
        return new Complejo(pR, pI);
    }
    
    /**
     * Tiene por funcion hallar el modulo de un numero complejo
     * @param C - Complejo a hallar modulo
     * @return
     */
    public static double CompMod(Complejo C) {
        return Math.round(Math.sqrt((C.getImg()*C.getImg())+(C.getReal()*C.getReal())));
    }
    
    /**
     * Tiene por funcion hallar el conjugado de un numero complejo
     * @param C - Complejo a hallar conjudado
     * @return
     */
    public static Complejo CompConj(Complejo C){
        if(C.getImg()==0) return new Complejo(C.getReal(), C.getImg());
        return new Complejo(C.getReal(),-C.getImg());
    }
    
    /**
     * Tiene por funcion escribir en coordenadas polares los valores de un complejo
     * @param C - Complejo a hallar polares
     * @return
     */
    public static Complejo CompPolar(Complejo C){
        double x = C.getImg(), i =  C.getReal();
        return new Complejo(Math.sqrt((x*x)+(i*i)),Math.atan(i/x));
    }
    
    /**
     * Tiene por funcion escribir en coordenadas cartesianas los valores de un numero complejo
     * @param C - Complejo a hallar Cartesiano
     * @return
     */
    public static Complejo CompCart(Complejo C){
        double r =  C.getReal(), a = C.getImg();
        return new Complejo(r*Math.cos(a), r*Math.sin(a));
    }
    
    /**
     * Tiene por funcion hallar la fase de un numero complejo
     * @param C - Complejo a hallar Fase
     * @return
     */
    public static double CompFase(Complejo C) {
        return Math.atan2(C.getImg(), C.getReal());
    }
}
