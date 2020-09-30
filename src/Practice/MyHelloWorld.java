package Practice;

class NewStudent {
    public String name;

    public NewStudent(String name) {
        this.name = name;
    }


    public static class Test {

    }
}

public class MyHelloWorld {
    public static void main(String[] args) {
        NewStudent s = new NewStudent("Tom");
        NewStudent t = new NewStudent("Jerry");
        changeStudent(s, t);
        System.out.println(s.name);
    }

    public static void changeStudent(NewStudent s, NewStudent t) {
        // NewStudent t = new NewStudent("Jerry");
        s = t;
        System.out.printf("Hi There, this student is %s \n", s.name);
        int[] array = new int[0];
        System.out.print(array);
    }
}


