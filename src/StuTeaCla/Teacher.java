package StuTeaCla;

import java.util.Objects;

/**
 * 一个 Teacher 对应一个“老师”<br>
 * 老师有 编号、姓名，性别，生日，科目 五个属性<br>
 * 每个老师都应该有且仅有一个编号<br>
 * 本类以编号“no”判断相等<br>
 */
public class Teacher {
    int No;
    String name;
    String gender;
    int birthday;
    String project;

    public Teacher(int no) {
        No = no;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return No == teacher.No;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(No);
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
