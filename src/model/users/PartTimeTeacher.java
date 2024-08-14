package model.users;

public class PartTimeTeacher extends Teacher {

    private int weeklyHours;

    public PartTimeTeacher(String name, int age, String identification, double baseSalary, int weeklyHours) {
        super(name, age, identification, baseSalary);
        this.weeklyHours = weeklyHours;
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary * weeklyHours;
    }

    public void setWeeklyHours(int weeklyHours) {
        this.weeklyHours = weeklyHours;
    }

    @Override
    public String getTeacherFullData() {
        return "Part time teacher - CC:" + this.getIdentification() + " - base salary: $" + this.baseSalary + " - Name:" +
                this.getName() + " - weekly hours: " + this.weeklyHours + " - Salary: "
                + this.calculateSalary();
    }
}
