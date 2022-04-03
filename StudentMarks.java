package assignment2;
import java.sql.*; 
import java.util.Scanner;

public class StudentMarks {
	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		
		//Initialize M-V-C classes
		StudentModel model = new StudentModel();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(model, view);
		
		//Variable declaration
		int id;
		String name;
		String department;
		int math_mark;
		int sc_mark;
		
		System.out.print("Please choose: \n1. Save data to database \n2. Get data from database\n\nInsert your choise: ");
		int choise = scan.nextInt();
		
		if(choise == 1) {
			
			//Get data from user
			System.out.print("\nInsert student data");
			System.out.print("\nStudent ID: ");
			id = scan.nextInt();
			
			System.out.print("Name: ");
			name = scan.next();
			
			System.out.print("Department: ");
			department = scan.next();
			
			System.out.print("Math mark: ");
			math_mark = scan.nextInt();
			
			System.out.print("Science mark: ");
			sc_mark = scan.nextInt();
			
			//Send data to Controller class
			controller.saveData(id, name, department, math_mark, sc_mark);
			
		}else if(choise == 2) {
			
			//Get student id from user
			System.out.print("\nEnter student id: ");
			int studId = scan.nextInt();
			
			try {
				//Send student id to Controller class
				controller.readData(studId);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}
}
