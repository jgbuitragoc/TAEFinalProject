package model.users;

public abstract class Person {
    private String name;
    private int age;
    private String identification;

    public Person(String name, int age, String identification) {
        this.name = name;
        this.age = age;
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
