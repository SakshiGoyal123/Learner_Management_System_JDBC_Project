import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyProject {

	public static void main(String[] args) throws Exception {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/LearnerManagementSystem";
		String uname="root";
		String password="Oneplusnord2@";
		
		Connection obj = DriverManager.getConnection(url,uname,password);
		Statement st = obj.createStatement();
		
		String sql;
//		
//		sql = "create table Student(lid int, lname varchar(30), degree varchar(20))";
//		st.execute(sql);
//		System.out.println("Table created in the database successfully!!!");
		
//		
//		sql="insert into learner values(1,'mabe','computer science')";
//		st.executeUpdate(sql);
//		System.out.println("record is inserted !!");
//		
		
		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("enter the id :");
//		int lid = sc.nextInt();
//		
//		System.out.println("enter the name : ");
//		String lname=sc.next();
//		
//		System.out.println("enter degree");
//		String degree= sc.next();
//		
//		
//		sql = "insert into learner(lid, lname, degree) values("+lid+",'"+lname+"','"+degree+"')";
//		
//		st.executeUpdate(sql);
//		System.out.println("Records inserted !!");
		
		
		ResultSet rs =  null;
		rs= st.executeQuery("select * from learner");
		while(rs.next())
		{
			System.out.println("id :"+rs.getInt(1)+ "name : "+rs.getString(2)+"degree :"+rs.getString(3));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		st.close();
		obj.close();
		
		
		
		
	}

}
