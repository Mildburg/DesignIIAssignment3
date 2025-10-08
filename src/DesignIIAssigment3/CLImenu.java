package DesignIIAssigment3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main menu where the user controls the catalog of media items and can save them to either a binary or csv file.
 */
public class CLImenu {
    public static void main(String[] args) {
        MediaParser mediaParser = new MediaParser();
        Movie movie = new Movie("", 0, 0, "");
        Book book = new Book("", 0, 0, "");
        Album album = new Album("", 0, 0, "");

        String filenameCSV = "catalog.csv";
        String filenameBIN = "catalog.bin";
        ArrayList<MediaItem> catalogItems = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int choice = -1;


        catalogItems = mediaParser.loadItemsCSV(filenameCSV);
        movie.setIdCount(mediaParser.getLastIdNum());
        book.setIdCount(mediaParser.getLastIdNum());
        album.setIdCount(mediaParser.getLastIdNum());

        System.out.println("Welcome to your Media Item Catalog");
        while(choice != 0){
            System.out.println("1. List all Items");
            System.out.println("2. Add item (Book, Movie, Album)");
            System.out.println("3. Save catalog to CSV file");
            System.out.println("4. Export Catalog to binary file");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();//clear buffer

            switch (choice){
                //exit choice
                case 0:
                    System.out.println("Have a good day.");
                    break;
                //Lists all the items in the catalog currently.
                case 1:
                    for(MediaItem m : catalogItems){
                        m.summary();
                    }
                    break;
                //Adds an item to the catalog, user gives information on item.
                case 2:
                    int mediaChoice = 0;
                    System.out.println("Which item would you like to add?");
                    System.out.println("1. Movie");
                    System.out.println("2. Book");
                    System.out.println("3. Album");
                    mediaChoice = scanner.nextInt();
                    scanner.nextLine();//clear buffer
                    switch (mediaChoice){
                        case 1:
                            System.out.println("Please enter the director, year, runtime minutes, and title" +
                                    " pressing enter after each.");
                            String director = scanner.nextLine();
                            int movieYear = scanner.nextInt();
                            scanner.nextLine();//clear buffer
                            int runtimeMinutes = scanner.nextInt();
                            scanner.nextLine();//clear buffer
                            String movieTitle = scanner.nextLine();
                            Movie movie1 = new Movie(director, movieYear, runtimeMinutes, movieTitle);
                            catalogItems.add(movie1);
                            break;
                        case 2:
                            System.out.println("Please enter the author, year, page count, and title" +
                                    " pressing enter after each.");
                            String author = scanner.nextLine();
                            int bookYear = scanner.nextInt();
                            scanner.nextLine();//clear buffer
                            int pageCount = scanner.nextInt();
                            scanner.nextLine();//clear buffer
                            String bookTitle = scanner.nextLine();
                            Book book1 = new Book(author, bookYear, pageCount, bookTitle);
                            catalogItems.add(book1);
                            break;
                        case 3:
                            System.out.println("Please enter the artist, year, track count, and title" +
                                    " pressing enter after each.");
                            String artist = scanner.nextLine();
                            int albumYear = scanner.nextInt();
                            scanner.nextLine();//clear buffer
                            int trackCount = scanner.nextInt();
                            scanner.nextLine();//clear buffer
                            String albumTitle = scanner.nextLine();
                            Album album1 = new Album(artist, albumYear, trackCount, albumTitle);
                            catalogItems.add(album1);
                            break;

                    }//end mediaChoice Switch
                    break;
                //Saves catalog to the CSV file.
                case 3:
                    mediaParser.saveToCSV(catalogItems, filenameCSV);
                    System.out.println("Catalog saved to CSV.");
                    break;
                //Exports the catalog to a binary file
                case 4:
                    mediaParser.saveToBinary(catalogItems, filenameBIN);
                    System.out.println("Catalog exported.");
                    break;
            }// end of menu
        }
    }
}
