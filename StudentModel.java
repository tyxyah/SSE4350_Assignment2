package assignment2;

public class StudentModel {
	
	//Variable declaration
	private int id;
	private String name;
	private String department;
	private int math_mark;
	private int sc_mark;
	
	//Accessor methods
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getMath_mark() {
		return math_mark;
	}
	
	public int getSc_mark() {
		return sc_mark;
	}
	
	//Mutator methods
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setMath_mark(int math_mark) {
		this.math_mark = math_mark;
	}
	
	public void setSc_mark(int sc_mark) {
		this.sc_mark = sc_mark;
	}
}
