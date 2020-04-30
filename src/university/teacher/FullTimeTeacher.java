package university.teacher;

public class FullTimeTeacher extends Teacher {
	
	private int experYears;
		
	@Override
	public double CalculateSalary() {		
		double newSalary = this.getBaseSalary();
		return newSalary*(1.1*this.getExperYears());
	}
	
	public static FullTimeTeacher create (int _id, String _name, double _baseSalary, int _experYears) {
		
		FullTimeTeacher _fullTimeTeacher = new FullTimeTeacher();
		_fullTimeTeacher.setId(_id);
		_fullTimeTeacher.setName(_name);
		_fullTimeTeacher.setBaseSalary(_baseSalary);
		_fullTimeTeacher.setExperYears(_experYears);
		_fullTimeTeacher.setContract("Full time");
		
		return _fullTimeTeacher;
		
	}
	
	public int getExperYears() {
		return experYears;
	}

	public void setExperYears(int experYears) {
		this.experYears = experYears;
	}

}
