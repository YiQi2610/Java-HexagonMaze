import java.util.Arrays;

import structures.Heap;


public class HeapSortTest {
	public static void main(String[] args) {
		String[] tab = {"4","1","2","3"};
		String[] res = new Heap(tab).sort();
		String[] ref = {"1","2","3","4"};
		System.out.println();
		
		if(Arrays.equals(res, ref)) {
			System.out.println("test ok");
		}
		else {
			System.out.println("not sorted");
		}
	}
}
