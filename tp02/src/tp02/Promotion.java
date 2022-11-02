package tp02;

import java.io.PrintStream;
import java.util.ArrayList;

public class Promotion {
	private ArrayList<Student> studentList;

	public Promotion() {
		studentList = new ArrayList<Student>();
	}
	
	public int newId() {
		if((studentList).size() == 0) {
			
			return 0;
		}
		else {
			int max = studentList.get(0).getId();
			for(int i=0; i<(studentList).size(); i++) {
				if(studentList.get(i).getId() > max) {
					max = studentList.get(i).getId();
				}
			}
			return max+1;
		}
	}
	
	public int add(String firstName, String lastName) {
		int idNewStudent = newId();
		studentList.add(new Student(idNewStudent, firstName, lastName));
		return idNewStudent;
	}
	
	public void printToConsole() {
		PrintStream out = System.out;
		for(Student student : studentList) {
			out.println(student);
		}
	}
	
	private void swap (int i, int j) {
		Student saveStudent = studentList.get(j);
		
		studentList.set(j,studentList.get(i));
		studentList.set(i,saveStudent);
	}
	
	public void selectionSort() {
		for(int i=0; i<(studentList.size())-1; i++) {
			int minIndex = i;
			Student min = studentList.get(i);
			
			for(int j=i+1; j<studentList.size(); j++) {
				Student sj = studentList.get(j);
				int compare = sj.compareTo(min);
				if(compare<0) {
					minIndex = j;
					min = sj;
				}				
			}
			swap(i,minIndex);
		}
	}
	
	private int partition(int g, int d) {
		Student key = studentList.get(g);
		int i = g+1;
		int j = d;
		
		while(i<=j) {
			while(i<=j && studentList.get(i).compareTo(key)<=0) {
				i++;
			}
			while(j>=i && studentList.get(j).compareTo(key)>0) {
				j--;
			}
			if(i<j) {
				swap(i,j);
				i++;
				j--;
			}
		}
		swap(g,j);
		return j;
	}
	
	public void quickSort() {
		quickSort(0, studentList.size()-1);
	}
	
	private void quickSort(int g, int d) {
		if(g<d) {
			int j = partition(g,d);
			quickSort(g, j-1);
			quickSort(j+1, d);
		}
	}
}
