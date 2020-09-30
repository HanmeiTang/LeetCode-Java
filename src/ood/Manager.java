package ood;

public class Manager extends Employee implements EmailProcessor {
    static double bonusRate = 0.1;
    // 子类拥有父类非 private 的属性、方法
    private String name;
    private String id;

    private int age;
    protected int salary;
    protected int level;

    public Manager(String name, int age, String id, int level) {
        super(name, age, id, level);
        this.name = name;
        this.id = id;
        this.level = level;
    }

    // 子类可以拥有自己的属性和方法，即子类可以对父类进行扩展
    public void manager() {
        System.out.println("This is the manager's work.");
    }

    // 子类可以用自己的方式实现父类的方法
    // 对非抽象方法既可以直接继承，也可以覆盖
    public void printInfo() {
        System.out.println("Note, I am a manager.");
        super.printInfo();
    }

    // 只有那些冠有abstract的方法才是抽象的，子类必须实现
    // 而对抽象方法，可以选择实现，也可以通过再次声明其方法为抽象的方式
    // 无需实现，留给其子类来实现，但此类必须也声明为*抽象类*
    @Override
    public void setAge(int age) {
        this.age = age;
    }

    public Object iCanDoAnything(Object o) {
        return o;
    }

    @Override
    public void writeEmail() {
        System.out.println("Believe it or not, I am writing an email.");
    }

    @Override
    public String readEmail(String email) {
        System.out.println("Don't disturb at the moment. I am reading an email.");
        return email;
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Hanmei", 29, "1000", 5);
        manager.printInfo();
        System.out.println(manager.iCanDoAnything("I can do anything for you."));
        System.out.println(manager.xx);
    }
}
