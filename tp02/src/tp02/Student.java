package tp02;

public class Student {
	private final int id;
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public Student(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " " + "(" + id + ")";
	}

	public int compareTo(Student anotherStudent) {
		//Compare last name
		int compareLastName = this.lastName.compareTo(anotherStudent.lastName);
		if(compareLastName != 0) {
			return compareLastName;
		}
		//Compare first name
		int compareFirstName = this.firstName.compareTo(anotherStudent.firstName);
		if(compareFirstName != 0) {
			return compareFirstName;
		}
		
		//Compare id
		if(this.id>anotherStudent.id) {
			return 1;
		}
		else {
			return -1;
		}
	}

}

