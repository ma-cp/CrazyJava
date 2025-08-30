package CombineSchool.organization;

import CombineSchool.Human.ClassMaster;
import CombineSchool.Human.Sombody;
import CombineSchool.Human.Student;
import CombineSchool.Human.Teacher;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String position;
    private List<Sombody> sombodies = new ArrayList<>();

    public School(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void appendSombody(Sombody s){
        if(!sombodies.contains(s)){
            sombodies.add(s);
        }
    }
    public void appendSombody(Student s){
        if(!sombodies.contains(s.getSombody())){
            sombodies.add(s.getSombody());
        }
    }
    public void appendSombody(Teacher t){
        if(!sombodies.contains(t.getSombody())){
            sombodies.add(t.getSombody());
        }
    }
    public void appendSombody(ClassMaster c){
        if(!sombodies.contains(c.getTeacher().getSombody())){
            sombodies.add(c.getTeacher().getSombody());
        }
    }

    public boolean isInSchool(Sombody s){
        return sombodies.contains(s);
    }

    public boolean isInSchool(Student s){
        return sombodies.contains(s.getSombody());
    }
    public boolean isInSchool(Teacher s){
        return sombodies.contains(s.getSombody());
    }
    public boolean isInSchool(ClassMaster s){
        return sombodies.contains(s.getTeacher().getSombody());
    }
}
