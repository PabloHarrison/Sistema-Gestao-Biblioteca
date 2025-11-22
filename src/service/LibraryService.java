package service;

import entities.Book;
import repository.LibraryRepository;

import java.util.List;

public class LibraryService {

    private LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public void registerBook(Book book){
        repository.addBook(book);
    }
    public Book getBook(Integer id){
        return repository.findBookById(id);
    }
    public List<Book> getAllBooks(){
        return repository.listBooks();
    }
}
