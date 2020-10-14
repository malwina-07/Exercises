package Java_zaawansowana_zadania_pdf.Kolekcje_zadania.Zadanie_02;


import java.util.*;
import java.util.stream.Collectors;

public class BookService {

    public static List<Book> bookList = new LinkedList<>();

    public static List<Book> getBookList() {
        return bookList;
    }

    public List<Book> wybierzTyp(String typ) {
        List<Book> someBook = new ArrayList<>();
        for (Book book : bookList) {
            if (typ.equalsIgnoreCase(book.movesType.toString())) {
                someBook.add(book);
            }
        }
        return someBook;
    }

    public List<Book> beforeYear(int year) {
        List<Book> before = new ArrayList<>();
        for (Book book : bookList) {
            if (book.year < year) {
                before.add(book);
            }
        }
        return before;
    }

    public Map.Entry<Double, String> expensiverBook() {
        TreeMap<Double, String> mapMaxPriceOfBook = new TreeMap<>();
        for (Book book : bookList) {
            mapMaxPriceOfBook.put(book.price, book.title);
        }
        return mapMaxPriceOfBook.lastEntry();
    }

    public Map.Entry<Double, String> cheapestBook() {
        TreeMap<Double, String> mapMinPriceOfBook = new TreeMap<>();
        for (Book book : bookList) {
            mapMinPriceOfBook.put(book.price, book.title);
        }
        return mapMinPriceOfBook.firstEntry();
    }

    public List<Book> sortowanieRosnaco(String text) {
        List<Book> sortList = new LinkedList<>();
            for (Book book : bookList) {
                sortList.add(book);
                if(text.equalsIgnoreCase("price")){
                    sortList.sort(Comparator.comparingDouble(Book::getPrice));
                } else if(text.equalsIgnoreCase("year")){
                    sortList.sort(Comparator.comparingInt(Book::getYear));
                } else if(text.equalsIgnoreCase("title")){
                    sortList.sort(Comparator.comparing(Book::getTitle));
                }else if(text.equalsIgnoreCase("type")){
                    sortList.sort(Comparator.comparing(Book::getMovesType));
                }

            }
            return sortList;
        }
    public List<Book> sortowanieMalejaco(String text) {
        List<Book> sortList = new LinkedList<>();
        for (Book book : bookList) {
            sortList.add(book);
            if(text.equalsIgnoreCase("price")){
                sortList.sort(Comparator.comparingDouble(Book::getPrice).reversed());
            } else if(text.equalsIgnoreCase("year")){
                sortList.sort(Comparator.comparingInt(Book::getYear).reversed());
            } else if(text.equalsIgnoreCase("title")){
                sortList.sort(Comparator.comparing(Book::getTitle).reversed());
            }else if(text.equalsIgnoreCase("type")){
                sortList.sort(Comparator.comparing(Book::getMovesType).reversed());
            }

        }
        return sortList;
    }

    public List<Book> szukanieKsiazki(String title) {
        List<Book> searchedBook = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title))
                searchedBook.add(book);
        }
        return searchedBook;
    }
    

        public static void main (String[]args){


            Author a1 = new Author("Maciej", "Maciejowski", "male");
            Author a2 = new Author("Robert", "Roberczuk", "male");
            Author a3 = new Author("Iwona", "Iwaniewska", "female");


            List<Author> authorList = new LinkedList<>();

            authorList.add(a1);
            authorList.add(a2);
            authorList.add(a3);
            for (Author author : authorList) {
                System.out.println(author);
            }


            Book book1 = new Book("Ja Frank", 26.8, 2010, a2, MovesType.THRILLER);
            Book book2 = new Book("Zakochaj się we mnie", 21.4, 1997, a1, MovesType.COMEDY);
            Book book3 = new Book("Nad jeziorem", 16.0, 1998, a3, MovesType.DRAMA);
            Book book4 = new Book("High School Music", 35.5, 2012, a3, MovesType.MUSICAL);
            Book book5 = new Book("Nie poddawaj się", 55.9, 2020, a1, MovesType.SF);

            System.out.println("Dodanie książek do listy");

            bookList.add(book1);
            bookList.add(book2);
            bookList.add(book3);
            bookList.add(book4);
            bookList.add(book5);

            System.out.println("Usunięcie książki SF");
            bookList.remove(book5);

            System.out.println("Lista książek");
            System.out.println(getBookList());

            BookService bookService = new BookService();
            System.out.println("Książki typu Comedy: " + bookService.wybierzTyp("comedy"));
            System.out.println("Książki przed danym rokiem: " + bookService.beforeYear(1999));
            System.out.println("Najdroższa książka: " + bookService.expensiverBook());
            System.out.println("Najtańsza książka: " + bookService.cheapestBook());
            System.out.println(bookService.sortowanieMalejaco("title"));
            System.out.println(bookService.szukanieKsiazki("Ja Franki"));


        }
    }





