import java.util.ArrayList;

public class StudentMain{
    
    private String name, gender, course;
    private ArrayList<String> hobbies;
    
    public StudentMain(String name, String gender, String course, ArrayList<String> hobbies){
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.hobbies = new ArrayList<>(hobbies); 
    }
    
    @Override
    public String toString(){
        return "Name: " + name +
               "\nGender: " + gender +
               "\nCourse: " + course +
               "\nHobbies: " + hobbies;
    }
}