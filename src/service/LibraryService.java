package service;

import entities.Book;
import repository.LibraryRepository;

public class LibraryService {

    private LibraryRepository repository;

    public LibraryService(LibraryRepository repository) {
        this.repository = repository;
    }

    public Book getBook(Integer id){
        return repository.findBookById(id);
    }
}
