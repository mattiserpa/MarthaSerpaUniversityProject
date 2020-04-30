package university.teacher;

import java.util.List;

public abstract class Teacher {
	
	private int id;
	private String name;
	private double baseSalary;
	private double salary;
	private String contract;
	

	public abstract double CalculateSalary();
	
	public static Teacher findById(List<Teacher> teacherList,int id) {
		
		for (Teacher teacher : teacherList) {
			if(teacher.getId() == id) {
				return teacher;
			}
		}
		return null;		
	}

	public double getSalary() {
		salary = CalculateSalary();
		return salary;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getBaseSalary() {
		return baseSalary;
	}


	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}	
}
