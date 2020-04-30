package university.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import university.student.Student;
import university.subject.Subject;
import university.teacher.Teacher;

public class Main {

	public static void main(String[] args) {
		// Initialize lists
		// Read from a CSV file and creates all the initial information with this object init
		Init init = new Init();
		List<Student> students = init.getStudents();
		List<Teacher> teachers = init.getTeachers();
		List<Subject> subjects = init.getSubjects();
				
		boolean finish = false;

		while (!finish) {
			
			System.out.println("****UNIVERSITY MENU****\n"
								+ "1. Print list of teachers\n"
								+ "2. Print list of subjects  \n"
								+ "3. Create a new student \n"
								+ "4. Create a new class \n"
								+ "5. Print all Subjects by Student \n"
								+ "6. Exit");
			Scanner scan = new Scanner(System.in);
			int action = scan.nextInt();
			
			switch (action) {
			
			case 1:
				
				System.out.println("Teachers list:\n");
				Print.showTeachers(init.getTeachers());
				
			    break;
			     
			case 2:
				
				Print.showSubjectList(init.getSubjects());				
				Print.showSubject(subjects);
				
				break;
				
			case 3:
								
				System.out.println("Enter student id");
				Scanner scan2 = new Scanner(System.in);
				int idStu = scan2.nextInt();
				
				if (Student.findById(students,idStu) != null) {
					
					System.out.println("Student already exist");
					
				}
				else {
					
					System.out.println("Enter student name");
					Scanner scan3 = new Scanner(System.in);
					String name = scan3.nextLine();
					
					
					System.out.println("Enter student age");
					Scanner scan4 = new Scanner(System.in);
					int age = scan4.nextInt();
					
					
					students.add(Student.create(idStu, name, age));
					System.out.println("Student added");
				}
				
				
				break;
			case 4:
				
				System.out.println("Enter subject id");
				Scanner scan5 = new Scanner(System.in);
				int idSub = scan5.nextInt();
				
				if (Subject.findById(subjects,idSub) != null) {
					
					System.out.println("Subject already exist");
					
				}
				else {
					
					System.out.println("Enter subject name");
					Scanner scan6 = new Scanner(System.in);
					String name = scan6.nextLine();
					
					
					System.out.println("Enter classroom id");
					Scanner scan7 = new Scanner(System.in);
					String classroomId = scan7.nextLine();


					
					System.out.println("Enter teacher id");
					Scanner scan8 = new Scanner(System.in);
					int teacherId = scan8.nextInt();
					Teacher teacher = Teacher.findById(teachers, teacherId);
					
					 if ( teacher == null) {

						 System.out.println("Teacher does not exist");
						 break;
						 
					 }
					 		 
					 List<Student> studentsSubject = new ArrayList<Student>();
					 boolean studentFlag = true;
										 
					 while (studentFlag) {
						 
						 System.out.println("Enter student id");
						 Scanner scan9 = new Scanner(System.in);
						 int studId = scan9.nextInt();
						 
						 Student student = Student.findById(students, studId);
						 
						 if (student != null) {
							 
							 studentsSubject.add(student); 
						 }
						 else {
							 
							 System.out.println("Student does not exist");							 
						 }
						 
						 System.out.println("Press any key to continue adding students - Press 'n' to finish adding students");
						 Scanner scan0 = new Scanner(System.in);
						 String add = scan0.nextLine();
						 
						 if(add.toLowerCase().equals("n")) {
							 
							 studentFlag = false;
							 
						 }
						 
					 }
					
					subjects.add(Subject.create(idSub, name, classroomId, teacher,studentsSubject));
				}
				
				break;
				
			case 5:
				 
				 Print.showSubjectByStudent(subjects);
				 
				break;
				
			case 6:
				
				finish = true;
				System.out.println("Thank you");
				break;
				
			default:
				break;
			}
		}
				
	}

}


