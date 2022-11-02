package tp02;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Student student = new Student(1024,"Eric","Tartempion");
		//System.out.println(student);
		
		Promotion promotion = new Promotion();
		
		promotion.add("Kerchee", "Tung");
		promotion.add("Albert", "Premier");
		promotion.add("James", "Bond");
		promotion.add("Peter", "Parker");
		promotion.add("Sherlock", "Holmes");
		promotion.add("Jules", "Pierre");
		promotion.add("Huan Shean", "Tung");
		
		promotion.quickSort();
		promotion.printToConsole();
	}
	
}
