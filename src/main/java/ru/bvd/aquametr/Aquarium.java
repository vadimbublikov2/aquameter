package ru.bvd.aquametr;

import java.util.Arrays;

class Aquarium {
    private int[] columnsSize;

    Aquarium(String inputStr) {


        String[] inputStrArr = inputStr.split(" ");
        columnsSize = new int[inputStrArr.length];
        for (int i = 0; i< columnsSize.length; i++) {
            columnsSize[i] = Integer.parseInt( inputStrArr[i] );
            System.out.print( columnsSize[i] + "[" + i + "] " );
        }
    }
    //проверка длины больше 1 что-то с нулями делать
    int calcVolume() {
        int volumeAquarium = 0;
        int closeIndex = 0;
        int openIndex;

        int lastOpenIndex;
        int lastCloseIndex;
        while (true) {
            openIndex = closeIndex;
            lastOpenIndex = openIndex;
            System.out.println();
            System.out.println(openIndex);
            for (int i = openIndex; i < columnsSize.length; i++) {
                if (columnsSize[i] == 0)
                    continue;
                if (columnsSize[i] > columnsSize[i + 1]) {
                    openIndex = i;
                    break;
                }
            }
            if (lastOpenIndex==openIndex)
                break;

            for (int k=openIndex+1;k<columnsSize.length;k++) {
                closeIndex = openIndex + 1;
                lastCloseIndex = closeIndex;
                for (int i = closeIndex; i < columnsSize.length; i++) {
                    if (columnsSize[i] >= columnsSize[openIndex]) {
                        closeIndex = i;
                        break;
                    }
                }
                if (lastCloseIndex==closeIndex) {
                    openIndex++;
                } else
                    break;
            }
            System.out.println();
            System.out.println("columnSize open  index = " + openIndex + " val = " + columnsSize[openIndex]);
            System.out.println("columnSize close index = " + closeIndex + " val = " + columnsSize[closeIndex]);

            volumeAquarium += calcVolumeSubAquarium(Arrays.copyOfRange(columnsSize, openIndex, closeIndex + 1));
        }
        return volumeAquarium;
    }

    private int calcVolumeSubAquarium (int[] subAquarium) {
        int volumeSubAquarium = 0;
        int heightWater = Math.min(subAquarium[0], subAquarium[subAquarium.length-1]);
        for (int i=0; i<subAquarium.length; i++)
            System.out.print( subAquarium[i] + "["+i+"] " );
        for (int i=1 ; i<subAquarium.length-1; i++) {
            volumeSubAquarium += (heightWater - subAquarium[i]);
        }
        System.out.println();
        System.out.println("height water = " + heightWater);
        System.out.println("volume sub aquarium = " + volumeSubAquarium);

        return volumeSubAquarium;
    }
}