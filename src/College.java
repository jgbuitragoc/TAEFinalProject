import model.Entities.Lecture;
import model.users.FullTimeTeacher;
import model.users.PartTimeTeacher;
import model.users.Student;
import model.users.Teacher;

import java.util.ArrayList;
import java.util.List;

import static utils.inputs.*;
import static utils.inputs.getIntFromInput;

public class College {
    private String name;
    private final List<Lecture> globalLectures = new ArrayList<>();
    private final List<Student> globalStudents = new ArrayList<>();
    private final List<Teacher> globalTeachers = new ArrayList<>();


    public College(String name) {
        this.name = name;
        initialize();
    }

    public String createLecture() {
        System.out.print("Enter class name:");
        String name = getStringFromInput();
        System.out.println(" ");
        globalLectures.add(new Lecture(name));
        return "Class created successfully.";
    }

    public String createStudent() {
        System.out.print("Enter student's name: ");
        String name = getStringFromInput();
        System.out.println(" ");
        System.out.print("Enter student's age: ");
        int age = getIntFromInput();
        System.out.println(" ");
        System.out.print("Enter student's identification: ");
        String identification = getStringFromInput();
        globalStudents.add(new Student(name, age, identification));
        return "Student created successfully.";
    }

    public String createTeacher() {
        int teacherType = 0;
        while (teacherType == 0) {
            System.out.println("Choose a type of teacher:");
            System.out.println("1. Full time teacher.");
            System.out.println("2. Part time teacher.");
            System.out.print("Type:");
            teacherType = getIntFromInput();
            if (teacherType > 2) { //number of options
                teacherType = 0;
            }
        }

        System.out.print("Enter teacher's name: ");
        String name = getStringFromInput();
        System.out.println(" ");
        System.out.print("Enter teacher's age: ");
        int age = getIntFromInput();
        System.out.println(" ");
        System.out.print("Enter teacher's identification: ");
        String identification = getStringFromInput();
        System.out.println(" ");
        System.out.print("Enter teacher's base salary in pesos: $");
        double baseSalary = getFloatFromInput();
        Teacher newTeacher;
        switch (teacherType) {
            case 1:
                System.out.print("Enter teacher's experience years:");
                int experienceYears = getIntFromInput();
                newTeacher = new FullTimeTeacher(name, age, identification, baseSalary, experienceYears);
                this.globalTeachers.add(newTeacher);
                return "Teacher created successfully.";
            case 2:
                System.out.print("Enter teacher's hours per week:");
                int weeklyHours = getIntFromInput();
                newTeacher = new PartTimeTeacher(name, age, identification, baseSalary, weeklyHours);
                this.globalTeachers.add(newTeacher);
                return "Teacher created successfully.";
            default:
                break;
        }
        return "Teacher not created!";
    }


    public String lecturesMenu() {
        int lectureOption = 0;
        while (lectureOption == 0) {
            System.out.println("Class options:");
            System.out.println("1. Create a new class.");
            System.out.println("2. Get class information by id.");
            System.out.println("3. Set classroom by id.");
            System.out.println("4. Set teacher by id.");
            System.out.println("5. Back.");
            System.out.print("Option: ");
            lectureOption = getIntFromInput();
            if (lectureOption == 1) {
                return this.createLecture();
            } else if (lectureOption == 2 || lectureOption == 3 || lectureOption == 4) {
                System.out.print("Enter class id:");
                int lectureId = getIntFromInput();
                System.out.println(" ");
                Lecture lecture = this.getLectureById(lectureId);
                if (lecture == null) {
                    return "Lecture not found.";
                }
                if (lectureOption == 2) {
                    return lecture.getLectureData();
                }
                if (lectureOption == 3) {
                    System.out.print("Classroom:");
                    String classroom = getStringFromInput();
                    lecture.setClassroom(classroom);
                    return "Classroom " + lecture.getClassroom()
                            + " asigned to class " + lecture.getName();
                }
                if (lectureOption == 4) {
                    System.out.println("Available teachers:");
                    System.out.println(this.getTeachersInfo());
                    System.out.print("Teacher to assign id:");
                    int teacherId = getIntFromInput();
                    System.out.println(" ");
                    Teacher teacher = this.getTeacherById(teacherId);
                    if (teacher != null) {
                        lecture.setTeacher(teacher);
                        return "Teacher " + lecture.getTeacher().getName()
                                + " assigned to class " + lecture.getName();
                    } else {
                        return "Teacher not found.";
                    }
                } else if (lectureOption != 5) {
                    lectureOption = 0;
                }
            }
        }
        return "";
    }

    public String teachersMenu() {
        int teacherOption = 0;
        while (teacherOption == 0) {
            System.out.println("Teachers options:");
            System.out.println("1. Create a new teacher.");
            System.out.println("2. Show teachers list.");
            System.out.println("3. Show teacher info by id.");
            System.out.println("4. Back");
            System.out.print("Option: ");
            teacherOption = getIntFromInput();
            if (teacherOption == 1) {
                return this.createTeacher();
            }
            if (teacherOption == 2) {
                return this.getTeachersInfo();
            }
            if (teacherOption == 3) {
                System.out.println("Teachers:");
                System.out.println(this.getTeachersInfo());
                System.out.print("Teacher id: ");
                int teacherId = getIntFromInput();
                Teacher teacher = this.getTeacherById(teacherId);
                if (teacher == null) {
                    return "Teacher not found";
                }
                return teacher.getTeacherFullData();
            } else if (teacherOption != 4) {
                teacherOption = 0;
            }
        }
        return "";
    }

