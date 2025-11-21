import repository.LibraryRepository;
import service.LibraryService;

public class Main {
    public static void main(String[] args){

        LibraryRepository repository = new LibraryRepository();
        LibraryService service = new LibraryService(repository);
        Menu menu = new Menu(service);

        menu.start();
    }
}
