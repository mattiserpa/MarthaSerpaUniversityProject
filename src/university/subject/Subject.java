package university.subject;

import java.util.*;

import university.student.Student;
import university.teacher.Teacher;

public class Subject {
	
	private int id;
	private String name;
	private String classroomId;
	private Teacher teacher;
	private List<Student> students;
	
	
    public static Subject create (int _id, String _name, String _classroomId, Teacher _teacher,List<Student> _students) {
		
		Subject _subject = new Subject();
		_subject.setId(_id);
		_subject.setName(_name);
		_subject.setClassroomId(_classroomId);
		_subject.setTeacher(_teacher);
		_subject.students = _students;
				
		return _subject;
		
	}
	
	public static Subject findById(List<Subject> subjectList,int id) {
		
		for (Subject subject : subjectList) {
			if(subject.getId() == id) {
				return subject;
			}
		}
		return null;
		
	}
	
	public static List<Subject> findSubjectsByStudentId(List<Subject> subjectList,int studentId) {		
		List<Subject> filteredList = new ArrayList<Subject>();
		for (Subject subject : subjectList) {
			// validate if the student exists in this subject
			if(Student.findById(subject.getStudents(), studentId) != null) {
				filteredList.add(subject);
			}
		}
		
		return filteredList;		
	}
	
	public static List<Subject> AddStudent(List<Subject> subjectList,int id, Student student) {
		
		for (Subject subject : subjectList) {
			if(subject.getId() == id) {
				subject.students.add(student);
				return subjectList;
			}
		}
		return subjectList;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	

	

}
