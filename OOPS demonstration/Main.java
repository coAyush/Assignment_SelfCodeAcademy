public class Main{
    public static void main(String[] args) {
        Student ayush=new Student(1,
                85.5f,"Ayush");
        Student s=new Student();
        ayush.display();
        s.display();
    }
}
class Student{
    private int roll;
    private float marks;
    private String name;
    public Student(int roll, float marks, String name) {
        this.roll = roll;
        this.marks=marks;
        this.name=name;
    }
    public Student(){

    }
    public void display(){
        System.out.println("Roll no."+roll);
        System.out.println("Marks."+marks);
        System.out.println("Name."+name);
    }
}