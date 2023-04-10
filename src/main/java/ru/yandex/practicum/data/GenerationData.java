package ru.yandex.practicum.data;

import java.util.Random;

public class GenerationData {


    public static String getRandomStringEng(int length) {
        String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomStringRu(int length) {
        String SALTCHARS = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

}
