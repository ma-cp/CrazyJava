package StuTeaCla;

import java.util.Objects;

/**
 * 一个 Classroom 对应一个“教室”<br>
 * 教室有编号、班主任、学生数量三个属性<br>
 * 每个教室都应该有且仅有一个编号<br>
 * 本类以编号“no”判断相等<br>
 */
public class Classroom {
    int no;
    Teacher master;
    int stu_amt;

    /**
     * @param no 只需要一个编号就能声明一个教室
     */
    public Classroom(int no) {

        this.no = no;
    }

    /**
     * @param o   the reference object with which to compare.
     * @return 返回一个布尔值
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return no == classroom.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Teacher getMaster() {
        return master;
    }

    public void setMaster(Teacher master) {
        this.master = master;
    }

    public int getStu_amt() {
        return stu_amt;
    }

    public void setStu_amt(int stu_amt) {
        this.stu_amt = stu_amt;
    }

}
