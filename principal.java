
public class principal {
	public static void main(String args[]) {
		double[][] datos = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1}};
		double[][] datos2 = {{1,2},{2,3},{3,4},{4,5},{7,5},{3,1}};
		
		EspacioComp lol = new EspacioComp(2,3,datos);
		lol.EspacioSum(new EspacioComp(2,3,datos2));
	}
}
