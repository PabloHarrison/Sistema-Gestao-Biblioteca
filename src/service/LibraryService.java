package service;

import entities.Book;
import exception.DuplicateIdException;
import exception.DuplicateTitleException;
import repository.LibraryRepository;

import java.util.Objects;

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
}
