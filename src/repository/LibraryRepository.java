package repository;

import entities.Book;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {

    private List<Book> books = new ArrayList<>();

    public LibraryRepository(){
        seed();
    }

    public void seed(){
        books.add(new Book(1, "O Senhor dos Anéis", "Tolkien", 1954));
        books.add(new Book(2, "Clean Code", "Robert C. Martin", 2008));
        books.add(new Book(3, "Duna", "Frank Herbert", 1965));
    }
    public Book findBookById(int id){
        for (Book x : books){
            if(x.getId() == id){
               return x;
            }
        }
        return null;
    }
}
