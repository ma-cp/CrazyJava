package AnotherSchool.Human;

import AnotherSchool.organization.School;

/**
 * 对于一个班主任来说，应该继承自老师，且不应被继承<br>
 * 班主任不设置独特的能力，独特的属性是一个对应的班级。<br>
 */
public final class ClassMaster extends Teacher{
    private String cls;

    public ClassMaster(School s, String cls) {
        super(s);
        this.cls = cls;
    }
}
