import java.util.*;

public class Main{
    public static void main(String[] args){

        ArrayList<Person> persons = new ArrayList<>();        

        //Upcasting
        Person p1 = new RealStudent("Sai", 18, "Computing");
        Person p2 = new Teacher("Vector", 29, "Information Systems");

        p1.showBasicInfo();
        p2.showBasicInfo();

        //Specific methods

        if(p1 instanceof RealStudent){
            RealStudent s1 = (RealStudent) p1;
            s1.attendClass();
            persons.add(s1);
        }

        if(p2 instanceof Teacher){
            Teacher t1 = (Teacher) p2;
            t1.takeLecture();
            persons.add(t1);
        }

        for(Person p: persons){
            if(p instanceof Teacher t){
                t.showBasicInfo();
            }

            if(p instanceof RealStudent s){
                s.showBasicInfo();
            }
        }

    }
}