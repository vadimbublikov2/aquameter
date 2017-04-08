package ru.bvd.aquametr;

public class Main {

    public static void main(String[] args) {
        String inputStr = "1 2 3 4 5 5 5 3 4 4 4 1 1 6 6 6 5 4 3 4 3 2 1";

        Aquarium aquarium = new Aquarium(inputStr);
        int volume = aquarium.calcVolume();
        System.out.println();
        System.out.println("Aquarium volume = " + volume);
    }
}