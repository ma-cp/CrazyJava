package AnotherSchool.Human;

import AnotherSchool.organization.School;
/**
 * 对于一个老师来说，应该继承自普通人，<br>
 * 独特的能力是教育，独特的属性是工作的学校。<br>
 */
public class Teacher extends Sombody{
    private School school;

    public Teacher(School s) {
        this.school = s;
        s.appendSombody(this);
    }

    public void teach(Student s){
        s.setValue(this);
        super.growth(2);
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
