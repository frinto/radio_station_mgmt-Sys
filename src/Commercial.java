import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class Is the Commercial class
 * Contains information of a Commercial
 * This class inherits from Item and all its public members
 *
 * @author Huy Le
 * @version 8 Feb 2017
 */
public class Commercial extends Item {


    /**
     * an ArrayList used to hold all Commercial added to the list.
     * of type ArrayList<Commercial>
     */
    private ArrayList<Commercial> commercialList = new ArrayList<Commercial>();

    /**
     * default constructor
     * calls super() to ensure hierarchy properly initialised
     */
    Commercial() {
        super();
    }

    /**
     * overload Contructor For Song
     *
     * @param id                   is an int it is the ID of the commercial
     * @param categoryOfCommercial is a char which is the category of the commercial
     * @param company              is a String which is the artistOrGroup of the commercial
     * @param playTime             is a String which is the playTime Of the commercial
     * @param audioFileName        is a String which is the file name of the comemrcial
     */
    Commercial(int id, char categoryOfCommercial, String company, String playTime, String audioFileName) {
        super(id, categoryOfCommercial, company, playTime, audioFileName);
    }

    /**
     * search the list of items in database.txt by the ID and returns Item found.
     *
     * @param id is of type int which is the ID to search for
     * @return the Item found else it returns null indicating not found
     */
    private Commercial searchListByID(int id) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfCommercialString = "x";

        char categoryOfCommercial = 'x';
        String company = "x";
        String runTimeOfCommercial = "x";
        String commercialFileName = "x";

        Commercial commercialThatWasFound = new Commercial();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length > 5) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfCommercialString = parts[1];
            company = parts[2];
            runTimeOfCommercial = parts[3];
            commercialFileName = parts[4];

            categoryOfCommercial = categoryOfCommercialString.charAt(0);

            if (idToCompare == id) {

                System.out.println("============================");
                System.out.println("ID FOUND! IN DATABASE.TXT   ");
                System.out.println("============================");

                commercialThatWasFound = new Commercial(idToCompare, categoryOfCommercial, company, runTimeOfCommercial, commercialFileName);

                return commercialThatWasFound;
            }
        }
        System.out.println("=============================");
        System.out.println("ID NOT FOUND! IN DATABASE.TXT");
        System.out.println("=============================");
        return null;
    }

    /**
     * adds the Commercial to the list
     *
     * @param ourCommercial is of type Commercial which is the Song to be added to list
     */
    public void AddCommercialToList(Commercial ourCommercial) throws FileNotFoundException {

        if (searchListByID(ourCommercial.getId()) == null) {

            commercialList.add(ourCommercial);
            itemArrayList.add(ourCommercial);

            System.out.println("======================================");
            System.out.println("Commercial HAS BEEN ADDED TO THE LIST!!");
            System.out.println("======================================");

        } else {
            System.out.println("====================================================================");
            System.out.println("ERROR@@ Commercial ALREADY EXISTS IN DATABASE.TXT TRY A DIFFERENT ID");
            System.out.println("====================================================================");
        }

    }

    /**
     * gets the commercialList from Attribute commercialList
     *
     * @return an ArrayList of Commercial
     */
    public ArrayList<Commercial> getCommercialList() {
        return commercialList;
    }

    /**
     * to String method
     *
     * @return the String of the class
     */
    @Override
    public String toString() {
        return getId() + "," + getCategory() + "," + getArtistOrGroup() + "," + getPlayTime() + "," + getAudioFileName();
    }


    /**
     * remove the commercial from the commercialList
     *
     * @param id is the id of the commercial to remove
     */
    public void removeCommercialFromList(int id) throws FileNotFoundException {

        if (searchListByID(id) != null) {

            for (int i = 0; i < itemArrayList.size(); i++) {

                if (itemArrayList.get(i).getId() == id) {
                    System.out.println("===========================================================");
                    System.out.println("SUCCESS Commercial HAS BEEN REMOVED FROM LIST!!!!!!              ");
                    System.out.println("===========================================================");

                    System.out.println(itemArrayList.get(i).getId() + "," +
                            itemArrayList.get(i).getCategory() + "," +
                            itemArrayList.get(i).getTitle() + "," +
                            itemArrayList.get(i).getArtistOrGroup() + "," +
                            itemArrayList.get(i).getPlayTime() + "," +
                            itemArrayList.get(i).getAudioFileName() + "\n");
                    System.out.println("HAS BEEN REMOVED FROM THE LIST CONGRATULATIONS!!!!!!");

                    itemArrayList.remove(i);
                }
            }


        } else {
            System.out.println("=================================================================");
            System.out.println("ERROR!!Commercial CANNOT BE FOUND SO THEREFORE CANNOT BE REMOVED!");
            System.out.println("=================================================================");
        }


    }

    /**
     * search the List and searches for the category
     *
     * @param category is the id of the commercial to find
     */
    public void findCompleteListByCatergory(char category) throws FileNotFoundException {

        if (searchListByChar(category) != null) {

            for (int i = 0; i < itemArrayList.size(); i++) {

                if (itemArrayList.get(i).getCategory() == 'V' || itemArrayList.get(i).getCategory() == 'H' ||
                        itemArrayList.get(i).getCategory() == 'C' || itemArrayList.get(i).getCategory() == 'M') {
                    if (itemArrayList.get(i).getCategory() == category) {

                        System.out.println(itemArrayList.get(i).getId() + "," +
                                itemArrayList.get(i).getCategory() + "," +
                                itemArrayList.get(i).getTitle() + "," +
                                itemArrayList.get(i).getArtistOrGroup() + "," +
                                itemArrayList.get(i).getPlayTime() + "," +
                                itemArrayList.get(i).getAudioFileName() + "\n");
                    }
                }
            }


        } else {
            System.out.println("===========================================================");
            System.out.println("ERROR!!CATEGORY CANNOT BE FOUND IN DATABASE.TXT            ");
            System.out.println("===========================================================");
        }


    }

    /**
     * searches the list by char
     *
     * @param category of type char which is used to find the category in the list.
     */
    private Commercial searchListByChar(char category) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfCommercialString = "x";

        char categoryOfCommercial = 'x';
        String company = "x";
        String playTime = "x";
        String audioFileName = "x";

        Commercial commercialThatWasFound = new Commercial();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length > 5) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfCommercialString = parts[1];
            company = parts[2];
            playTime = parts[3];
            audioFileName = parts[4];

            categoryOfCommercial = categoryOfCommercialString.charAt(0);

            if (categoryOfCommercial == category) {

                System.out.println("==================================");
                System.out.println("CATEGORY FOUND! IN DATABASE.TXT   ");
                System.out.println("==================================");

                commercialThatWasFound = new Commercial(idToCompare, categoryOfCommercial, company, playTime, audioFileName);


                return commercialThatWasFound;
            }
        }
        System.out.println("===================================");
        System.out.println("CATEGORY NOT FOUND! IN DATABASE.TXT");
        System.out.println("===================================");
        return null;
    }
}
