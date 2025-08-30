package AnotherSchool.Human;

import AnotherSchool.organization.School;

/**
 * 对于一个普通人来说，最基本的能力是认识。最基本的属性是社会性。<br>
 * 为了体现一个人的社会性，一个人应该有判断自己社会关系的能力，此处用值“财富”来衡量人与人之间的关系。<br>
 * 为了体现一个人的认识能力，一个人应该有认识其他对象的能力。<br>
 */
public class Sombody {
    private int value=60;

    public void recognize(Sombody s){
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
