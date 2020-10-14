package Java_zaawansowana_zadania_pdf.Kolekcje_zadania.Zadanie_02;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Book {

    String title;
    double price;
    int year;
    Author author;
    MovesType movesType;


    public Book(String title, double price, int year, Author author, MovesType movesType) {
        this.title = title;
        this.price = price;
        this.year = year;
        this.author = author;
        this.movesType = movesType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Author getAuthor() {
        return author;
    }

    public MovesType getMovesType() {
        return movesType;
    }

    public void setMovesType(MovesType movesType) {
        this.movesType = movesType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", author=" + author +
                ", movesType=" + movesType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                year == book.year &&
                Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price, year);
    }
}
