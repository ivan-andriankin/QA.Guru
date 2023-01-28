package homeworks.registrationpage.generatetestdata.utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {



    public static int randomInt(int min, int max) {
        return  ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String randomEmail() {
        return randomString(10) + "@qa.guru";
    }

    public static String randomItem(String[] values) {
        int index = randomInt(0, values.length - 1);
        return values[index];
    }

    public static String randomGender() {
        String[] genders = {"Male", "Female", "Other"};;
        int rnd = new Random().nextInt(genders.length);
        return genders[rnd];
    }

    public static String[] randomDate() {
        Faker faker = new Faker();
        String year = faker.number().numberBetween(1970, 2022) + "";

        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int monthsIndex = new Random().nextInt(months.length);

        String day = faker.number().numberBetween(1, 28) + "";

        String[] date = {day, months[monthsIndex], year};

        return date;
    }

    public static String randomMobileNumber() {
        Faker faker = new Faker();
        return faker.number().numberBetween(9100000000L, 9111111111L) + "";
    }

}
