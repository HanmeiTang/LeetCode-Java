package ood;

public class Developer extends Employee implements EmailProcessor {
    private int age;
    private String name;
    private String id;
    private int level;


    // 调用父类中带有参数的构造器 (Parameterized constructor)
    public Developer(String name, int age, String id, int level) {
        super(name, age, id, level);
        this.name = name;
        this.id = id;
        this.level = level;
    }

    // 自动调用父类的无参数构造器 (no-argument constructor)
    public Developer() {
    }

    public String getName(){
        return name;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void writeEmail() {
        System.out.println("I am an email expert.");
    }

    @Override
    public String readEmail(String email) {
        System.out.println("I am an excellent email reader!");
        return email;
    }

    public void coding() {
        System.out.println("I am a coding expert!");
    }

    public static void main(String[] args) {
        Developer haha = new Developer();
        // haha.coding(); // Illegal
        System.out.println(haha.salary);
        System.out.println(haha.getName());
    }
}
