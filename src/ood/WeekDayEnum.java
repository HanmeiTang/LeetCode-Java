package ood;

import java.util.Random;

enum RainbowColor {
    RED, ORANGE, YELLOW, GREEN, CYAN, BLUE, PURPLE
}

public enum WeekDayEnum {
    Mon, Tue, Wed, Thu, Fri, Sat, Sun
}

class test {
    public static void main(String[] args) {
        Random rand = new Random();
        int day = rand.nextInt(7);
        WeekDayEnum today = WeekDayEnum.values()[day];

        switch (today) {
            case Mon:
                System.out.println(today + ", OMG...");
                break;
            case Tue:
                System.out.println(today + ", Sign...");
                break;
            case Wed:
                System.out.println(today + ", Keep going!");
                break;
            case Thu:
                System.out.println(today + ", Almost there");
                break;
            case Fri:
                System.out.println(today + ", Done!!");
                break;
            case Sat:
                System.out.println(today + ", Weekend!");
                break;
            case Sun:
                System.out.println(today + ", Have a good weekend!");
                break;
        }

        // static values(); // get all values
        for (WeekDayEnum w : WeekDayEnum.values()) {
            System.out.print(w + " - ");

            // ordinal() // get index of a value
            System.out.println(w.ordinal());
        }

        // static valueOf()
        System.out.println(WeekDayEnum.valueOf("Sun"));
    }
}
