package CombineSchool.Human;

import CombineSchool.organization.School;

public class Teacher{
    private School school;
    private Sombody sombody = new Sombody();

    public Teacher(School s) {
        this.school = s;
        s.appendSombody(this);
    }

    public Sombody getSombody() {
        return sombody;
    }

    public void setSombody(Sombody sombody) {
        this.sombody = sombody;
    }

    public void teach(Student s){
        s.getSombody().setValue(this.sombody);
       sombody.growth(2);
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
