/**
 * Napisz program, który spośród liczb z zakresu od 427 - 529, wypisz te, które są
 * podzielne przez 3, przez 5, oraz podzielne zarówno przez 3 jak i przez 5
 *
 * Założenie:
 *
 * przedział liczbowy 427 - 529
 * gdy program odnajdzie liczbę podzielną przez 3 wypisz "Tik",
 * gdy program odnajdzie liczbę podzielną przez 5 wypisz "Tak",
 * gdy program odnajdzie liczbę podzielną zarówno przez 3 i 5 wypisz "TikTak"
 */

public class LiczbyPodzielne {
    public static void main(String[] args) {

        int i = 427;    //deklaracja i inicjalizacja zmiennej licznika pętli while
        while(i <= 529) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println(i + " - TikTak");
            } else if (i % 3 == 0) {
                System.out.println(i + " - Tik");
            } else if (i % 5 == 0) {
                System.out.println(i + " - Tak");
            } else {
                //nie jest podzielne ani przez 3, ani przez 5,
                //więc nie wypisuj niczego na ekran
            }
            i++;    //inkrementacja licznika pętli
        }
    }
}
