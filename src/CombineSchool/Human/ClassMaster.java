package CombineSchool.Human;

import CombineSchool.organization.School;

public final class ClassMaster {
    private String cls;
    private Teacher teacher;

    public ClassMaster(School s, String cls) {
        teacher = new Teacher(s);
        this.cls = cls;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void recognize(Sombody s){
        teacher.getSombody().recognize(s);
    }
    public void recognize(Teacher s){
        teacher.getSombody().recognize(s);
    }
    public void recognize(Student s){
        teacher.getSombody().recognize(s);
    }
    public void recognize(ClassMaster s){
        teacher.getSombody().recognize(s);
    }
    public void recognize(School s){
        teacher.getSombody().recognize(s);
    }
}
