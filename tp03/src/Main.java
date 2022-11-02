import java.io.PrintStream;

import structures.Heap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintStream out = System.out;
		out.println("Nombre d'arguments :" + args.length);
		/**for(int i=0; i<args.length; i++) {
			out.println(args[i]);
		}*/
		
		Heap heap = new Heap(args);
		String[] heapTrie = heap.sort();
	
		for(String arg : heapTrie) {
			out.println(arg);
		}
	}

}
