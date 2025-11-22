import entities.Book;
import service.LibraryService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private LibraryService service;
    Scanner sc = new Scanner(System.in);

    public Menu(LibraryService service){
        this.service = service;
    }

    public void start(){
        while (true){
            System.out.println("1 - Add book");
            System.out.println("2 - Remove book");
            System.out.println("3 - Find book by Id");
            System.out.println("4 - List books");
            System.out.println("0 - Exit");
            System.out.print("Enter: ");

            int option = sc.nextInt();

            switch (option){
                case 1:
                    addBook();
                    break;
                case 3:
                    findBook();
                    break;
                case 4:
                    System.out.println("------------------------------");
                    listBooks();
                    System.out.println("------------------------------");
                    break;
                case 0: {
                    System.out.println("Closing...");
                    return;
                }
                default:
                    System.out.println("Invalid option.\n");

            }
        }
    }

    private void addBook(){
        try {
            System.out.print("Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Book title: ");
            String title = sc.nextLine();
            System.out.print("Author of the book: ");
            String author = sc.nextLine();
            System.out.print("Year of publication of the book: ");
            int year = sc.nextInt();

            service.registerBook(new Book(id, title, author, year));
            System.out.println("Added successfully!\n");
        }
        catch (InputMismatchException e){
            System.out.println("Invalid input. Please type the correct data type.\n");
            sc.nextLine();
        }
    }
    private void findBook(){
        System.out.println("Enter the book ID: ");
        int id = sc.nextInt();
        Book found = service.getBook(id);

        if(found == null) {
            System.out.println("Book not found.\n");
        }else{
            System.out.println(found + "\n");
        }
    }
    private void listBooks(){
        List<Book> bookList = service.getAllBooks();

        if(bookList.isEmpty()){
            System.out.println("No books found.");
        }else {
            for(Book book : bookList){
                System.out.println(book);
            }
        }
    }
}
