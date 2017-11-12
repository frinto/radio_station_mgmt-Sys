import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * This Class Is the Item Class of which child classes will inherit from
 * It contains the general information for a particular item and
 * upon instantiation will create An Item object that will allow you to manipulate
 * said Items.
 *
 * @author Huy Le
 * @version 8 Feb 2017
 */
public class Item {

    /**
     * the id of the Item
     */
    private int id = 0;

    /**
     * the category of the Item
     */
    private char category = 'x';

    /**
     * the title of the Item
     */
    private String title = "x";

    /**
     * the artistOrGroup of the Item
     */
    private String artistOrGroup = "x";

    /**
     * the playTime of the Item
     */
    private String playTime = "x";

    /**
     * the file name of the Item
     */
    private String audioFileName = "x";


    /**
     * is an ArrayList of items used to hold ALL ITEMS OF SUBCLASSES
     */
    public static ArrayList<Item> itemArrayList = new ArrayList<Item>();

    /**
     * default Contructor For Item
     */
    Item() {

    }


    /**
     * overload Contructor For Item
     *
     * @param id            is an int it is the ID of the item
     * @param category      is a char which is the category of the Item
     * @param title         is a String which is the title of the Item
     * @param artistOrGroup is a String which is the artistOrGroup of the Item
     * @param playTime      is a String which is the playTime Of the Item
     * @param audioFileName is a String which is the file name of the Item
     */
    Item(int id, char category, String title, String artistOrGroup, String playTime, String audioFileName) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.artistOrGroup = artistOrGroup;
        this.playTime = playTime;
        this.audioFileName = audioFileName;
    }

    /**
     * overload Contructor For Item
     *
     * @param id            is an int it is the ID of the item
     * @param category      is a char which is the category of the Item
     * @param artistOrGroup is a String which is the artistOrGroup of the Item
     * @param playTime      is a String which is the playTime Of the Item
     * @param audioFileName is a String which is the file name of the Item
     */
    Item(int id, char category, String artistOrGroup, String playTime, String audioFileName) {
        this.id = id;
        this.category = category;
        this.artistOrGroup = artistOrGroup;
        this.playTime = playTime;
        this.audioFileName = audioFileName;
    }


    /**
     * search the list of items in database.txt by the ID and returns Item found.
     *
     * @param id is of type int which is the ID to search for
     * @return the Item found else it returns null indicating not found
     */
    public Item searchListOfItemByIDSixItems(int id) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfItemString = "x";

        char categoryOfItem = 'x';
        String itemTitle = "x";
        String groupOrArister = "x";
        String playTimeOfItem = "x";
        String fileNameOfItem = "x";

        Item itemThatWasFound = new Item();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length < 6) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfItemString = parts[1];
            itemTitle = parts[2];
            groupOrArister = parts[3];
            playTimeOfItem = parts[4];
            fileNameOfItem = parts[5];

            categoryOfItem = categoryOfItemString.charAt(0);

            if (idToCompare == id) {

                System.out.println("===========================");
                System.out.println("ID FOUND! IN DATABASE.TXT  ");
                System.out.println("===========================");

                itemThatWasFound = new Item(idToCompare, categoryOfItem, itemTitle, groupOrArister, playTimeOfItem, fileNameOfItem);

                return itemThatWasFound;
            }
        }
        System.out.println("=============================");
        System.out.println("ID NOT FOUND! IN DATABASE.TXT");
        System.out.println("=============================");
        return itemThatWasFound;
    }


    /**
     * search the list of items in database.txt by the ID and returns Item found.
     *
     * @param id is of type int which is the ID to search for
     * @return the Item found else it returns null indicating not found
     */
    public Item searchListOfItemByIDFiveItems(int id) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfItemString = "x";

        char categoryOfItem = 'x';
        String itemTitle = "x";
        String groupOrArister = "x";
        String playTimeOfItem = "x";
        String fileNameOfItem = "x";

        Item itemThatWasFound = new Item();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length > 5) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfItemString = parts[1];
            groupOrArister = parts[2];
            playTimeOfItem = parts[3];
            fileNameOfItem = parts[4];

            categoryOfItem = categoryOfItemString.charAt(0);

            if (idToCompare == id) {

                System.out.println("============================");
                System.out.println("ID FOUND IN DATABASE.TXT!   ");
                System.out.println("============================");

                itemThatWasFound = new Item(idToCompare, categoryOfItem, itemTitle, groupOrArister, playTimeOfItem, fileNameOfItem);

                return itemThatWasFound;
            }
        }
        System.out.println("===================================");
        System.out.println("ERROR ID NOT FOUND! IN DATABASE.TXT");
        System.out.println("===================================");
        return itemThatWasFound;
    }


    /**
     * the to String method of the Item class
     *
     * @return this method returns the String of the item
     */
    public String toString() {
        return id + "," + category + "," + title + "," + artistOrGroup + "," + playTime + "," + audioFileName;
    }

    /**
     * gets the ID of the item
     *
     * @return the int ID of the item
     */
    public int getId() {
        return id;
    }

    /**
     * sets the ID of the item
     *
     * @param id int ID of the item to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the category of the item
     *
     * @return the char category of the item
     */
    public char getCategory() {
        return category;
    }

    /**
     * sets the category of the item
     *
     * @param category char category of the item to set
     */
    public void setCategory(char category) {
        this.category = category;
    }

    /**
     * gets the title of the item
     *
     * @return the String title of the item
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title of the item
     *
     * @param title the String title of the item
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * gets the artist or group of the item
     *
     * @return the String Artist Or Group of the item
     */
    public String getArtistOrGroup() {
        return artistOrGroup;
    }

    /**
     * sets the artist or group of the item
     *
     * @param artistOrGroup String artist or group of the item
     */
    public void setArtistOrGroup(String artistOrGroup) {
        this.artistOrGroup = artistOrGroup;
    }

    /**
     * gets the play Time of the item
     *
     * @return the String play Time of the item
     */
    public String getPlayTime() {
        return playTime;
    }

    /**
     * sets the play time of the item
     *
     * @param playTime the String play Time of the item
     */
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    /**
     * gets the audio file name of the item
     *
     * @return the String file name of the item
     */
    public String getAudioFileName() {
        return audioFileName;
    }

    /**
     * sets the file name of the item
     *
     * @param audioFileName the String file name of the item
     */
    public void setAudioFileName(String audioFileName) {
        this.audioFileName = audioFileName;
    }

    /**
     * load list of items that has five elements from database.txt into the itemArrayList
     */
    private void loadListItemsFiveElements() throws FileNotFoundException {
        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfItemString = "x";

        char categoryOfItem = 'x';
        String groupOrArister = "x";
        String playTimeOfItem = "x";
        String fileNameOfItem = "x";

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length > 5) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfItemString = parts[1];
            groupOrArister = parts[2];
            playTimeOfItem = parts[3];
            fileNameOfItem = parts[4];

            categoryOfItem = categoryOfItemString.charAt(0);

            Item item = new Item(idToCompare, categoryOfItem, groupOrArister, playTimeOfItem, fileNameOfItem);
            itemArrayList.add(item);
        }

    }

    /**
     * load list of items that has six elements from database.txt into the itemArrayList
     */
    private void loadListItemsSixElements() throws FileNotFoundException {
        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfItemString = "x";

        char categoryOfItem = 'x';
        String itemTitle = "x";
        String groupOrArister = "x";
        String playTimeOfItem = "x";
        String fileNameOfItem = "x";

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length < 6) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfItemString = parts[1];
            itemTitle = parts[2];
            groupOrArister = parts[3];
            playTimeOfItem = parts[4];
            fileNameOfItem = parts[5];

            categoryOfItem = categoryOfItemString.charAt(0);

            Item item = new Item(idToCompare, categoryOfItem, itemTitle, groupOrArister, playTimeOfItem, fileNameOfItem);
            itemArrayList.add(item);
        }

    }

    /**
     * load the complete list of items that has five  and six elements from database.txt
     * into the itemArrayList
     */
    public void loadCompleteListOfItems() throws FileNotFoundException {
        loadListItemsSixElements();
        loadListItemsFiveElements();
    }

    /**
     * gets the elements in the itemArrayList
     *
     * @return ArrayList<Item>
     */
    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    /**
     * copy the itemArrayList and replace the data in the database.txt file
     */
    public void saveToDatabaseTxt() throws IOException {

        FileWriter fileWriterDatabaseTxt = new FileWriter("res/database.txt", false);
        PrintWriter printToDatabaseTxt = new PrintWriter(fileWriterDatabaseTxt);

        for (int i = 0; i < itemArrayList.size(); i++) {
            System.out.println(itemArrayList.get(i));
            printToDatabaseTxt.println(itemArrayList.get(i));
        }

        printToDatabaseTxt.close();
        fileWriterDatabaseTxt.close();
    }

    /**
     * generates random playlist based on the number of contents
     *
     * @param number takses in a number integer type.
     */
    public void generateRandomPlayList(int number) throws FileNotFoundException {

        Collections.shuffle(itemArrayList);

        for (int i = 0; i < number; i++) {
            System.out.println(itemArrayList.get(i));
        }

    }
}
