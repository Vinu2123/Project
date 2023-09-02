package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentInterfqaceImpl implements StudentInterface {
	Scanner scn=new Scanner(System.in);
	@Override
	public void addStudent() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedstaetment=connection.prepareStatement("insert into student values(?,?,?,?,?)");
			System.out.println("Enter student id");
			preparedstaetment.setInt(1,scn.nextInt());
			
			System.out.println("Enter student name");
			preparedstaetment.setString(2, scn.next());
			
			System.out.println("Enter student age");
			preparedstaetment.setInt(3,scn.nextInt());
			
			System.out.println("Enter student phno");
			preparedstaetment.setInt(4,scn.nextInt());
			
			System.out.println("Enter student marks");
			preparedstaetment.setDouble(5,scn.nextDouble());
			
			
			preparedstaetment.execute();
			System.out.println("Data Saved Susesfully");
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deletStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("delete from student where sid = ?");
			System.out.println("Enter id to delet");
			preparedstatement.setInt(1, scn.nextInt());
			preparedstatement.execute();
			System.out.println("data deleted susefully");
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void updateStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","root");
			PreparedStatement preparedstatement=connection.prepareStatement("update student set sname=? where sid=?");
			System.out.println("enter the name to upadte");
			preparedstatement.setString(1, scn.next());
			
			System.out.println("enter the id to upadte");
			preparedstatement.setInt(2, scn.nextInt());
			
			preparedstatement.execute();
			System.out.println("data updated susefully");
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void getAllStudent() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
	        PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt(1);
	            String name = resultSet.getString(2);
	            int age = resultSet.getInt(3);
	            int phno = resultSet.getInt(4);
	            double marks = resultSet.getDouble(5);

	            System.out.println("Student ID: " + id);
	            System.out.println("Student Name: " + name);
	            System.out.println("Student Age: " + age);
	            System.out.println("Student Phone Number: " + phno);
	            System.out.println("Student Marks: " + marks);
	            System.out.println("-----------------------------");
	        }

	        connection.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void getStudentByMarks() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase", "root", "root");
	        PreparedStatement preparedStatement = connection.prepareStatement("select * from student where marks >= ?");
	        
	        System.out.println("Enter minimum marks:");
	        double minMarks = scn.nextDouble();
	        
	        preparedStatement.setDouble(1, minMarks);
	        
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt(1);
	            String name = resultSet.getString(2);
	            int age = resultSet.getInt(3);
	            int phno = resultSet.getInt(4);
	            double marks = resultSet.getDouble(5);

	            System.out.println("Student ID: " + id);
	            System.out.println("Student Name: " + name);
	            System.out.println("Student Age: " + age);
	            System.out.println("Student Phone Number: " + phno);
	            System.out.println("Student Marks: " + marks);
	            System.out.println("-----------------------------");
	        }

	        connection.close();
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	}

}
