import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This Class Is the AppDriver Class which is the manager of the program
 * it is the main program where execution starts to start the program
 *
 * @author Huy Le
 * @version 8 Feb 2017
 */
public class AppDriver {

    /**
     * The main method which starts the program
     * @param args is of type String which is used for commandline arguments
     */
    public static void main(String[] args) throws IOException {

        Menu menu = new Menu();

        menu.displayMenu();

    }
}
