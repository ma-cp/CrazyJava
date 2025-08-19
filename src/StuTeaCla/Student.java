package StuTeaCla;

import java.util.Objects;

/**
 * 一个 Student 对应一个“学生”<br>
 * 学生有 编号、姓名，性别，生日 四个属性<br>
 * 每个学生都应该有且仅有一个编号<br>
 * 本类以编号“no”判断相等<br>
 */
public class Student {
    int No;
    String name;
    String gender;
    String birthday;

    public Student(int no) {
        No = no;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return No == student.No;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
