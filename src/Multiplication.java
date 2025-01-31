/**
 * Dla podanego n, wyświetl tabliczkę mnożenia n x n
 * W programie będzie wykorzystane użycie zagnieżdżonych
 * pętli while.
 */

public class Multiplication {
    public static void main(String[] args) {

        int n = 10;  //ustalenie wielkości tabliczki mnożenia
        int[][] multi = new int[n][n];  //deklaracja tabliczki 2-D n x n

        //wyświetlenie tablicy
        System.out.println("-----------wyświetlenie--------------");
        int i = 0;  //deklaracja i -> wskaźnika wierszy tablicy
        while (i < multi.length) {   //iterujemy po kolejnych wierszach tablicy
            int j = 0;  //deklaracja j -> wskaźnika po kolejnych kolumnach tablicy
            while (j < multi[i].length) {   //iterujemy po kolejnych kolumnach tablicy
                System.out.print(multi[i][j]+ "\t");
                j++;
            }
            i++;
            System.out.println();   //po zakończeniu kolejnego wiersza robimy odstęp
        }
        System.out.println();

        // 1 2 3
        // 2 4 6
        i = 0;
        while(i < multi.length ) {
            int j = 0;
            while (j < multi[i].length) {
                multi[i][j] = (i+1)*(j+1);
                j++;
            }
            i++;
        }

        //ponowne wyświetlenie tablicy
        System.out.println("-----------wyświetlenie--------------");
        i = 0;  //deklaracja i -> wskaźnika wierszy tablicy
        while (i < multi.length) {   //iterujemy po kolejnych wierszach tablicy
            int j = 0;  //deklaracja j -> wskaźnika po kolejnych kolumnach tablicy
            while (j < multi[i].length) {   //iterujemy po kolejnych kolumnach tablicy
                System.out.print(multi[i][j]+ "\t");
                j++;
            }
            i++;
            System.out.println();   //po zakończeniu kolejnego wiersza robimy odstęp
        }
    }
}
