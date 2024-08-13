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
                globalTeachers.add(newTeacher);
                return "Teacher created successfully.";
            case 2:
                System.out.print("Enter teacher's hours per week:");
                int weeklyHours = getIntFromInput();
                newTeacher = new PartTimeTeacher(name, age, identification, baseSalary, weeklyHours);
                globalTeachers.add(newTeacher);
                return "Teacher created successfully.";
            default:
                break;
        }
        return "Teacher not created!";
    }


    public String lecturesMenu() {
        System.out.println("------------------");
        int lectureOption = 0;
        while (lectureOption == 0) {
            System.out.println("Class options:");
            System.out.println("1. Get class information by id.");
            System.out.println("2. Set classroom by id.");
            System.out.println("3. Set teacher by id.");
            System.out.println("4. Back.");
            System.out.print("Option: ");
            lectureOption = getIntFromInput();
            if (lectureOption == 1 || lectureOption == 2 || lectureOption == 3) {
                System.out.print("Enter class id:");
                int lectureId = getIntFromInput();
                System.out.println(" ");
                Lecture lecture = getLectureById(lectureId);
                if (lecture == null) {
                    return "Lecture not found.";
                }
                if (lectureOption == 1) {
                    return lecture.getLectureData();
                }
                if (lectureOption == 2) {
                    System.out.print("Classroom:");
                    String classroom = getStringFromInput();
                    lecture.setClassroom(classroom);
                    return "Classroom " + lecture.getClassroom()
                            + " asigned to class " + lecture.getName();
                }
                if (lectureOption == 3) {
                    System.out.println("Available teachers:");
                    System.out.println(getTeachersInfo());
                    System.out.print("Teacher to assign id:");
                    int teacherId = getIntFromInput();
                    System.out.println(" ");
                    Teacher teacher = getTeacherById(teacherId);
                    if (teacher != null) {
                        lecture.setTeacher(teacher);
                        return "Teacher " + lecture.getTeacher().getName()
                                + " assigned to class " + lecture.getName();
                    } else {
                        return "Teacher not found.";
                    }
                } else if (lectureOption != 4) {
                    lectureOption = 0;
                }
            }
        }
        return "";
    }

    public String studentsMenu() {
        System.out.println("------------------");
        int lectureOption = 0;
        while (lectureOption == 0) {
            System.out.println("Students options:");
            System.out.println("1. Get student classes by id.");
            System.out.println("2. Enroll student to a class.");
            System.out.println("2. Back");
            lectureOption = getIntFromInput();
            if (lectureOption == 1 || lectureOption == 2) {
                System.out.print("Enter student id:");
                int studentId = getIntFromInput();
                System.out.println(" ");
                Student student = getStudentById(studentId);
                if (student == null) {
                    return "Student not found.";
                }
                if (lectureOption == 1) return student.getLecturesInfo();
                if (lectureOption == 2) {
                    System.out.println("Classes available:");
                    System.out.println(this.getLecturesInfo());
                    System.out.print("Class id: ");
                    int lectureId = getIntFromInput();
                    Lecture lecture = getLectureById(lectureId);
                    if (lecture == null) {
                        return "Class not found";
                    }
                    lecture.enrollStudent(student);
                    return "student " + student.getName() + " enrolled to class " +
                            lecture.getName() + " successfully";
                }
            } else if (lectureOption != 4) {
                lectureOption = 0;
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

    public Student getLecturesByStudentId(int id) {
        try {
            return this.globalStudents.get(id);
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            return null;
        }
    }

    public List<Lecture> getGlobalLectures() {
        return globalLectures;
    }

    public List<Teacher> getGlobalTeachers() {
        return globalTeachers;
    }

    public List<Student> getGlobalStudents() {
        return globalStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
