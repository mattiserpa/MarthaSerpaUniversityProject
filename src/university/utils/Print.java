package university.utils;

import java.util.*;
import university.subject.Subject;
import university.teacher.Teacher;

public class Print {
	public static void showTeachers (List<Teacher> teacherList) {
		
		System.out.println("Teachers List: ");
		System.out.format("%16s%16s%16s%16s%16s%n","Id", "Name", "Base Salary", "Salary", "Contract");
		teacherList.forEach(item->System.out.format("%16d%16s%14.2f%14.2f%16s%n",item.getId(),item.getName(),item.getBaseSalary(),item.getSalary(),item.getContract()));;		
	}
	
	//Print all the subjects by student id	
	public static void showSubjectByStudent(List<Subject> subjectList){
		System.out.println("Enter the student id: ");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		
		
		// Find and print subjects
		Print.showSubjectList(Subject.findSubjectsByStudentId(subjectList, id));
		
	}
	
	//Print all subject information by subject id
	public static void showSubject(List<Subject> subjectList) {
		
		System.out.println("Enter the subject id: ");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
				
		// Find subject
		Subject subject = Subject.findById(subjectList, id);
		
		if(subject != null) {
			// printing
			System.out.println("Subject name:" + subject.getName());
			System.out.println("Classroom: " + subject.getClassroomId());
			System.out.println("Teacher: " + subject.getTeacher().getName());		
			System.out.format("%16s%16s%16s%n","Id", "Name", "Age");
			subject.getStudents().forEach(item->System.out.format("%16d%16s%16d%n",item.getId(),item.getName(),item.getAge()));		
		}
		else { 
			System.out.println("Subject id does not exist:");
		}
		
	}
	
	//Print only the list of subjects
	public static void showSubjectList(List<Subject> subjectList){
		
		System.out.println("Subject List: ");
		System.out.format("%16s%16s%32s%n","Subject Id", "Classroom Id", "Name");
	    subjectList.forEach(item->System.out.format("%16d%16s%32s%n",item.getId(),item.getClassroomId(),item.getName()));
		
	}



}
