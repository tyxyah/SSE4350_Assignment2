package assignment2;
import java.sql.*;

public class StudentController {
	
	//Variable declaration
	private static StudentModel model = new StudentModel();
	private StudentView view;
	
	//Constructor
	@SuppressWarnings("static-access")
	public StudentController(StudentModel model, StudentView view){
		this.model = model;
		this.view = view;
	}
	
	//Read data from database
	public void readData(int studentId) throws SQLException{       
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?" +
                "user=root&password=207704&useUnicode=true&"
                + "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
                + "serverTimezone=UTC");
		
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// Retrieve results from the table
		ResultSet rs = statement.executeQuery ("Select * from studentmark"); 
		
		// Count columns
		ResultSetMetaData rsmd =rs.getMetaData(); 
		int i =rsmd.getColumnCount( );
				
		// Insert records to Model class
		while(rs.next( ) ) { 
			for(int j=1; j<=i; j++) 
			{ 
				if(Integer.valueOf(rs.getString( 1)) == studentId) {
					if(j == 1)
						model.setId(Integer.valueOf(rs.getString( j)));
					else if(j == 2)
						model.setName(rs.getString( j));
					else if(j == 3)
						model.setDepartment(rs.getString( j));
					else if(j == 4)
						model.setMath_mark(Integer.valueOf(rs.getString( j)));
					else if(j == 5)
						model.setSc_mark(Integer.valueOf(rs.getString( j)));
			}}
		}
		updateView();
	}
	
	//Send data to View class
	public void updateView(){                
        view.printStudentMarks(model.getId(), model.getName(), model.getDepartment(), model.getMath_mark(), model.getSc_mark());
     }
	
	//Save data to database
	public void saveData(int id, String name, String department, int math, int science) throws SQLException {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/db1?" +
                "user=root&password=207704&useUnicode=true&"
                + "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
                + "serverTimezone=UTC");
		
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// insert the data into database
		statement.executeUpdate("INSERT INTO studentmark VALUES (" + id + ", '"+ name + "', '" +
		department + "', " + math + ", " + science + ")");
	}
}
