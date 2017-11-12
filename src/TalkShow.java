import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class Is the commercial class
 * Contains information of a commercial
 * This class inherits from Item and all its public members
 *
 * @author Huy Le
 * @version 8 Feb 2017
 */
public class TalkShow extends Item {

    /**
     * an ArrayList used to hold all commercial added to the list.
     * of type ArrayList<commercial>
     */
    private ArrayList<TalkShow> talkShowList = new ArrayList<TalkShow>();

    /**
     * default constructor
     * calls super() to ensure hierarchy properly initialised
     */
    TalkShow(){
        super();
    }

    /**
     * overload Contructor For Song
     *
     * @param id             is an int it is the ID of the talk show
     * @param category is a char which is the category of the talk show
     * @param title      is a String which is the title of the talk show
     * @param host     is a String which is the artistOrGroup of the talk show
     * @param playTime       is a String which is the playTime Of the talk show
     * @param audioFileName  is a String which is the file name of the talk show
     */
    TalkShow(int id, char category, String title, String host, String playTime, String audioFileName) {
        super(id, category, title, host, playTime, audioFileName);
    }

    /**
     * search the list of items in database.txt by the ID and returns Item found.
     *
     * @param id is of type int which is the ID to search for
     * @return the Item found else it returns null indicating not found
     */
    private TalkShow searchListByID(int id) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfTalkShowString = "x";

        char categoryOfTalkShow = 'x';
        String talkShowTitle = "x";
        String host = "x";
        String runTime = "x";
        String talkShowFileName = "x";

        TalkShow talkShowThatWasFound = new TalkShow();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length < 6) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfTalkShowString = parts[1];
            talkShowTitle = parts[2];
            host = parts[3];
            runTime = parts[4];
            talkShowFileName = parts[5];

            categoryOfTalkShow = categoryOfTalkShowString.charAt(0);

            if(idToCompare == id){

                System.out.println("===========================");
                System.out.println("ID FOUND! IN DATABASE.TXT  ");
                System.out.println("===========================");

                talkShowThatWasFound = new TalkShow(idToCompare, categoryOfTalkShow, talkShowTitle, host, runTime, talkShowFileName);

                return talkShowThatWasFound;
            }
        }
        System.out.println("==========================");
        System.out.println("ID NOT FOUND! DATABASE.TXT");
        System.out.println("==========================");
        return null;
    }

    /**
     * adds the TalkShow to the list
     *
     * @param ourTalkShow is of type TalkShow which is the TalkShow to be added to list
     */
    public void AddTalkShowToList(TalkShow ourTalkShow) throws FileNotFoundException {

        if(searchListByID(ourTalkShow.getId()) == null){

            talkShowList.add(ourTalkShow);
            itemArrayList.add(ourTalkShow);

            System.out.println("======================================");
            System.out.println("Talk Show HAS BEEN ADDED TO THE LIST!!");
            System.out.println("======================================");

        }
        else {
            System.out.println("===================================================================");
            System.out.println("ERROR@@ Talk Show ALREADY EXISTS IN DATABASE.TXT TRY A DIFFERENT ID");
            System.out.println("===================================================================");
        }

    }

    /**
     * gets the songList from Attribute talkShowList
     *
     * @return an ArrayList of talk show
     */
    public ArrayList<TalkShow> getTalkShowList() {
        return talkShowList;
    }

    /**
     * to String method
     *
     * @return the String of the class
     */
    @Override
    public String toString() {
        return getId() + "," + getCategory() +"," + getTitle() + "," +getArtistOrGroup() +"," + getPlayTime() +"," + getAudioFileName();
    }

    /**
     * remove the talk show from the talk show
     *
     * @param id is the id of the talk show to remove
     */
    public void removeTalkShowFromList(int id) throws FileNotFoundException {

        if (searchListByID(id) != null) {

            for (int i = 0; i < itemArrayList.size(); i++) {

                if (itemArrayList.get(i).getId() == id) {
                    System.out.println("===========================================================");
                    System.out.println("SUCCESS TalkShow HAS BEEN REMOVED FROM LIST!!!!!!              ");
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
            System.out.println("===========================================================");
            System.out.println("ERROR!!Talk Show CANNOT BE FOUND SO THEREFORE CANNOT BE REMOVED!");
            System.out.println("===========================================================");
        }


    }

    /**
     * search the List and searches for the category
     *
     * @param category is the id of the talk show to find
     */
    public void findCompleteListByCatergory(char category) throws FileNotFoundException {

        if (searchListByChar(category) != null) {

            for (int i = 0; i < itemArrayList.size(); i++) {

                if (itemArrayList.get(i).getCategory() == 'S' || itemArrayList.get(i).getCategory() == 'P' ||
                        itemArrayList.get(i).getCategory() == 'M') {
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
    private TalkShow searchListByChar(char category) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfTalkShowString = "x";

        char categoryOfTalkShow = 'x';
        String talkShowTitle = "x";
        String host = "x";
        String playTime = "x";
        String audioFileName = "x";

        TalkShow talkShowThatWasFound = new TalkShow();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length < 6) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfTalkShowString = parts[1];
            talkShowTitle = parts[2];
            host = parts[3];
            playTime = parts[4];
            audioFileName = parts[5];

            categoryOfTalkShow = categoryOfTalkShowString.charAt(0);

            if (categoryOfTalkShow == category) {

                System.out.println("==================================");
                System.out.println("CATEGORY FOUND! IN DATABASE.TXT   ");
                System.out.println("==================================");

                talkShowThatWasFound = new TalkShow(idToCompare, categoryOfTalkShow, talkShowTitle, host, playTime, audioFileName);


                return talkShowThatWasFound;
            }
        }
        System.out.println("===================================");
        System.out.println("CATEGORY NOT FOUND! IN DATABASE.TXT");
        System.out.println("===================================");
        return null;
    }

}
