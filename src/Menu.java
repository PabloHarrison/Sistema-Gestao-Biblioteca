import entities.Book;
import service.LibraryService;

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

            int option = sc.nextInt();

            switch (option){
                case 3:
                    findBook();
                    break;
                case 0: {
                    System.out.println("Closing...");
                    return;
                }
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void findBook(){
        System.out.println("Enter the book ID: ");
        int id = sc.nextInt();
        Book found = service.getBook(id);

        if(found == null) {
            System.out.println("Book not found.");
        }else{
            System.out.println(found);
        }
    }
}
