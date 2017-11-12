import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Class Is the Song class
 * Contains information of a Song
 * This class inherits from Item and all its public members
 *
 * @author Huy Le
 * @version 8 Feb 2017
 */
public class Song extends Item {

    /**
     * an ArrayList used to hold all songs added to the list.
     * of type ArrayList<Song>
     */
    private ArrayList<Song> songList = new ArrayList<Song>();

    /**
     * default constructor
     * calls super() to ensure hierarchy properly initialised
     */
    Song() {
        super();
    }

    /**
     * overload Contructor For Song
     *
     * @param id             is an int it is the ID of the song
     * @param categoryOfSong is a char which is the category of the song
     * @param songtitle      is a String which is the title of the song
     * @param songArtist     is a String which is the artistOrGroup of the song
     * @param playTime       is a String which is the playTime Of the song
     * @param audioFileName  is a String which is the file name of the song
     */
    Song(int id, char categoryOfSong, String songtitle, String songArtist, String playTime, String audioFileName) {

        super(id, categoryOfSong, songtitle, songArtist, playTime, audioFileName);
    }

    /**
     * search the list of items in database.txt by the ID and returns Item found.
     *
     * @param id is of type int which is the ID to search for
     * @return the Item found else it returns null indicating not found
     */
    private Song searchListByID(int id) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfSongString = "x";

        char categoryOfSong = 'x';
        String songTitle = "x";
        String songArtist = "x";
        String playTime = "x";
        String audioFileName = "x";

        Song songThatWasFound = new Song();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length < 6) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfSongString = parts[1];
            songTitle = parts[2];
            songArtist = parts[3];
            playTime = parts[4];
            audioFileName = parts[5];

            categoryOfSong = categoryOfSongString.charAt(0);

            if (idToCompare == id) {

                System.out.println("===========================");
                System.out.println("ID FOUND! IN DATABASE.TXT  ");
                System.out.println("===========================");

                songThatWasFound = new Song(idToCompare, categoryOfSong, songTitle, songArtist, playTime, audioFileName);

                return songThatWasFound;
            }
        }
        System.out.println("=============================");
        System.out.println("ID NOT FOUND! IN DATABASE.TXT");
        System.out.println("=============================");
        return null;
    }

    /**
     * adds the song to the list
     *
     * @param ourSong is of type Song which is the Song to be added to list
     */
    public void AddSongToList(Song ourSong) throws FileNotFoundException {

        if (searchListByID(ourSong.getId()) == null) {

            songList.add(ourSong);
            itemArrayList.add(ourSong);

            System.out.println("=================================");
            System.out.println("SONG HAS BEEN ADDED TO THE LIST!!");
            System.out.println("=================================");

        } else {
            System.out.println("==============================================================");
            System.out.println("ERROR@@ SONG ALREADY EXISTS IN DATABASE.TXT TRY A DIFFERENT ID");
            System.out.println("==============================================================");
        }
    }

    /**
     * gets the songList from Attribute songList
     *
     * @return an ArrayList of songs
     */
    public ArrayList<Song> getSongList() {
        return songList;
    }


    /**
     * to String method
     *
     * @return the String of the class
     */
    @Override
    public String toString() {
        return getId() + "," + getCategory() + "," + getTitle() + "," + getArtistOrGroup() + "," + getPlayTime() + "," + getAudioFileName();
    }


    /**
     * remove the song from the songList
     *
     * @param id is the id of the song to remove
     */
    public void removeSongFromList(int id) throws FileNotFoundException {

        if (searchListByID(id) != null) {

            for (int i = 0; i < itemArrayList.size(); i++) {

                if (itemArrayList.get(i).getId() == id) {
                    System.out.println("===========================================================");
                    System.out.println("SUCCESS SONG HAS BEEN REMOVED FROM LIST!!!!!!              ");
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
            System.out.println("ERROR!!SONG CANNOT BE FOUND SO THEREFORE CANNOT BE REMOVED!");
            System.out.println("===========================================================");
        }

    }

    /**
     * search the List and searches for the category
     *
     * @param category is the id of the song to find
     */
    public void findCompleteListByCatergory(char category) throws FileNotFoundException {

        if (searchListByChar(category) != null) {

            for (int i = 0; i < itemArrayList.size(); i++) {

                if (itemArrayList.get(i).getCategory() == 'L' || itemArrayList.get(i).getCategory() == 'C' ||
                        itemArrayList.get(i).getCategory() == 'R' || itemArrayList.get(i).getCategory() == 'P' ||
                        itemArrayList.get(i).getCategory() == 'A') {
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
            System.out.println("ERROR!!CATEGORY CANNOT BE FOUND                            ");
            System.out.println("===========================================================");
        }


    }

    /**
     * searches the list by char
     *
     * @param category of type char which is used to find the category in the list.
     */
    private Song searchListByChar(char category) throws FileNotFoundException {


        File file = new File("res/database.txt");
        Scanner inputFile = new Scanner(file);

        String line = "x";
        String[] parts;
        int idToCompare = 0;

        //used to save the category into string then will be converted later to char.
        String categoryOfSongString = "x";

        char categoryOfSong = 'x';
        String songTitle = "x";
        String songArtist = "x";
        String playTime = "x";
        String audioFileName = "x";

        Song songThatWasFound = new Song();

        while (inputFile.hasNext()) {

            line = inputFile.nextLine();
            parts = line.split(",");

            if (parts.length < 6) continue;

            idToCompare = Integer.parseInt(parts[0]);

            categoryOfSongString = parts[1];
            songTitle = parts[2];
            songArtist = parts[3];
            playTime = parts[4];
            audioFileName = parts[5];

            categoryOfSong = categoryOfSongString.charAt(0);

            if (categoryOfSong == category) {

                System.out.println("==================================");
                System.out.println("CATEGORY FOUND! IN DATABASE.TXT   ");
                System.out.println("==================================");

                songThatWasFound = new Song(idToCompare, categoryOfSong, songTitle, songArtist, playTime, audioFileName);


                return songThatWasFound;
            }
        }
        System.out.println("===================================");
        System.out.println("CATEGORY NOT FOUND! IN DATABASE.TXT");
        System.out.println("===================================");
        return null;
    }


}
