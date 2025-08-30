package CombineSchool.Human;

public class Student{
    private Sombody sombody = new Sombody();
    public void learn(Sombody s) {
        sombody.growth(1);
        s.growth(1);
    }

    public Sombody getSombody() {
        return sombody;
    }

    public void setSombody(Sombody sombody) {
        this.sombody = sombody;
    }
}