package utils;

import java.util.Random;

import com.github.javafaker.Faker;

public class DataGeneration {

    static String charsMay = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String charsMin = "abcdefghijklmnopqrstuvwxyz";
    static String nums = "1234567890";
    static String symbols = "~!@#$%^&*()";

    public static Faker faker = new Faker();
    
    public static String fullName() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String oneName() {
        return faker.name().firstName();
    }

    public static String correctEmail() {
        return faker.internet().emailAddress();
    }

    public static String incorrectEmail(String removed) {
        String mail = faker.internet().emailAddress();
        mail.replace(removed, "");
        return mail;
    }

    public static String correctPassword() {
        StringBuilder pass = new StringBuilder();
        pass.append(randomizer(5, charsMay));
        pass.append(randomizer(2, charsMin));
        pass.append(randomizer(2, nums));
        pass.append(randomizer(1, symbols));
        return pass.toString();
    }

    public static String incorrectPassword(String removed) {
        StringBuilder pass = new StringBuilder();
        pass.append(randomizer(5, charsMay));
        pass.append(randomizer(2, charsMin));
        pass.append(randomizer(2, nums));
        pass.append(randomizer(1, symbols));
        String passString = pass.toString();
        switch(removed) {
            case "mayusculas":
                passString = passString.replaceAll("[A-Z]", "a");
                break;
            case "minusculas":
                passString = passString.replaceAll("[a-z]", "1");
                break;
            case "numeros":
                passString = passString.replaceAll("[0-9]", "A");
                break;
            case "simbolos":
                passString = passString.substring(0, 9);
                break;
            default:
                passString = passString.substring(3, 10);
                break;
        }
        return passString;
    }

    private static String randomizer(int length, String values) {
        StringBuilder seq = new StringBuilder();
        Random random = new Random();
        while (seq.length() < length) {
            int index = (int) (random.nextFloat() * values.length());
            seq.append(values.charAt(index));
        }
        return seq.toString();
    }

}
