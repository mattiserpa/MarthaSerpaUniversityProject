package university.student;

import java.util.List;

public class Student {
	
	private int id;
	private String name;
	private int age;
	
	public static Student create (int _id, String _name, int _age) {
			
		Student _student = new Student();
		_student.setId(_id);
		_student.setName(_name);
		_student.setAge(_age);
		
		return _student;
			
		}
	
	public static Student findById(List<Student> studentList,int id) {
		
		for (Student student : studentList) {
			if(student.getId() == id) {
				return student;
			}
		}
		return null;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
