import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import student_manage.Student;
import student_manage.Studentdao;

public class Start {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Student Management System====");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("1. Add student");
			System.out.println("2. Delete Student");
			System.out.println("3. Show Students");
			System.out.println("4. Exit");
			System.out.println("--------------------------");
			
			int choice=Integer.parseInt(br.readLine());
			
			if(choice==1)
			{
				//add student
				System.out.println("Enter Student Name..");
				String name = br.readLine();
				
				System.out.println("Enter Student Phone..");
				String phone=br.readLine();
				
				System.out.println("Enter Student City..");
				String city=br.readLine();
				
				//create student object to store student
				Student st=new Student(name, phone, city);
				boolean ans=Studentdao.insertStudentDB(st);
				if(ans)
				{
					System.out.println("student is successfully added");
				}
				else
				{
					System.out.println("Something wen wrong");
				}
				System.out.println(st);
				
			}
			else if(choice==2)
			{
				//delete student
				System.out.println("Enter student id to delete ");
				int studenttId=Integer.parseInt(br.readLine());
				boolean ans1 = Studentdao.deleteStudentDB(studenttId);
				if(ans1)
				{
					System.out.println("deleted.. ");
				}
				else
				{
					System.out.println("something went wrong ");
				}
				
			}
			else if(choice==3)
			{
				//show student
			Studentdao.showAllStudents();
			}
			else if(choice==4)
			{
				break; 
			}
			else
			{
				
			}
		}
    System.out.println(" Thank you !!");
	}

}
