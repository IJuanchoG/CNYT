# Librería de Números Complejos 

Mi nombre es Juan Carlos García y quiero presentarles esta librería que tiene por fin calcular 
diferentes tipos de operaciones de números complejos.
esta libreria está implementada en **JAVA** para la materia de **CNYT (Ciencias Naturales y Tecnología)**

## Funciones:
La librería cuenta con varias funciones y versiones de la misma, 

#### Primer versión (Numeros complejos)
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

### Segunda Versión (Espacios de numeros complejos)
-  Suma de vectores complejos.
-   Inverso aditivo de vector complejo.
-   Multiplicación de escalar por vector complejo.
-   Suma de matrices complejas.
-   Inverso aditivo de matriz compleja.
-   Multiplicación de escalar por matriz compleja.
-   Transpuesta de matriz compleja.
-   Conjugada de matriz compleja.
-   Adjunta (daga) de matriz compleja .
-   Producto de matrices complejas.
-   Acción de matriz compleja sobre vector complejo.
-   Producto interno de vectores complejos.
-   Norma de vector complejo.
-   Distancia entre dos vectores complejos.
-   ¿Es la matriz compleja una matriz unitaria?.
-   ¿Es la matriz compleja una matriz hermitiana?.
-   Producto tensorial de matrices complejas.


Como ejemplo podemos encontrar este fragmento de código que realiza la suma de dos matrices complejas
```
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
```

## Pasos de descarga y uso:

Clona el repositorio con la siguiente dirección en el terminal (cmd) usando el comando:
``` git clone https://github.com/IJuanKhoxD/CNYT.git```

Abrir el programa descargado con cualquier tipo de IDE Java, es recomendado usar **NetBeans**,
para ejecutar o implementarla debe usar las calculadoras **CplxMath** y **CplxMathS**, siendo cada una dirigida a
numeros complejos y matrices complejas respectivamente.

el tipo de entrada para cada una es:

### CplxMath
```
public static Complejo CompSuma(Complejo C1, Complejo C2 )....
```

donde un complejo tiene este tipo de constructor

```
public Complejo(double r, double j) ....
```

### CplxMathS

```
public static EspacioComp EspacioSum(EspacioComp C1, EspacioComp C2) throws CplxException....
```

donde un matriz compleja tiene este tipo de constructor

```
public EspacioComp(int sizex, int sizey, double[][] datos) ....
```
cabe destacar que este no es su único tipo de constructor


para verificar el correcto funcionamiento de las librerias es recomendable ejecutar las pruebas presentes en estos,
se pueden ejecutar desde el IDE de preferencia o desde comandos MVN tales como 
>>```mvn surefire:test```

