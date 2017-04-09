package ru.bvd.aquameter;

import java.util.Arrays;
import java.util.Collections;

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
        int[] columns = Arrays.copyOf(columnsSize, columnsSize.length);

        if (columns.length==1)
            return 0;

        int volumeAquarium = 0;
        int closeIndex = 0;
        int openIndex;

        int lastOpenIndex;
        int lastCloseIndex;
        while (true) {
            openIndex = closeIndex;
            //очистка от одиночного максимума
            int[] columnsSort = Arrays.copyOf(columns, columns.length);
            Arrays.sort(columnsSort);
            if (columnsSort[columns.length-1] != columnsSort[columns.length-2] ) {
                columns[ Arrays.binarySearch( columns, columnsSort[columns.length-1] ) ] = columnsSort.length-2 ;
            }

            //ищем начало следующего вхождения подаквариума
            lastOpenIndex = openIndex;
            System.out.println();
            System.out.println(openIndex);
            for (int i = openIndex; i < columns.length; i++) {
                if (columns.length<(i+2))
                    break;
                if (columns[i] == 0)
                    continue;
                if (columns[i] > columns[i + 1]) {
                    openIndex = i;
                    break;
                }
            }

            //ищем конец вхождения подаквариума
            for (int k=openIndex+1;k<columns.length;k++) {
                closeIndex = openIndex + 1;
                lastCloseIndex = closeIndex;
                for (int i = closeIndex; i < columns.length; i++) {
                    if (columns[i]==0)
                        break;
                    if (columns[i] >= columns[openIndex]) {
                        closeIndex = i;
                        break;
                    }
                }
                if (lastCloseIndex==closeIndex) {
                    openIndex++;
                } else
                    break;
            }

            //выход, если начало следующего вхождение не найдено
            if ( (lastOpenIndex==openIndex) && (openIndex>0)  )
                break;

            System.out.println();
            System.out.println("columns open  index = " + openIndex + " val = " + columns[openIndex]);
            System.out.println("columns close index = " + closeIndex + " val = " + columns[closeIndex]);

            volumeAquarium += calcVolumeSubAquarium(Arrays.copyOfRange(columns, openIndex, closeIndex + 1));
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