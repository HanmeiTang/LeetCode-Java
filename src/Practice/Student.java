package Practice;

public class Student {
    String name;
    void setName(String name) {
        this.name = name; // mandatory if argument name is same to the name of the field
        // Which means if argument is different from the field's name, then it is possible
        // Though I think using 'this' is a good practice
        // I will always use it, though sometimes it is allowed to use
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Herry");
        System.out.println(s.name);
    }
}
