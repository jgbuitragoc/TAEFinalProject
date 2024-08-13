package model.users;

public class FullTimeTeacher extends Teacher {

    private int experienceYears;

    public FullTimeTeacher(String name, int age, String identification, double baseSalary, int experienceYears) {
        super(name, age, identification, baseSalary);
        this.experienceYears = experienceYears;

    }

    @Override
    public double calculateSalary() {
        return this.baseSalary * (this.experienceYears * 1.1);
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public String getTeacherFullData() {
        return "CC:" + this.getIdentification() + " - base salary: $" + this.baseSalary + " - Name:" +
                this.getName() + " - experience years: " + this.experienceYears + " - Salary: $"
                + this.calculateSalary();
    }
}
