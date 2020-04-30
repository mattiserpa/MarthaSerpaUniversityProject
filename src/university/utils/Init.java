package university.utils;

import java.io.*;
import java.util.*;

import university.student.Student;
import university.subject.Subject;
import university.teacher.FullTimeTeacher;
import university.teacher.PartTimeTeacher;
import university.teacher.Teacher;

public class Init {
	private List<Student> students = new ArrayList<Student>();
	private List<Teacher> teachers = new ArrayList<Teacher>();
	private List<Subject> subjects = new ArrayList<Subject>();
	
	
	public Init (){
		try {
			//Read CSV file
			InputStream in = getClass().getClassLoader().getResourceAsStream("teachers.csv");
			BufferedReader csvReader = new BufferedReader(new InputStreamReader(in));
			String row = null;
			
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			    if(!data[0].contains(".")) {
			    	Student student = Student.findById(students, Integer.parseInt(data[8]));
			    	Teacher teacher = Teacher.findById(teachers, Integer.parseInt(data[3]));
			    	Subject subject = Subject.findById(subjects, Integer.parseInt(data[0]));
			    	
			    	// Add students
			    	if(student == null) {
			    		student = Student.create(
		    						Integer.parseInt(data[8]), 
		    						data[9], 
		    						Integer.parseInt(data[10])
	    						);
			    		students.add(student);
			    	}
			    	//Add Teachers
			    	if (teacher == null) {
			    		if(data[6].equals("full-time")) {
			    			teacher = FullTimeTeacher.create(
				    					Integer.parseInt(data[3]), 
				    					data[4],
				    					Double.parseDouble(data[5]), 
				    					Integer.parseInt(data[7])
			    					);
					    	teachers.add(teacher);
					    }
					    else if (data[6].equals("part-time")) {
			    			teacher = PartTimeTeacher.create(
			    					Integer.parseInt(data[3]), 
			    					data[4],
			    					Double.parseDouble(data[5]), 
			    					Integer.parseInt(data[7])
		    					);
					    	teachers.add(teacher);
					    }
			    	}
			    	//Add subjects
			    	if (subject == null) {
			    		List<Student> newStudents = new ArrayList<Student>();
			    		newStudents.add(student);
			    		subject = Subject.create(
				    				Integer.parseInt(data[0]), 
				    				data[1], 
				    				data[2], 
				    				teacher, 
				    				newStudents
			    				);
			    		subjects.add(subject);    		
			    	}
			    	else {
			    		//Add new student to subject
			    		subjects = Subject.AddStudent(subjects, subject.getId(), student);
			    	}
	    	 
			    }
			}
			csvReader.close();
		} catch (Exception e) {
			System.out.println("Oopss lists are empty!!");
			System.out.println("Please pre-load CSV file");
			System.out.println(" ");
		}
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}


	public List<Teacher> getTeachers() {
		return teachers;
	}


	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}


	public List<Subject> getSubjects() {
		return subjects;
	}


	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
