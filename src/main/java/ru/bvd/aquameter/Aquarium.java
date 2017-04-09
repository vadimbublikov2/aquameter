package ru.bvd.aquameter;

import java.util.Arrays;

class Aquarium {
    private int[] columnsSize;
    private final String errText = "Строка должна содержать не более 65535 целых неотрицательных чисел (от 0 до 65535).";

    Aquarium(String inputStr) {
        if ( inputStr.contains("-") || inputStr.contains(".") || inputStr.contains(",")  ) {
            throw new IllegalArgumentException(errText + " Получено отрицательное, либо дробное значение");
        }

        String[] inputStrArr = inputStr.split(" ");
        if (inputStrArr.length>65535 || inputStrArr.length==0)
            throw new IllegalArgumentException(errText + " Получено " + inputStrArr.length + " элементов.");
        columnsSize = new int[inputStrArr.length];
        for (int i = 0; i< columnsSize.length; i++) {
            columnsSize[i] = Integer.parseInt( inputStrArr[i] );
            if (columnsSize[i]>65535)
                throw new IllegalArgumentException(errText + "Элемент с индексом " + i + "содержит = " + columnsSize[i]);
//            System.out.print( columnsSize[i] + "[" + i + "] " );
        }
    }

    long calcVolume() {
        int[] columns = Arrays.copyOf(columnsSize, columnsSize.length);

        if (columns.length==1)
            return 0;

        long volumeAquarium = 0;
        int closeIndex = 0;
        int openIndex = 0;

        int lastOpenIndex;
        int lastCloseIndex;
        while (true) {
            lastOpenIndex = openIndex;
            openIndex = closeIndex;
            if (openIndex==(columns.length-1))
                break;

            //-->очистка от одиночного максимума
            int[] columnsSort = Arrays.copyOfRange(columns, openIndex, columns.length);
            Arrays.sort(columnsSort);
            if (columnsSort[columnsSort.length-1] != columnsSort[columnsSort.length-2] ) {
//                System.out.println();
//                System.out.println("single max = " + columnsSort[columnsSort.length-1]);
                for(int i=openIndex; i<columns.length; i++) {
                    if (columns[i]==columnsSort[columnsSort.length-1]) {
                        columns[i] = columnsSort[columnsSort.length - 2];
                        break;
                    }
                }
//                System.out.println("after clear max");
//                for (int i=0; i<columns.length;i++)
//                    System.out.print( columns[i] + "[" + i + "] " );
            }
            //<--

            //-->ищем начало следующего вхождения подаквариума
//            System.out.println();
//            System.out.println(openIndex);
            for (int i = openIndex; i < columns.length; i++) {
                if (columns.length<(i+2))
                    break;
                if (columns[i] == 0) //следующая итерация, если подаквариум прерывается
                    continue;
                if (columns[i] > columns[i + 1]) {
                    openIndex = i;
                    break;
                }
            }
            //<--

            //-->ищем конец вхождения подаквариума
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
            //<--

            //выход, если начало следующего вхождение не найдено
            if ( ((lastOpenIndex==openIndex) && (openIndex>0)) || (openIndex==closeIndex)  )
                break;

//            System.out.println();
//            System.out.println("columns open  index = " + openIndex + " val = " + columns[openIndex]);
//            System.out.println("columns close index = " + closeIndex + " val = " + columns[closeIndex]);

            volumeAquarium += calcVolumeSubAquarium(Arrays.copyOfRange(columns, openIndex, closeIndex + 1));
        }
        return volumeAquarium;
    }

    private long calcVolumeSubAquarium (int[] subAquarium) {
        long volumeSubAquarium = 0;
        int heightWater = Math.min(subAquarium[0], subAquarium[subAquarium.length-1]);
//        for (int i=0; i<subAquarium.length; i++)
//            System.out.print( subAquarium[i] + "["+i+"] " );
        for (int i=1 ; i<subAquarium.length-1; i++) {
            volumeSubAquarium += (heightWater - subAquarium[i]);
        }
//        System.out.println();
//        System.out.println("height water = " + heightWater);
//        System.out.println("volume sub aquarium = " + volumeSubAquarium);

        return volumeSubAquarium;
    }
}