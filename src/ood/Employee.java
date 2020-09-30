package ood;

/**
 * Abstract class vs. Interface
 * 1. An abstract class is good if you think you will plan on using inheritance
 *    since it provides a common base class implementation
 */


// abstract class
public abstract class Employee {
    static double bonusRate = 0.1;

    private String name;
    private String id;

    private int age;
    public int salary;
    protected int level;

    protected Employee(String name, int age, String id, int level) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.level = level;
    }

    public Employee() {
    }


    void printInfo() {
        System.out.println("Name: " + name + "; Age: " + age + "; ID: " + id);
    }

    abstract void setAge(int age);


    public int calculateSalary(double performanceScore) {
        // calculate salary based on the employee's level and performance score
        return 0;
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Hanmei", 29, "1000", 5);
        manager.printInfo();
        System.out.println(manager.iCanDoAnything("I can do anything for you."));
    }


}
