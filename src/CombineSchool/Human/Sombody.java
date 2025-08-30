package CombineSchool.Human;

import CombineSchool.organization.School;

public class Sombody {
    private int value=60;

    public void recognize(Sombody s){
        System.out.println("This is "+s.toString()+", with "+s.value+"value,"+(s.value>value?"richer":"not richer")+" than me.");
    }
    public void recognize(Student stu){
        Sombody s=stu.getSombody();
        System.out.println("This is "+s.toString()+", with "+s.value+"value,"+(s.value>value?"richer":"not richer")+" than me.");
    }
    public void recognize(Teacher t){
        Sombody s=t.getSombody();
        System.out.println("This is "+s.toString()+", with "+s.value+"value,"+(s.value>value?"richer":"not richer")+" than me.");
    }
    public void recognize(ClassMaster c){
        Sombody s=c.getTeacher().getSombody();
        System.out.println("This is "+s.toString()+", with "+s.value+"value,"+(s.value>value?"richer":"not richer")+" than me.");
    }
    public void recognize(School s){
        System.out.println("This is "+s.toString()+", located in "+s.getPosition());
    }

    public int getValue() {
        return value;
    }

    public void setValue(Sombody s) {
        this.value +=1;
        s.dedication();
    }

    void dedication(){
        this.value -= 1;
    }

    void growth(int i){
        this.value +=i;
    }
}
