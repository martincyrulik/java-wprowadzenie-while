/**
 * Napisz program, który uzupełni brakujące liczby w sudoku.
 * [2][ ][ ]
 * [ ][1][2]
 * [1][2][ ]
 * wprowadź sudoku do programu
 * program powinien wywnioskować których liczb brakuje, uzupełnić je i wyświetlić
 * uzupełnione sudoku na ekranie.
 */

public class Sudoku_2N {
    public static void main(String[] args) {

        char[][] sudoku = {
                {'2',' ',' '},
                {' ','1','2'},
                {'1','2',' '}
        };

        //wyświetlenie tablicy sudoku
        int row = 0;    //inicjalizacja pierwszego wiersza tablicy
        while (row < sudoku.length) {   //1 pętla po wierszach
            int col = 0;    //inicjalizacja pierwszej kolumny
            while (col < sudoku[row].length) {  //2 pętla biegnie po kolumnach
                System.out.print("[" + sudoku[row][col] + "]");
                col++;
            }
            System.out.println();   //po każdym wierszu przeskok do nowej linii
            row++;
        }
        System.out.println();

        /**
         * Idea jest taka, żeby dokonać dwukrotnego przebiegu po tablicy.
         * Pierwszy przebieg wykonujemy wiersz po wierszu,
         * a drugi przebieg -  kolumna po kolumnie. Uzupełniamy brakujące miejsca w tablicy
         * tylko wtedy gdy w danym wierszu lub kolumnie pusty znak wystąpi tylko jednokrotnie.
         * Takie uzupełnianie ma sens, a dzięki temu, że dokunujemy przebiegu po tablicy -
         * raz po wierszach, a drugi raz po kolumnach - mamy pewność, że cała tablica zostanie uzupełniona
         *
         * -------------------Przebieg po wierszach-----------------------------
         * najpierw przebiegniemy po tablicy używając dwóch pętli
         * 1 pętla zewnętzna będzie biec po wierszach,
         * a 2 pętla wewnętzna po kolumnach
         * Idea jest taka, aby każdy wiersz sprawdzić pod kątem
         * ilości występujących pustych znaków. Posłuży do tego zmienna -> licznik.
         * Nie będziemy dokonywać żadnych zmian w tablicy gdy pusty znak wystąpi 2x.
         * Uzupełnianie ma sens tylko wtedy, gdy wystąpi w danym wierszu tylko jeden pusty znak.
         * Wtedy zapamiętujemy miejsce jego wystąpowania w danej kolumnie - zmienna -> index.
         * W pełnym wierszu występują elementy: 1,2,3. Ich suma wynosi 6.
         * W wierszu w którym brakuje jednego elementu - sumujemy dwa pozostałe - zmienna -> suma
         * Następnie obliczamy różnicę: 6 - suma, i umieścimy w zmiennej difference.
         * Mając do dyspozycji index w którym wystąpił pusty znak - wprowadzamy do
         * tablicy : sudoku[row][index] = difference i tak uzupełniamy tablicę wiersz po wierszu.
         *
         * ---------------------przebieg po kolumnach---------------------------
         * Tutaj będzie na odwrót - tzn.:
         * 1 pętla zewnętrzna będzie biec po kolumnach,
         * a 2 pętla wewnętrzna po wierszach.
         * Cała idea uzupełniana w tym przypadku jest podobna do tej jak opisano powyżej.
         * Kwestia tylko zamiany kolejności wierszy i kolumn.
         *
         */

        row = 0;    //inicjalizacja indeksu 1 wiersza tablicy sudoku
        while (row < sudoku.length) {   //pętla zewnętrzna biegnie "po wierszach"
            int col = 0;    //inicjalizacja indeksu 1 kolumny tablicy sudoku
            int licznik = 0;    //licznik występowania pustych znaków
            int index = 0;  //do przechowania miejsca pustego znaku
            int suma = 0;   //suma elementów tablicy w danym wierszu
            int temp = 0;   //zmienna tymczasowa do przechowywania kolejnych elementów
            int difference = 0; //zmienna -> 6 - suma
            while (col < sudoku[row].length) {
                switch (sudoku[row][col]) {
                    case ' ':
                        licznik++;
                        index = col;
                        break;
                    case '1':
                        temp = 1;
                        suma += temp;
                        break;
                    case '2':
                        temp = 2;
                        suma += temp;
                        break;
                    case '3':
                        temp = 3;
                        suma += temp;
                        break;
                }
                col++;
            }
            if (licznik == 1) {
                difference = 6 - suma;
                if (difference == 1) {
                    sudoku[row][index] = '1';
                } else if (difference == 2) {
                    sudoku[row][index] = '2';
                } else if (difference == 3) {
                    sudoku[row][index] = '3';
                }
            }
            row++;
        }

        //wyświetlenie tablicy sudoku po przebiegu po wierszach
        row = 0;    //inicjalizacja pierwszego wiersza tablicy
        while (row < sudoku.length) {   //1 pętla po wierszach
            int col = 0;    //inicjalizacja pierwszej kolumny
            while (col < sudoku[row].length) {  //2 pętla biegnie po kolumnach
                System.out.print("[" + sudoku[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();   //po każdym wierszu przeskok do nowej linii
        }
        System.out.println();

        //A teraz przebieg po kolumnach
        int numberOfColumns = sudoku[0].length;
        int col = 0;    //startujemy od 1 kolumny
        while (col < numberOfColumns) {
            int licznik = 0;    //licznik występowania pustych znaków
            int index = 0;  //do przechowania miejsca pustego znaku
            int suma = 0;   //suma elementów tablicy w danym wierszu
            int temp = 0;   //zmienna tymczasowa do przechowywania kolejnych elementów
            int difference = 0; //zmienna -> 6 - suma
            int numberOfRows = sudoku.length;   //liczba wierszy tablicy sudoku
            row = 0;
            while (row < numberOfRows) {
                switch (sudoku[row][col]) {
                    case ' ':
                        licznik++;
                        index = row;    //zapamiętujemy w którym wierszu występuje pusty znak
                        break;
                    case '1':
                        temp = 1;
                        suma += temp;
                        break;
                    case '2':
                        temp = 2;
                        suma += temp;
                        break;
                    case '3':
                        temp = 3;
                        suma += temp;
                        break;
                }
                row++;
            }
            if (licznik == 1) {
                difference = 6 - suma;
            }
            if (difference == 1) {
                sudoku[index][col] = '1';
            } else if (difference == 2) {
                sudoku[index][col] = '2';
            } else if (difference == 3) {
                sudoku[index][col] = '3';
            }
            col++;
        }

        //wyświetlenie tablicy sudoku
        System.out.println("Uzupełniona tablica, po przebiegu po lolumnach");
        row = 0;    //inicjalizacja pierwszego wiersza tablicy
        while (row < sudoku.length) {   //1 pętla po wierszach
            col = 0;    //inicjalizacja pierwszej kolumny
            while (col < sudoku[row].length) {  //2 pętla biegnie po kolumnach
                System.out.print("[" + sudoku[row][col] + "]");
                col++;
            }
            row++;
            System.out.println();   //po każdym wierszu przeskok do nowej linii
        }
        System.out.println();
    }
}
