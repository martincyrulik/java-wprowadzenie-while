/**
 * Dla podanej liczby n, przy pomocy pętli while,
 * wyświetl trójkąt złożony z gwiazdek, jak niżej:
 * dla n = 4        dla n = 6
 * *                *
 * **               **
 * ***              ***
 * ****             ****
 *                  *****
 *                  ******
 */

public class TriangleOfStars {
    public static void main(String[] args) {

        int n = 6;  //wysokość trójkąta

        int i = 1;  //licznik iteracyjny po kolejnych wierszach 1 -> n
        while(i <= n) {
            int j = 1;  //licznik iteracji do wyświetlania gwiazdek w kolejnych wierszach
            while (j <= i) {
                System.out.print("*");
                j++;    //inkrementacja licznika pętli zagnieżdżonej
            }
            i++;    //inkrementacja licznika pętli
            System.out.println();
        }
    }
}
