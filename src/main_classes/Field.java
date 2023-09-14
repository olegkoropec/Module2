package main_classes;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Field {
    private final int width;
    private final int length;
    private final String water = "\uD83C\uDF0A";
    private final String meadow = "\uD83D\uDFE9";

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Field(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length and width of field");
        Field field = new Field(scanner.nextInt(), scanner.nextInt());
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < field.getWidth(); i++) {
            for (int j = 0; j < field.getLength(); j++) {
                int randomPicture = random.nextInt(4);
                if (randomPicture == 0 || randomPicture == 1 || randomPicture == 2)
                    System.out.print(field.meadow);
                else System.out.print(field.water);
            }
            System.out.println();
        }
    }
}
