package AnotherSchool;

import AnotherSchool.Human.ClassMaster;
import AnotherSchool.Human.Sombody;
import AnotherSchool.Human.Student;
import AnotherSchool.Human.Teacher;
import AnotherSchool.organization.School;

/**
 * 此类为入口类，用于演示普通人、老师、班主任、学生、学校这五个对象的行为<br>
 *
 * 对于一个普通人(Somebody)来说，最基本的能力是认识(recognize)。最基本的属性是社会性。<br>
 * 为了体现一个人的社会性，一个人应该有判断自己社会关系的能力，此处用值“财富”来衡量人与人之间的关系。<br>
 * 为了体现一个人的认识能力，一个人应该有认识其他对象的能力。<br>
 *
 * 对于一个老师(Teacher)来说，应该继承自普通人，<br>
 * 独特的能力是教育(teach)，独特的属性是工作的学校。<br>
 *
 * 对于一个班主任(ClassMaster)来说，应该继承自老师，且不应被继承<br>
 * 独特的能力是管理学生的生活，独特的属性是一个对应的班级。<br>
 *
 * 对于一个学生来说，应该继承自普通人，<br>
 * 独特的能力是学习。没有特别独特的属性，只要是普通人都可以是学生<br>
 *
 * 对于一个学校来说，最基本的能力是作为一个单位，即判断一个人是否属于学校<br>
 * 最基本的属性是物理的校园。<br>
 */

public final class SchoolRunning {
    public static void main(String[] args) {
        Sombody zhangSan = new Sombody();
        School chaoYang = new School("朝阳区101号，凤凰小学");
        Teacher wang = new Teacher(chaoYang);
        Student xiaoMing = new Student();
        ClassMaster li = new ClassMaster(chaoYang, "三年二班");

        zhangSan.recognize(chaoYang);
        zhangSan.recognize(wang);
        zhangSan.recognize(xiaoMing);
        zhangSan.recognize(li);

        chaoYang.appendSombody(xiaoMing);
        System.out.println("zhangSan"+(chaoYang.isInSchool(zhangSan)?" in school":" not in school"));

        wang.teach(xiaoMing);
        li.recognize(xiaoMing);
    }
}
