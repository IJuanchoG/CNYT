package edu.eci.cnyt.tdd.src;


import edu.eci.cnyt.tdd.src.CplxMath;



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

    public EspacioComp EspacioSum(EspacioComp C2) {
        if(C2.getM() != m || C2.getN() != n) return null;
        Complejo[][] resultado = new Complejo[m][n];
        for(int i = 0; i< m; i++) for (int j = 0; j < n; j++) resultado[i][j] = CplxMath.CompSuma(espacio[i][j], C2.getEspacio()[i][j]);
        EspacioComp algo = new EspacioComp(m,n,resultado);
        algo.printear();
        return algo;

    }
    
    /**
    public EspacioComp multiplicacionVectorEscalar(EspacioComp vector,double escalar){
    double[][] aux = new double[1][vector.getN()];
    for (int i =0; i < vector.getN(); i++)  aux.append(multiplicacion(vector[i],(escalar,0)));
    return aux;
    }


def sumaMatricesComplejas(matriz1,matriz2):
    '''Entran 2 matrices de M x N, retorna la suma de cada matriz
    compleja.'''
    if (len(matriz1) != len(matriz2)) or (len(matriz1[0]) != len(matriz2[0])):raise 'La suma entre estas 2 matrices no esta definida'
    aux = []
    for i in range(len(matriz1)):
        aux.append(sumaVectores(matriz1[i],matriz2[i]))
    return aux
    

    
    
def restaMatricesComplejas(matriz1,matriz2):
    '''Entran 2 matrices de M x N, retorna la resta de cada matriz
    compleja.'''
    if (len(matriz1) != len(matriz2)) or (len(matriz1[0]) != len(matriz2[0])):raise 'La suma entre estas 2 matrices no esta definida'
    aux = []
    for i in range(len(matriz1)):
        aux.append(restaVectores(matriz1[i],matriz2[i]))
    return aux



def multiplicacionMatrizEscalar(matriz,escalar):
    '''Se ingresa la matriz ,y el escalar conmplejo
    como tupla,cada componente de la matriz es un vector complejo, retorna la multiplicación
    de la matriz compleja por e escalar complejo'''
    aux = []
    for i in range(len(matriz)):
        aux.append(multiplicacionVectorEscalar(matriz[i],escalar))
    return aux



def matrizTranspuesta(matriz):
    '''Entra una matriz MxN, retorna su mtariz transpuesta asociada NxM'''
    aux = []
    for i in range(len(matriz[0])):
        fila = []
        for j in range(len(matriz)):
            fila.append(matriz[j][i])
        aux.append(fila)
    return aux



def matrizConjugada(matriz):
    '''Entra una matriz , retorna su mtariz conjugada asociada '''
    aux = []
    for i in range(len(matriz)):
        fila = []
        for j in range(len(matriz[0])):
            fila.append(conjugado(matriz[i][j]))
        aux.append(fila)
    return aux



def matrizAdjunta(matriz):
    '''Entra una matriz, retorna la matriz adjunta asociada'''
    return matrizTranspuesta(matrizConjugada(matriz))



def multiplicacionMatrices(A,B):
    '''Entran 2 matrices, una de M x I, la otra de I X N, retorna
        la multiplicacion de lamatriz1 por la matriz 2 de dimension M X N'''
    filasB = len(B)
    columnasA = len(A[0])
    if filasB == columnasA:
        filas = len(A)
        columnas = len(B[0])
        matriz = [[(0, 0)] * columnas for x in range(filas)]
        for i in range(0, filas):
            for j in range(0, columnas):
                for k in range(0, len(B)):
                    m = multiplicacion(A[i][k], B[k][j])
                    n = matriz[i][j]
                    matriz[i][j] = (m[0]+n[0], m[1]+n[1])
        return matriz
    else:
        
        raise 'La multiplicación de matrices no está definida para estas matrices'
        
        
        
        
        
def multiplicacionMatricesNormales(matriz1,matriz2):
    '''Entran 2 matrices, una de M x I, la otra de I X N, retorna
        la multiplicacion de lamatriz1 por la matriz 2 de dimension M X N'''
    if (len(matriz1) != len(matriz2[0])): raise 'La multiplicación de matrices no está definida para estas matrices'
    aux = []
    for i in range(len(matriz1[0])):
        aux.append( [None] * len(matriz2))
    for i in range(len(matriz1[0])):
        for j in range(len(matriz2)):
            summ = 0
            for k in range(len(matriz2[0])):
                summ += matriz1[i][k][0]*matriz2[j][k]
            aux[i][j] = summ
    return aux




def productoInternoVectores(vector1,vector2):
    '''Se ingresan 2 vectores complejos de longitud n, retorna el producto interno entre estos'''
    if len(vector1) != len(vector2): raise 'Los vectores no tienen la misma longitud, su producto interno no esta definido'
    aux = (0,0)
    for i in range(len(vector1)): 
        aux = suma(aux,multiplicacion(vector1[i],vector2[i]))
    return aux;




def moduloVector(vector):
    '''Se ingresa un vector complejo, retorna el modulo del vector'''
    aux = 0
    for i in vector:
        aux += modulo(i)**2
    return round(aux**0.5,3)




def distanciaEntreVectores(vector1,vector2):
    '''Se ingresan 2 vectores complejos de longitud n, retorna la distancia entre estos'''
    if len(vector1) != len(vector2): raise 'Los vectores no tienen la misma longitud, su producto interno no esta definido'
    return moduloVector(restaVectores(vector1,vector2))



        
def esHermitiana(matriz):
    '''Entra una matriz cuadrada, Retorna verdadero  si la matriz es hermitiana(igual a su propia traspuesta conjugada)'''
    if len(matriz) != len(matriz[0]):  raise 'La matriz no es cuadrada'
    return matriz == matrizAdjunta(matriz)




def esUnitaria(matriz):
    '''Entra una matriz cuadrada, Retorna verdadero  si la matriz es unitaria'''
    if len(matriz) != len(matriz[0]):  raise 'La matriz no es cuadrada'
    i = [[(float(0),float(0)) for w in range(len(matriz))]for j in range(len(matriz))]
    for k in range(len(i)):
        i[k][k] = (float(1),float(0))
    return multiplicacionMatrices(matriz,matrizAdjunta(matriz)) == multiplicacionMatrices(matrizAdjunta(matriz),matriz) == i




def productoTensor(matriz1,matriz2):
    '''Entran 2 matrices, retorna el producto tensor entre estos'''
    aux = []
    subLista = []
    conta = len(matriz2)
    for i in matriz1:
        valorB = 0
        valorA = 0
        while valorA < conta:
            for num1 in i:
                for num2 in matriz2[valorB]:
                    subLista.append(multiplicacion(num1,num2))
            aux.append(subLista)
            subLista = []
            valorA +=1
            valorB += 1
    return aux



#######de lo clásico a lo cuántico



def marbels(matrizAdj, estadoInicial, clicks):
    '''Se simula el experimento de  las canicas despues de varios clicks'''
    while clicks > 0:
        clicks -= 1
        aux = []
        for i in range(len(matrizAdj)):
            sume = (0,0)
            for j in range(len(estadoInicial)):
               sume = suma(sume,multiplicacion(estadoInicial[j],matrizAdj[i][j]))
            aux.append(sume)
        estadoInicial  = aux
    return aux



def barras(matrizAdj, estadoInicial, clicks):
    '''Se simula el experimento de  barra con una cantidad de clicks'''
    while clicks > 0:
        clicks -= 1
        aux = []
        for i in range(len(matrizAdj)):
            sume = (0,0)
            for j in range(len(estadoInicial)):
               sume = suma(sume,multiplicacion(estadoInicial[j],matrizAdj[i][j]))
            aux.append(sume)
        estadoInicial  = aux
    return aux



def dobleRendija(matriz,clicks):
    '''Se realiza el esperimento de la doble rendija'''
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            for x in range(clicks):
                matriz[i][j] = multiplicacion(matriz[i][j],matriz[i][j])
            matriz[i][j] = modulo(matriz[i][j])
    return matriz
    **/
    public void printear() {
        for (int i = 0; i < m; i++) for(int j = 0; j<n; j++) System.out.println("linea "+(i+1)+" Columna "+(j+1)+" ->  ("+espacio[i][j].getReal()+","+espacio[i][j].getImg()+"i)");
    }
}
