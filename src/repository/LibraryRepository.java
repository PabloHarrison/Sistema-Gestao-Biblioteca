package repository;

import entities.Book;
import exception.DuplicateIdException;
import exception.DuplicateTitleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void addBook(Book book){
        for(Book x : books){
            if(Objects.equals(x.getId(), book.getId())){
                throw new DuplicateIdException("ID already exists.");
            }else if(x.getTitle().equals(book.getTitle())){
                throw new DuplicateTitleException("Title already exists.");
            }
        }
        books.add(book);
    }
    public void removeBookById(int id){
        books.removeIf(x -> x.getId() == id);
    }
    public Book findBookById(int id){
        for (Book x : books){
            if(Objects.equals(id, x.getId())){
               return x;
            }
        }
        return null;
    }
    public List<Book> listBooks(){
        return new ArrayList<>(books);
    }
}
