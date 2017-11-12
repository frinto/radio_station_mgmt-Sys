import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This Class Is the Menu class which displays the menu
 *
 * @author Huy Le
 * @version 8 Feb 2017
 */
public class Menu {

    /**
     * tells if the program is running or not
     * is of type boolean true if running
     * false if not running
     */
    static private boolean isProgramRunning = true;

    /**
     * used to get the input from user of type Scanner
     */
    static private Scanner keyboard = new Scanner(System.in);

    /**
     * gets the user input of type integers.
     */
    static private int userInput = 0;

    /**
     * an interactive menu for which the user will interact
     * the interface to which the user will interact and is used in main() to start program.
     */
    static public void displayMenu() throws IOException {

        Item item = new Item();

        //loads the array with the complete list of items.
        item.loadCompleteListOfItems();

        Song song = new Song();
        TalkShow talkShow = new TalkShow();
        Commercial commercial = new Commercial();

        do {

            System.out.println("1.  Add a new Song, Talk Show or Commercial");
            System.out.println("2.	Search for a item by id");
            System.out.println("3.	Remove a Song, Talk Show or Commercial by id");
            System.out.println("4.	Create a random playlist given the amount of time");
            System.out.println("5.	Print complete list or items by category");
            System.out.println("6.	Exit the program.");
            System.out.println();
            System.out.print("What is your Selection 1, 2, 3, 4, 5, or 6? : ");
            userInput = keyboard.nextInt();

            switch (userInput) {

                case 1:
                    System.out.println("===============================================");
                    System.out.println("You Chose to Add Song, Talk Show Or Commercial!");
                    System.out.println("===============================================");
                    System.out.println("1.  Add a Song");
                    System.out.println("2.  Add a Talk Show");
                    System.out.println("3.	Add a Commercial");
                    System.out.println();
                    System.out.print("What is your Selection 1, 2, or 3? : ");
                    userInput = keyboard.nextInt();

                    switch (userInput) {
                        case 1:
                            System.out.println("==============================");
                            System.out.println("YOU CHOSE TO ADD A SONG!      ");
                            System.out.println("==============================");

                            int id;
                            char categoryOfSong;
                            String songtitle;
                            String songArtist;
                            String playTime;
                            String audioFileName;

                            System.out.print("Please Enter A 4 DIGIT SONG ID: ");
                            id = keyboard.nextInt();
                            System.out.println();

                            System.out.println("Enter The Category Of Music");
                            System.out.println("classical (L), country (C), rock (R), pop (P), and alternative (A)");
                            System.out.print("What is your category? (L, C, R, P OR A)? ");
                            categoryOfSong = keyboard.next().charAt(0);

                            keyboard.nextLine(); // consume left over
                            System.out.println();

                            if (!Character.isLetter(categoryOfSong)) {

                                System.out.println("================================================");
                                System.out.println("category must be ONE character (L, C, R, P OR A)");
                                System.out.println("================================================");

                                return;
                            }

                            System.out.print("what is the song title?: ");
                            songtitle = keyboard.nextLine();
                            System.out.println();

                            System.out.print("who is the song artist or group? ");
                            songArtist = keyboard.nextLine();
                            System.out.println();

                            System.out.print("what is the play time of the song? example (4:00): ");
                            playTime = keyboard.next();
                            System.out.println();

                            keyboard.nextLine(); // consume left over

                            System.out.print("what is the audio File Name? Example (cat.mp3): ");
                            audioFileName = keyboard.nextLine();
                            System.out.println();


                            Song newSong = new Song(id, categoryOfSong, songtitle, songArtist, playTime, audioFileName);

                            song.AddSongToList(newSong);

                            System.out.println(song.getSongList());


                            break;
                        case 2:
                            System.out.println("==============================");
                            System.out.println("YOU CHOSE TO ADD A Talk Show! ");
                            System.out.println("==============================");

                            int idOfTalkShow;
                            char categoryOfTalkShow;
                            String talkShowTitle;
                            String host;
                            String runTime;
                            String talkShowFileName;

                            System.out.print("Please Enter A 4 DIGIT Talk Show ID: ");
                            idOfTalkShow = keyboard.nextInt();
                            System.out.println();

                            System.out.println("Enter The Category Of Talk Show");
                            System.out.println("science (S), politics (P) and miscellaneous (M)");
                            System.out.print("What is your category? (S, P OR M)? ");
                            categoryOfTalkShow = keyboard.next().charAt(0);

                            keyboard.nextLine(); // consume left over
                            System.out.println();

                            if (!Character.isLetter(categoryOfTalkShow)) {

                                System.out.println("================================================");
                                System.out.println("category must be ONE character (S, P OR M)");
                                System.out.println("================================================");

                                return;
                            }

                            System.out.print("what is the talk show title?: ");
                            talkShowTitle = keyboard.nextLine();
                            System.out.println();

                            System.out.print("who is the host of the talk Show?: ");
                            host = keyboard.nextLine();
                            System.out.println();

                            System.out.print("what is the run time of the talk show? example (4:00): ");
                            runTime = keyboard.next();
                            System.out.println();

                            keyboard.nextLine(); // consume left over

                            System.out.print("what is the audio File Name? Example (talk_show.avi): ");
                            talkShowFileName = keyboard.nextLine();
                            System.out.println();


                            TalkShow newTalkShow = new TalkShow(idOfTalkShow, categoryOfTalkShow, talkShowTitle, host, runTime, talkShowFileName);

                            talkShow.AddTalkShowToList(newTalkShow);

                            System.out.print(talkShow.getTalkShowList());

                            break;
                        case 3:
                            System.out.println("==============================");
                            System.out.println("YOU CHOSE TO ADD A Commercial!");
                            System.out.println("==============================");

                            int idOfCommercial;
                            char categoryOfCommercial;
                            String company;
                            String runTimeOfCommercial;
                            String commercialFileName;

                            System.out.print("Please Enter A 4 DIGIT Commercial ID: ");
                            idOfCommercial = keyboard.nextInt();
                            System.out.println();

                            System.out.println("Enter The Category Of Commercial");
                            System.out.println("vehicle dealers (V), household products (H), computers (C), and miscellaneous (M)");
                            System.out.print("What is your category? (V, H, C OR M)? ");
                            categoryOfCommercial = keyboard.next().charAt(0);

                            keyboard.nextLine(); // consume left over
                            System.out.println();

                            if (!Character.isLetter(categoryOfCommercial)) {

                                System.out.println("================================================");
                                System.out.println("category must be ONE character (V, H, C OR M)");
                                System.out.println("================================================");

                                return;
                            }


                            System.out.print("what Comapny is the commercial from?: ");
                            company = keyboard.nextLine();
                            System.out.println();

                            System.out.print("what is the run time of the Commercial? example (0:30): ");
                            runTimeOfCommercial = keyboard.next();
                            System.out.println();

                            keyboard.nextLine(); // consume left over

                            System.out.print("what is the Commercial File Name? Example (Commercial.avi): ");
                            commercialFileName = keyboard.nextLine();
                            System.out.println();


                            Commercial newCommercial = new Commercial(idOfCommercial, categoryOfCommercial, company, runTimeOfCommercial, commercialFileName);

                            commercial.AddCommercialToList(newCommercial);

                            System.out.print(commercial.getCommercialList());

                            break;
                    }
                    break;
                case 2:
                    System.out.println("==============================");
                    System.out.println("YOU CHOSE TO SEARCH!          ");
                    System.out.println("==============================");
                    System.out.println();
                    System.out.println("1.  Search for a Song");
                    System.out.println("2.  Search for a Talk Show");
                    System.out.println("3.	Search for a Commercial");
                    System.out.print("what is your selection (1, 2, or 3)?: ");
                    userInput = keyboard.nextInt();

                    if (userInput == 1 || userInput == 2) {
                        System.out.print("What is the 4 DIGIT ID you would like to search for?: ");
                        int id = keyboard.nextInt();

                        Item myItem = new Item();

                        System.out.println(myItem.searchListOfItemByIDSixItems(id).toString());
                    } else if (userInput == 3) {
                        System.out.print("What is the 4 DIGIT ID you would like to search for?: ");
                        int id = keyboard.nextInt();

                        Item myItem = new Item();

                        System.out.println(myItem.searchListOfItemByIDFiveItems(id).toString());
                    }
                    break;
                case 3:

                    System.out.println("==============================");
                    System.out.println("You Chose to REMOVE an ITEM   ");
                    System.out.println("==============================");
                    System.out.println();
                    System.out.println("1.  REMOVE a Song");
                    System.out.println("2.  REMOVE a Talk Show");
                    System.out.println("3.	REMOVE a Commercial");
                    System.out.print("what is your selection (1, 2, or 3)?: ");
                    userInput = keyboard.nextInt();

                    if (userInput == 1) {
                        System.out.print("What is the 4 DIGIT ID of Song you want removed?: ");
                        int id = keyboard.nextInt();

                        song.removeSongFromList(id);

                    } else if (userInput == 2) {
                        System.out.print("What is the 4 DIGIT ID of Talk Show you want removed?: ");
                        int id = keyboard.nextInt();

                        talkShow.removeTalkShowFromList(id);

                    } else if (userInput == 3) {
                        System.out.print("What is the 4 DIGIT ID of commercial you want removed?: ");
                        int id = keyboard.nextInt();

                        commercial.removeCommercialFromList(id);
                    }

                    break;
                case 4:

                    System.out.println("============================================");
                    System.out.println("YOU CHOSE TO CREATE RANDOM PLAYLIST         ");
                    System.out.println("============================================");
                    System.out.println();

                    System.out.println("How Much Content Would You Like  ");
                    System.out.print("In Your Random Playlist?(example: 10): ");
                    int num = keyboard.nextInt();

                    System.out.println("==================================================");
                    System.out.println("YOUR RANDOM PLAYLIST CONSISTS OF " + num + " Items");
                    System.out.println("==================================================");
                    System.out.println();
                    item.generateRandomPlayList(num);

                    break;
                case 5:
                    System.out.println("============================================");
                    System.out.println("YOU CHOSE TO PRINT COMPLETE LIST BY CATEGORY");
                    System.out.println("============================================");
                    System.out.println();
                    System.out.println("1.  PRINT COMPLETE LIST OF A SONG");
                    System.out.println("2.  PRINT COMPLETE LIST OF A TALK SHOW");
                    System.out.println("3.	PRINT COMPLETE LIST OF COMMERCIAL");
                    System.out.print("what is your selection (1, 2, or 3)?: ");
                    userInput = keyboard.nextInt();

                    switch (userInput) {

                        case 1:
                            System.out.println("Enter The Category Of Music");
                            System.out.println("classical (L), country (C), rock (R), pop (P), and alternative (A)");
                            System.out.print("What is your category? (L, C, R, P OR A)? ");
                            char categoryOfSong = keyboard.next().charAt(0);

                            song.findCompleteListByCatergory(Character.toUpperCase(categoryOfSong));

                            System.out.println();

                            if (!Character.isLetter(categoryOfSong)) {

                                System.out.println("================================================");
                                System.out.println("category must be ONE character (L, C, R, P OR A)");
                                System.out.println("================================================");

                                return;
                            }
                            break;

                        case 2:
                            System.out.println("Enter The Category Of Talk Show");
                            System.out.println("science (S), politics (P) and miscellaneous (M)");
                            System.out.print("What is your category? (S, P OR M)? ");
                            char categoryOfTalkShow = keyboard.next().charAt(0);

                            talkShow.findCompleteListByCatergory(Character.toUpperCase(categoryOfTalkShow));

                            System.out.println();

                            if (!Character.isLetter(categoryOfTalkShow)) {

                                System.out.println("================================================");
                                System.out.println("category must be ONE character (S, P OR M)");
                                System.out.println("================================================");

                                return;
                            }
                            break;

                        case 3:
                            System.out.println("Enter The Category Of Commercial");
                            System.out.println("vehicle dealers (V), household products (H), computers (C), and miscellaneous (M)");
                            System.out.print("What is your category? (V, H, C OR M)? ");
                            char categoryOfCommercial = keyboard.next().charAt(0);

                            commercial.findCompleteListByCatergory(Character.toUpperCase(categoryOfCommercial));

                            System.out.println();

                            if (!Character.isLetter(categoryOfCommercial)) {

                                System.out.println("================================================");
                                System.out.println("category must be ONE character (V, H, C OR M)");
                                System.out.println("================================================");

                                return;
                            }
                            break;

                        default:
                            System.out.println("================================================");
                            System.out.println("ERROR PLEASE TRY AGAIN ENTER 1, 2 OR 3          ");
                            System.out.println("================================================");
                    }

                    break;
                case 6:

                    System.out.println("==============================");
                    System.out.println("You Chose to exit the program");
                    System.out.println("==============================");

                    item.saveToDatabaseTxt();

                    System.out.println("==============================");
                    System.out.println("Changes saved to database.txt");
                    System.out.println("==============================");

                    isProgramRunning = false;
                    System.exit(0);

                    break;
                default:
                    System.out.println("==============================================");
                    System.out.println("ERROR INCORRECT SELECTION TRY AGAIN!          ");
                    System.out.println("==============================================");
                    System.out.println();
            }

        } while (isProgramRunning);

    }

}
