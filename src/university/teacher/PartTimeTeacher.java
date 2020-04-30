package university.teacher;

public class PartTimeTeacher extends Teacher {
	
	private int activeHours;
	@Override
	public double CalculateSalary() {
		double newSalary = this.getBaseSalary();
		return newSalary*this.getActiveHours();
		
	}
	public int getActiveHours() {
		return activeHours;
	}
	public void setActiveHours(int activeHours) {
		this.activeHours = activeHours;
	}
	
	public static PartTimeTeacher create (int _id, String _name, double _baseSalary, int _activeHours) {
		
		PartTimeTeacher _partTimeTeacher = new PartTimeTeacher();
		_partTimeTeacher.setId(_id);
		_partTimeTeacher.setName(_name);
		_partTimeTeacher.setBaseSalary(_baseSalary);
		_partTimeTeacher.setActiveHours(_activeHours);
		_partTimeTeacher.setContract("Part time");		
		
		return _partTimeTeacher;
		
	}
}
