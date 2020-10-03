package ood.nestedClass;

public class staticClassRecap {

}

class LaiOfferManager {
    String name;
    String homeAddress;
    static String officeAddress;

    LaiOfferManager(String name) {
        this.name = name;
    }

    public static void moveOffice() {
        officeAddress = "San Jose, CA";
        // This is illegal because name is non-static
        // cannot shown here
        // name = "A";
    }


}
