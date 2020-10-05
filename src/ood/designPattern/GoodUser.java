package ood.designPattern;

// 1. The constructor of GoodUser class is private, therefore it only has class visibility
// 2. The User

public class GoodUser {
    // Carry all values that you want to pass to User/GoodUser
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String address;

    // this Builder can be located outside of the class
    // use it as a nested class
    // to highlight that the GoodUserBuilder is specifically for
    // the construction of a GoodUser class
    public static class GoodUserBuilder {
        // Carry all values that you want to pass to User/GoodUser
        private String firstName;
        private String lastName;
        private int age;
        private String phone;
        private String address;

        public GoodUserBuilder() {}
        public GoodUserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public GoodUserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public GoodUserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public GoodUserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public GoodUserBuilder address(String address) {
            this.address = address;
            return this;
        }


        public GoodUser build() {
            if (firstName == null || lastName == null) {
                throw new IllegalArgumentException("required fields are not set!");
            }
            return new GoodUser(this);
        }
    }

    // if GoodUserBuilder is outside of the GoodUser class
    // you may consider changing 'private' to 'protected'
    private GoodUser(GoodUserBuilder gb) {
        this.firstName = gb.firstName;
        this.lastName = gb.lastName;
        this.age = gb.age;
        this.phone = gb.phone;
        this.address = gb.address;
    }

    public static void main(String[] args) {
        // A good design pattern
        GoodUser user = new GoodUserBuilder()
                .lastName("Tang")
                .firstName("Hanmei")
                .phone("8884454455")
                .age(1000)
                .build();


        System.out.println(user.address);
    }
}
