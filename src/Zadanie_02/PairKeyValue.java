package Java_zaawansowana_zadania_pdf.Kolekcje_zadania.Zadanie_02;

import java.util.*;

import static Java_zaawansowana_zadania_pdf.Kolekcje_zadania.Zadanie_02.BookService.bookList;

// zadanie_04
public class PairKeyValue {
//    Na podstawie zadania nr 2 zaimplementuj metodę, która będzie odpowiedzialna
//    za zwracanie unikalnych par: klucz, wartość. Kluczem powinien być gatunek
//    książki, a wartością jej tytuł.

    public Map<MovesType, String> paraKluczWartosc() {
        var mapa = new EnumMap<MovesType,String>(MovesType.class);
        for(Book book: bookList) {
            mapa.put(MovesType.COMEDY, book.getTitle());
            mapa.put(MovesType.DRAMA, book.title);
            mapa.put(MovesType.MUSICAL, book.title);
            mapa.put(MovesType.SF, book.title);

        }
        return mapa;

    }

    public static void main(String[] args) {
        PairKeyValue obj = new PairKeyValue();

        System.out.println(obj.paraKluczWartosc());
    }
}

