/**
 * Dla podanej nieparzystej liczby n, przy pomocy pętli while wyświetl:
 * dla n = 5                        dla n = 7
 *     *                                *
 *    ***                              ***
 *   *****                            *****
 *                                   *******
 * Aby wyświetlić choinkę z gwiazdek, najpierw trzeba określić
 * ile w niej będzie wierszy w zależności od liczby n:
 * numberOfRaws = (n / 2) + 1, (n / 2) -> chodzi nam o dzielenie całkowite, nie zmiennoprzecinkowe
 * dla n = 5, numberOfRaws = 3,
 * dla n = 7, numberOfRaws = 4
 * Liczba spacji w kolejnym wierszu (raw) wynosi : numberOfSpaces = numberOfRaws - raw,
 * natomiast liczna gwiazdek w kolejnym wierszu stars -> (raw * 2) - 1,
 * Zatem mamy ostatecznie trzy pętle while:
 * 1) To pętla, która biegnie po kolejnych wierszach -> raw, inkrementuje co 1
 * w każdej iteracji, po każdym obiegu wypisuje znak końca linii na ekranie
 * 2) To pętla, która wyświetla spacje w zależności od kolejnego wiersza (raw)
 * numberOfSpaces = numberOfRaws - raw, inkrementuje o 1
 * 3) To pętla, która wyświetla gwiazdki w kolejnych wierszach:
 * stars = (raw * 2) - 1, inkrementuje o 1
 * Warto zauważyć że obudwie te pętle, tzn. 2 i 3 nie są w sobie zagnieżdżone,
 * natomiast są zagnieżdżone w pętli pierwszej.
 */

public class TreeOfStars {
    public static void main(String[] args) {

        int n = 7;  //liczba gwiazdek choinki

        int numberOfRaws = (n /2) + 1;  //liczba wierszy "choinki"
        int raw = 1;    //zainicjowanie pierwszego wiersza "choinki"
        while (raw <= numberOfRaws) {
            int numberOfSpaces = numberOfRaws - raw; //zainicjowanie liczby spacji
            while(numberOfSpaces > 0) {
                System.out.print(" ");
                numberOfSpaces--;
            }
            int stars = 1;  //zainicjowanie liczby gwiazdek
            while (stars <= (raw * 2) - 1) {
                System.out.print("*");
                stars++;
            }
            raw++;
            System.out.println();
        }
    }
}
