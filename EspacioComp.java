

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
	
	public void printear() {
		for (int i = 0; i < m; i++) for(int j = 0; j<n; j++) System.out.println("linea "+(i+1)+" Columna "+(j+1)+" ->  ("+espacio[i][j].getReal()+","+espacio[i][j].getImg()+"i)");
	}
}
