package structures;

import java.util.Arrays;

public class Heap {
	private final String[] heap;
	
	public Heap(String[] args) {
		//heap = Arrays.copyOf(args,args.length);
		heap = args.clone();
	}
	
	private void swap(int i, int j) {
		String save = heap[i];
		heap[i] = heap[j];
		heap[j] = save;
	}
	
	private void pullUp(int k) {
		int i = k-1;
		int p = (i-1)/2;
		
		while(i>=1 && heap[p].compareTo(heap[i])<0) {
			swap(p,i);
			i = p;
			p = (i-1)/2;
		}
	}
	
	private void buildHeap() {
		int cpt = heap.length;
		while(cpt>=1) {
			pullUp(cpt);
			cpt--;
		}
	}
	
	/**private void pullDown (int i, int k) {
		while(i<k-1 && ((heap[i].compareTo(heap[(2*i)+1])<0) || (heap[i].compareTo(heap[(2*i)+2])<0))){
			if(heap[i].compareTo(heap[(2*i)+1])<0){
				swap(i,(2*i)+1);
				i = (2*i)+1;
			}
			else {
				swap(i,(2*i)+2);
				i = (2*i)+2;
			}
		}
	}*/
	
	private void pullDown (int i, int k) {
		int leftsonInd = 2*i+1;
		int rightsonInd = 2*i+2;
		
		//Si le noued n'a pas de fils
		if(leftsonInd >= k) {
			return ;
		}
		
		//Si le noeud a un fils gauche
		if(rightsonInd >= k) {
			if(heap[i].compareTo(heap[leftsonInd])<0) {
				swap(i,leftsonInd);
				return ;
			}
		}
		
		//Si le noeud a un fils gauche et un fils droit
		
		//Le noeud droit est pls grande
		if(heap[leftsonInd].compareTo(heap[rightsonInd])<0) {
			if(heap[i].compareTo(heap[rightsonInd])<0) {
				swap(i,rightsonInd);
				pullDown(rightsonInd,k);
				return ;
			}
		}
		else {//Le noeud gauche est plus grande
			if(heap[i].compareTo(heap[leftsonInd])<0) {
				swap(i,leftsonInd);
				pullDown(leftsonInd,k);
				return ;
			}
		}	
	}
	
	private void sortHeap() {
		int length = heap.length;
		
		for(int k = length; k>=2; k--) {
			swap(0,k-1);
			pullDown(0,k-1);
		}
	}
	
	public String[] sort() {
		buildHeap();
		sortHeap();
		return heap.clone();
	}
}
