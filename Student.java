import java.util.ArrayList;

public class Student{

    private int id;
    private String name;
    private String gender;
    private String skill;
    private String course;

    public static ArrayList<Student> studentList = new ArrayList();

    public Student(int id, String name, String gender, String skill, String course){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.skill = skill;
        this.course = course;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getGender(){
        return this.gender;
    }

    public String getSkill(){
        return this.skill;
    }

    public String getCourse(){
        return this.course;
    }

    public static boolean addStudent(Student student){
        for(Student s : studentList){
            if(s.getId() == student.getId()){
                return false;
            }
        }
        studentList.add(student);
        return true;
    }

    public static void viewStudents(){
        for(Student s : studentList){
            System.out.println(
                s.getId() + " "
                + s.getName() + " "
                + s.getGender() + " "
                + s.getCourse() + " "
                + s.getSkill());
        }
    }

    public static boolean deleteStudent(int id){
        for(Student s: studentList){
            if(s.getId() == id){
                studentList.remove(s);
                return true;
            }
        }
        return false;
    }
}