# CNYT

###  Librería de numeros complejos

Mi nombre es Juan Carlos García,
Esta es una librería que tiene por fin calcular diferentes tipos de operaciones de números complejos.

Sus principales funciones son:
- Suma
- Resta
- Producto por escalar
- Producto por otro Complejo
- Division
- Modulo
- Fase
- Conjugado
- Componentes polares
- Componentes Cartesianas

Como ejemplo del código podemos ver esta sección en la que se representa la multiplicación de dos complejos

``` public static Complejo CompMult(Complejo C1, Complejo C2) {
        double pR = C1.getReal()*C2.getReal()-C1.getImg()*C2.getImg(), 
                   pI = C1.getReal()*C2.getImg()+C1.getImg()*C2.getReal();
        return new Complejo(pR,pI);
    }
```
Como podemos notar retorna objetos con las especificaciones obtenidas.

La verificación de los datos se da a partir de las pruebas realizadas, como podemos ver de ejemplo encontramos:
```
/**
     * Test of CompMult method, of class CplxMath.
     */
    @Test
    public void testCompMult() {
        Complejo C1 = new Complejo(-1.5,5);
        Complejo C2 = new Complejo(9,7);
        Complejo expResult = new Complejo(-48.5,34.5);
        Complejo result = CplxMath.CompMult(C1, C2);
        assertEquals(expResult, result);
    }
```

Actualmente la calculadora solo se encuentra implementada para funciones simpls y unicamente complejos
