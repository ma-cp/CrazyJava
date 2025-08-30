package CombineSchool;

import CombineSchool.Human.ClassMaster;
import CombineSchool.Human.Sombody;
import CombineSchool.Human.Student;
import CombineSchool.Human.Teacher;
import CombineSchool.organization.School;

/**
 * 此类为使用组合来模拟继承的情况<br>
 * 通过对于组合的使用可以感受到组合是有多么的原始而继承是有多么的方便<br>
 * 尤其是这是个强类型的语言的时候<br>
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
