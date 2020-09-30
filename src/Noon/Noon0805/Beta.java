package Noon.Noon0805;


class Alpha {
    public String type = "a ";

    public Alpha() {
        System.out.print("alpha ");
    }

    public void go() {
        System.out.println("Never go.");
    }
}

public class Beta extends Alpha {
    public Beta() {
        System.out.print("beta ");
    }

    public String type = "b ";

    public void go() {

//        System.out.print(super.getClass().getName());
//        System.out.print(this.getClass().getName());
        System.out.print(this.type + super.type);


    }

    public static void main(String[] args) {
        new Beta().go();
    }
}
