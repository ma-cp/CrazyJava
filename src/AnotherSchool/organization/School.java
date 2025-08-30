package AnotherSchool.organization;

import AnotherSchool.Human.Sombody;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于一个学校来说，最基本的能力是作为一个单位，即判断一个人是否属于学校<br>
 * 最基本的属性是物理的校园。<br>
 */
public class School {
    private String position;
    private List<Sombody> sombodies = new ArrayList<>();

    public School(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void appendSombody(Sombody s){
        if(!sombodies.contains(s)){
            sombodies.add(s);
        }
    }

    public boolean isInSchool(Sombody s){
        return sombodies.contains(s);
    }
}
