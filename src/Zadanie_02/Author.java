package Java_zaawansowana_zadania_pdf.Kolekcje_zadania.Zadanie_02;

import java.util.Objects;

public class Author {
    protected String name;
    protected String surname;
    protected String sex;

    public Author(){
    }
    public Author(String name, String surname, String sex){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname) &&
                Objects.equals(sex, author.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, sex);
    }
}