    public String studentsMenu() {
        int studentOption = 0;
        while (studentOption == 0) {
            System.out.println("Students options:");
            System.out.println("1. Create a new student.");
            System.out.println("2. Get student classes by id.");
            System.out.println("3. Enroll student to a class.");
            System.out.println("4. Back");
            studentOption = getIntFromInput();
            if (studentOption == 1) {
                return this.createStudent();
            } else if (studentOption == 2 || studentOption == 3) {
                System.out.print("Enter student id:");
                int studentId = getIntFromInput();
                System.out.println(" ");
                Student student = this.getStudentById(studentId);
                if (student == null) {
                    return "Student not found.";
                }
                if (studentOption == 2) return student.getLecturesInfo();
                if (studentOption == 3) {
                    System.out.println("Classes available:");
                    System.out.println(this.getLecturesInfo());
                    System.out.print("Class id: ");
                    int lectureId = getIntFromInput();
                    Lecture lecture = this.getLectureById(lectureId);
                    if (lecture == null) {
                        return "Class not found";
                    }
                    return lecture.enrollStudent(student);
                }
            } else if (studentOption != 4) {
                studentOption = 0;
            }
        }
        return "";
    }


    public String getLecturesInfo() {
        StringBuilder lecturesInfo = new StringBuilder();
        int index = 0;
        for (Lecture lecture : this.globalLectures) {
            lecturesInfo.append("(id: ").append(index).append(" ) ")
                    .append(lecture.getName()).append("\n");
            index++;
        }
        return lecturesInfo.toString();
    }

    public String getStudentsInfo() {
        StringBuilder studentsInfo = new StringBuilder();
        int index = 0;
        for (Student student : this.globalStudents) {
            studentsInfo.append("(id: ").append(index).append(" ) ")
                    .append(student.getName()).append("\n");
            index++;
        }
        return studentsInfo.toString();
    }

    public String getTeachersInfo() {
        StringBuilder teachersInfo = new StringBuilder();
        int index = 0;
        for (Teacher teacher : this.globalTeachers) {
            teachersInfo.append("( id:").append(index).append(") ")
                    .append(teacher.getTeacherData()).append("\n");
            index++;
        }
        return teachersInfo.toString();
    }


    public Lecture getLectureById(int id) {
        try {
            return this.globalLectures.get(id);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    public Teacher getTeacherById(int id) {
        try {
            return this.globalTeachers.get(id);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    public Student getStudentById(int id) {
        try {
            return this.globalStudents.get(id);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }


    public String getName() {
        return name;
    }

    private void initialize() {
        Teacher teacher1 = new FullTimeTeacher("ROBERT FLOWERS", 70, "45678643", 100000, 20);
        Teacher teacher2 = new FullTimeTeacher("FREDDY DONOVAN", 50, "52323123", 100000, 15);
        Teacher teacher3 = new PartTimeTeacher("LAURA BONILLA", 30, "12312333", 10000, 3);
        Teacher teacher4 = new PartTimeTeacher("CAMILO CIFUENTES", 35, "57664231", 10000, 4);
        this.globalTeachers.add(teacher1);
        this.globalTeachers.add(teacher2);
        this.globalTeachers.add(teacher3);
        this.globalTeachers.add(teacher4);


        Student student1 = new Student("CARLOS SANABRIA", 20, "11234123");
        Student student2 = new Student("PETER GINEBRA", 21, "13236767");
        Student student3 = new Student("ROMARIO LUCUMI", 19, "12988676");
        Student student4 = new Student("CAROLINA LAPORCHE", 20, "12348676");
        Student student5 = new Student("NEFARIO LALINDE", 20, "12398765");
        Student student6 = new Student("RUPERTA MANRIQUE", 22, "12425894");
        this.globalStudents.add(student1);
        this.globalStudents.add(student2);
        this.globalStudents.add(student3);
        this.globalStudents.add(student4);
        this.globalStudents.add(student5);
        this.globalStudents.add(student6);

        Lecture lecture1 = new Lecture("MATH");
        Lecture lecture2 = new Lecture("HISTORY");
        Lecture lecture3 = new Lecture("SPANISH");
        Lecture lecture4 = new Lecture("SCIENCE");

        lecture1.setClassroom("classroom 1");
        lecture2.setClassroom("classroom 2");
        lecture3.setClassroom("classroom 3");
        lecture4.setClassroom("classroom 4");

        lecture1.setTeacher(teacher1);
        lecture2.setTeacher(teacher2);
        lecture3.setTeacher(teacher3);
        lecture4.setTeacher(teacher4);

        lecture1.enrollStudent(student1);
        lecture1.enrollStudent(student2);
        lecture1.enrollStudent(student3);

        lecture2.enrollStudent(student2);
        lecture2.enrollStudent(student3);
        lecture2.enrollStudent(student4);

        lecture3.enrollStudent(student3);
        lecture3.enrollStudent(student4);
        lecture3.enrollStudent(student5);

        lecture4.enrollStudent(student4);
        lecture4.enrollStudent(student5);
        lecture4.enrollStudent(student6);
        this.globalLectures.add(lecture1);
        this.globalLectures.add(lecture2);
        this.globalLectures.add(lecture3);
        this.globalLectures.add(lecture4);
    }


}
