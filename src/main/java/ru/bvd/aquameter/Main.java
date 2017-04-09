package ru.bvd.aquameter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inputStr;
        if (args.length==0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите строку высот столбцов бетона: ");
            inputStr = scan.nextLine();
            scan.close();
        } else {
            inputStr = args[0];
        }
        System.out.println(inputStr);


        Aquarium aquarium = new Aquarium(inputStr);
        long volume = aquarium.calcVolume();
        System.out.println();
        System.out.println("Aquarium volume = " + volume);
    }
}