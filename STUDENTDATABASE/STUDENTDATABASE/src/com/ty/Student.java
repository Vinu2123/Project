package com.ty;

import java.util.Scanner;

public class Student {
   public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	StudentInterface s1=new StudentInterfqaceImpl();
	while(true) {
		System.out.println("Student Data Base");
		System.out.println("1:Addstudent\2:DeletStudent\3:UpdateStudent\4:Getallstudent\5:Getstudentby marks");
		System.out.println("enter choice from 1to 4");
		int choice=scn.nextInt();
		
		switch(choice) {
		case 1:  s1.addStudent();
		break;
		case 2:  s1.deletStudent();
		break;
		case 3: s1.updateStudent();
		break;
		case 4:  s1.getAllStudent();
		break;
		case 5:   s1.getStudentByMarks();
		break;
		}
	}
}
}
