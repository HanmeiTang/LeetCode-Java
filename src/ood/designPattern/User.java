package ood.designPattern;


public class User {
    private final String firstName;
    private final String lastName;
    private int age;
    private String phone;
    private String address;

    public User(String firstName, String lastName) {
        this(firstName, lastName, 0);
    }

    public User(String firstName, String lastName, int age) {
        this(firstName, lastName, age, "");
    }

    public User(String firstName, String lastName, int age, String phone) {
        this(firstName, lastName, age, phone, "");
    }

    public User(String firstName, String lastName, int age, String phone, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    // 2^8 combinations.... OMG

    public static void main(String[] args) {
        User user = new User("Hanmei", "Tang");

        // One solution is to use setter & getter
        // Some Problems:
        // 1. you cannot determine when the construction is completed
        // 2. what if we do not want to expose setters for some data fields?
    }


}

