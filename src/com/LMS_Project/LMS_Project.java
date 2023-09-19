package com.LMS_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LMS_Project {

	public static void main(String[] args) throws Exception {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	String url="jdbc:mysql://localhost:3306/learnermanagementsystem";
	String uname="root";
	String password="Oneplusnord2@";
	
	Connection obj= DriverManager.getConnection(url,uname,password);
	Statement st = obj.createStatement();
	ResultSet rs= null;
	
	
	Scanner sc= new Scanner(System.in);
	
	int ch;
	
	do
	{
		System.out.println("____________________*****-----*****______________________");
		System.out.println("1. Create learner Table ");
		System.out.println("2. Insert data");
		System.out.println("3. Display records");
		System.out.println("4. Update records");
		System.out.println("5. Delete records ");
		System.out.println("6. Search operation");
		System.out.println("7. count records ");
		System.out.println("8. order by (Asc/ desc order )");
		System.out.println("9. like keyword");
		System.out.println("10. exit");
		
		
		System.out.println("enter your choice ...?");
		ch=sc.nextInt();
		
		String sql;
		int lid, lage;
		String lname;
		String lcity;
		switch(ch)
		{
		
		case 1: // create table 
			
			sql ="create table learner(lid int, lname varchar(20), lcity varchar(20), lage int);";
			st.execute(sql);
			System.out.println("Learner Table created !!");
			break;
			
		case 2: // insert
			System.out.println("enter the Learner Id : ");
			lid=sc.nextInt();
			
			System.out.println("enter the learner name :");
			lname= sc.next();
			
			System.out.println("enter the learner city :");
			lcity= sc.next();
			
			System.out.println("enter the learner age:");
			lage=sc.nextInt();
			
			sql =" insert into learner(lid, lname, lcity, lage) values("+lid+", '"+lname+"','"+lcity+"', "+lage+")";
			st.executeUpdate(sql);
			System.out.println("Records inserted successfully ");
			
			break;
			
			
		case 3: // display
			
			sql= "select * from learner";
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("___________________________________________________________");
				
				System.out.println("Learner id :"+rs.getInt(1));
				System.out.println("Learner name :"+rs.getString(2));
				System.out.println("Learner city :"+rs.getString(3));
				System.out.println("Learner age :"+rs.getString(4));
				
				System.out.println("___________________________________________________________");
			}
			
			
			break;
			
			
		case 4: //update 
			System.out.println("Enter the id whose data you wanted to update ");
			lid=sc.nextInt();
			
			System.out.println("enter the new name");
			lname=sc.next();
			
			System.out.println("enter the new city");
			lcity=sc.next();
			
			System.out.println("enter the new age");
			lage=sc.nextInt();
			
			
			sql ="update learner set lname='"+lname+"', lcity='"+lcity+"', lage="+lage+" where lid="+lid+"";
			
			st.executeUpdate(sql);
			System.out.println("Data updated successfully !!");
			
			break;
			
			
		case 5:  //delete 
			
			
			System.out.println("Enter the learner Id whose data you wanna delete !");
			lid=sc.nextInt();
			
			sql="delete from learner where lid="+lid+"";
			st.executeUpdate(sql);
			
			System.out.println("Learner data deleted successfully");
			break;
			
			
		case 6:  //search 
			
			System.out.println("enter the learner id which you wanna search");
			lid=sc.nextInt();
			
			sql ="select * from learner where lid="+lid+"";
			rs=st.executeQuery(sql);
			
			if(rs.next())
			{
				System.out.println("Data is present in the database !");
				System.out.println("___________________________________________________________");
				
				System.out.println("Learner id :"+rs.getInt(1));
				System.out.println("Learner name :"+rs.getString(2));
				System.out.println("Learner city :"+rs.getString(3));
				System.out.println("Learner age :"+rs.getString(4));
				
				System.out.println("___________________________________________________________");
				
			}
			else 
				
			{
				System.out.println("Data is not present in the database ");
			}
			
			break;
			
			
			
			
			
		case 7:
			sql= "select count(*) from learner";
			rs=st.executeQuery(sql);
			rs.next();
			System.out.println("The total records are : "+rs.getInt(1));
			break;
			
			
		case 8: // convert in asc/desc
			sql ="select * from learner order by lid desc";
			rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println("___________________________________________________________");
				
				System.out.println("Learner id :"+rs.getInt(1));
				System.out.println("Learner name :"+rs.getString(2));
				System.out.println("Learner city :"+rs.getString(3));
				System.out.println("Learner age :"+rs.getString(4));
				
				System.out.println("___________________________________________________________");
			}
			
			break;
			
			
		case 9: // like 
			
			sql ="select * from learner where lname like 'N%'";
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("___________________________________________________________");
				
				System.out.println("Learner id :"+rs.getInt(1));
				System.out.println("Learner name :"+rs.getString(2));
				System.out.println("Learner city :"+rs.getString(3));
				System.out.println("Learner age :"+rs.getString(4));
				
				System.out.println("___________________________________________________________");
			}
			
			break;
			
			
		case 10:
			System.exit(0);
			
			
			
		}
		
		
			
		
	}
	while(ch!=9);
	
	st.close();
	obj.close();
	
	
	
	
	
	

	}

}
