package model.users;

public abstract class Teacher extends Person {
    protected double baseSalary;

    public Teacher( String name, int age, String identification, double baseSalary) {
        super( name, age, identification);
        this.baseSalary = baseSalary;
    }


    public abstract double calculateSalary();

    public String getTeacherData() {
        return "- CC " + this.getIdentification() + " - " +
                this.getName() + ".";
    }


}
