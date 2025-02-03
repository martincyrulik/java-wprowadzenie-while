/**
 * Sudoku 1-n (sudoku z jedną niewiadomą w wierszu i kolumnie)
 * Napisz program, który uzupełni brakujące liczby w sudoku.
 * 1 3
 *  12
 * 23
 *
 * wprowadź sudoku do programu (na stałe, oznaczenia wedle uznania)
 * program powinien wywnioskować których liczb brakuje, uzupełnić je i wyświetlić
 * uzupełnione sudoku na ekranie
 * 123
 * 312
 * 231
 */

public class Sudoku_1N {
    public static void main(String[] args) {

//        char[][] tablica = {
//                {'a','b','c'},
//                {'d','e','f'},
//                {'g','h','i'}
//        };
//        char tablicaZnakow[][] = {
//                {'A','B',' ','D'},
//                {'E',' ','G','H'},
//                {'I','J','K',' '}
//        };
//        //wyświetlenie tablicy :
//        int row = 0;    //inicjujemy pierwszy wiersz tablicy
//        while (row < tablica.length) {   //pierwsza pętla biegnie po wierszach
//            int col = 0;    //inicjujemy pierwszą kolumnę tablicy
//            while (col < tablica[row].length) {
//                System.out.print("[" + tablica[row][col] + "]");
//                col++;
//            }
//            row++;
//            System.out.println();
//        }
//        System.out.println();
//        //wyświetlenie drugiej tablicy znaków
//        row = 0;
//        while(row < tablicaZnakow.length) {
//            int col = 0;
//            while (col < tablicaZnakow[row].length) {
//                System.out.print("[" + tablicaZnakow[row][col] + "]");
//                col++;
//            }
//            row++;
//            System.out.println();
//        }
        char[][] sudoku = {
                {'1',' ','3'},
                {' ','1','2'},
                {'2','3',' '}
        };
        //wyświetlenie tablicy sudoku
        int row = 0;    //inicjalizacja 1-go wiersza tablicy
        while(row < sudoku.length) { //piersza pętla po wierszach
            int col = 0;    //inicjalizacja 1-ej kolumny tablicy
            while (col < sudoku[row].length) {  //a druga pętla po kolumnach
                System.out.print("[" + sudoku[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();
        }
        System.out.println();
        //uzupełnienie tablicy sudoku
        System.out.print("Uzupełniona tablica sudoku:");
        row = 0;    //inicjalizacja 1-go wiersza tablicy
        while(row < sudoku.length) {
            int col = 0;    //inicjalizacja 1-ej kolumny tablicy
            int[] temp = new int[3];    //inicjalizujemy tablicę temp 3-elementową
            int index = 0;  //index-> do przechowania miejsca w kyórym będzie puste miejsce ' '
            while (col < sudoku[row].length) {
                if (sudoku[row][col] == ' ') { //zagnieżdżone if do zamiany znaków na liczby int
                    index = col;    //znajdujemy kolumnę gdzie jest pusty znak ' '
                    temp[col] = 0;
                } else if (sudoku[row][col] == '1') {
                    temp[col] = 1;
                } else if (sudoku[row][col] == '2') {
                    temp[col] = 2;
                } else if (sudoku[row][col] == '3') {
                    temp[col] = 3;
                }
                col++;
            }
            int suma = temp[0] + temp[1] + temp[2]; //chcemy policzyć sumę aby obliczyć
            int difference = 6 - suma;              //jakiej cyfry nam brakuje
            if (difference == 1) {      //kolejne zagnieżdżone if do zamiany brakującej cyfry
                sudoku[row][index] = '1';   //na odpowiadający jej znak, przypisanie jest
            } else if (difference == 2) {   //do odpowiedniej kolumny, gdzie przedtem
                sudoku[row][index] = '2';   //był znak pusty ' '
            } else {
                sudoku[row][index] = '3';
            }
            row++;
            System.out.println();
        }

        //wyświetlenie tablicy sudoku
        row = 0;    //inicjalizacja 1-go wiersza tablicy
        while(row < sudoku.length) {
            int col = 0;    //inicjalizacja 1-ej kolumny tablicy
            while (col < sudoku[row].length) {
                System.out.print("[" + sudoku[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();
        }

        char[][] tablica = {
                {'1',' ','3'},
                {' ','1','2'},
                {'2','3',' '}
        };

        // ponowne wyświetlenie pierwotnej tablicy:
        System.out.println();
        System.out.println("Ponowne wyświetlenie pierwotnej tablicy:");
        row = 0;    //inicjalizacja 1 wiersza tablicy
        while(row < tablica.length) { //1 pętla zewnętrzna po wierszach
            int col = 0;    //inicjalizacja 1 kolumny w danym wierszu
            while(col < tablica[row].length) { //2 pętla wewnętrzna po kolumnach
                System.out.print("[" + tablica[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();   //po wyświetleniu kolejnego wiersza - nowa linia
        }


        /**
         * Idea programu polega na tym aby:
         * 1) wyświetlić pierwotną tablicę typu char
         * 2) dokonać zamiany tablicy z typu char na int
         * 3) uzupełnić brakujące elementy typu int
         * 4) dokonać zamiany tablicy int na typ char
         * 5) wyświetlić uzupełnioną już tablicę char
         * Uzupełnienie polega na fakcie, że w uzupełnionym wierszu suma elementów
         * wynosi 6, zatem różnica między 6 - (suma niepełnego wiersza) da nam
         * cyfrę, której nam brakuje. Zatem trzeba zrobić te obliczenia i oczywiście
         * zapamiętać daną kolumnę w której wystąpił pusty znak, aby umieścić w niej
         * właśnie tę brakującą cyfrę.
         */

        //zamiana pierwotnej tablicy typy char -> int
        int[][] tablica_int = new int[3][3];
        row = 0;
        while(row < tablica.length) {   //po wierszach
            int col = 0;
            while (col < tablica[row].length) {  //po kolumnach
                //zamiana typu char na int
                if (tablica[row][col] == ' ') {
                    tablica_int[row][col] = 0;
                } else if (tablica[row][col] == '1') {
                    tablica_int[row][col] = 1;
                } else if (tablica[row][col] == '2') {
                    tablica_int[row][col] = 2;
                } else {
                    tablica_int[row][col] = 3;
                }
                col++;
            }
            row++;
        }

        //wyświetlenie tablicy int
        System.out.println();
        System.out.println("Wyświetlenie tablicy int:");
        row = 0;    //inicjalizacja 1 wiersza tablicy
        while(row < tablica_int.length) { //1 pętla zewnętrzna po wierszach
            int col = 0;    //inicjalizacja 1 kolumny w danym wierszu
            while(col < tablica_int[row].length) { //2 pętla wewnętrzna po kolumnach
                System.out.print("[" + tablica_int[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();   //po wyświetleniu kolejnego wiersza - nowa linia
        }

        //uzupełnienie brakujących cyfr w tablicy int
        row = 0;
        while (row < tablica_int.length) {
            int col = 0;
            int suma = 0; //inicjalizacja sumy elementów danego wiersza
            int index = 0; //inicjalizacja kolumny w której szukamy elementu 0
            int difference = 0; //inicjalizacja różnicy 6 - (suma elementów danego wiersza)
            while (col < tablica_int[row].length) {
                //sumowanie elemntów tablicy i uzupełnie brakującej cyfry
                suma += tablica_int[row][col];
                if (tablica_int[row][col] == 0) {
                    index = col;    //zapamiętujemy kolumnę w której jest 0
                }
                col++;
            }
            difference = 6 - suma;
            tablica_int[row][index] = difference;
            row++;
        }

        //wyświetlenie uzupełnionej tablicy int
        System.out.println();
        System.out.println("Wyświetlenie uzupełnionej tablicy int:");
        row = 0;    //inicjalizacja 1 wiersza tablicy
        while(row < tablica_int.length) { //1 pętla zewnętrzna po wierszach
            int col = 0;    //inicjalizacja 1 kolumny w danym wierszu
            while(col < tablica_int[row].length) { //2 pętla wewnętrzna po kolumnach
                System.out.print("[" + tablica_int[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();   //po wyświetleniu kolejnego wiersza - nowa linia
        }

        //zamiana naszej tablicy int na char
        row = 0;
        while (row < tablica_int.length) {
            int col = 0;
            while (col < tablica_int[row].length) {
                //zamiana typu int na char
                if (tablica_int[row][col] == 0) {
                    tablica[row][col] = ' ';
                } else if (tablica_int[row][col] == 1) {
                    tablica[row][col] = '1';
                } else if (tablica_int[row][col] == 2) {
                    tablica[row][col] = '2';
                } else {
                    tablica[row][col] = '3';
                }
                col++;
            }
            row++;
        }

        //wyświetlenie naszej tablicy po zamianie typu int na char
        System.out.println();
        System.out.println("Wyświetlenie tablicy po zamianie typu int na char:");
        row = 0;    //inicjalizacja 1 wiersza tablicy
        while(row < tablica.length) { //1 pętla zewnętrzna po wierszach
            int col = 0;    //inicjalizacja 1 kolumny w danym wierszu
            while(col < tablica[row].length) { //2 pętla wewnętrzna po kolumnach
                System.out.print("[" + tablica[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();   //po wyświetleniu kolejnego wiersza - nowa linia
        }
    }
}