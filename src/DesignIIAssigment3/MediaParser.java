package DesignIIAssigment3;

import java.io.*;
import java.util.ArrayList;

/**
 * MediaParser class to help save and load mediaItems.
 */
public class MediaParser {

    private int lastIdNum;


    public MediaParser(){
        lastIdNum = 0;
    }

    /**
     * Method that saves to a CSV file
     * @param mediaItemsCSV - arraylist of items to save.
     * @param filename - file name to save the items to.
     */
    public void saveToCSV(ArrayList<MediaItem> mediaItemsCSV, String filename){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(MediaItem m : mediaItemsCSV)
                out.write(m.CSVFormat());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Method that saves to a binary file.
     * @param mediaItemsBin - ArrayList of items to save
     * @param filename - file name to save items to.
     */
    public void saveToBinary(ArrayList<MediaItem> mediaItemsBin, String filename){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
            for(MediaItem m : mediaItemsBin){
                out.writeObject(m);
            }
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Method that loads items from a csv file.
     * @param filePath - file path to load items from.
     * @return - returns arraylist of loaded items.
     */
    public ArrayList<MediaItem> loadItemsCSV(String filePath){
        ArrayList<MediaItem> loadedItems = new ArrayList<>();
        int compareIdNum = 0;
        try(BufferedReader in = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = in.readLine()) != null){
                String[] parts = line.split(",");
                String type = parts[0];
                String id = parts[1];
                String title = parts[2];
                String creator = parts[3];
                int year = Integer.parseInt(parts[4]);
                int extraInfo = Integer.parseInt(parts[5]);

                compareIdNum = Integer.parseInt(parts[1]);


                switch (type) {
                    case "Movie":
                        Movie m = new Movie(creator, year, extraInfo, id, title, type);
                        loadedItems.add(m);
                        break;
                    case "Book":
                        Book b = new Book(creator, year, extraInfo, id, title, type);
                        loadedItems.add(b);
                        break;
                    case "Album":
                        Album a = new Album(creator, year, extraInfo, id, title, type);
                        loadedItems.add(a);
                        break;
                }
            }

            for (MediaItem m : loadedItems){
                if(Integer.parseInt(m.getId()) > lastIdNum)
                    lastIdNum = Integer.parseInt(m.getId());
            }

        }
        catch(FileNotFoundException e){
            System.out.println("File not Found!");
        }
        catch(IOException e){
            System.out.println("Error Loading files!");
            throw new RuntimeException();
        }
        return loadedItems;
    }//end loadItemsCSV()


    /**
     * Method that loads from a binary file.
     * @param filepath - filepath of the file loading items from.
     * @return - returns an arraylist of objects
     */
    public ArrayList<Object> loadItemsBin(String filepath){
        ArrayList<Object> loadedItems = new ArrayList<>();

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filepath))){
            while(in.readObject() != null){
                Object m = new Object();
                loadedItems.add(m);
            }
        }
        catch(IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return loadedItems;
    }// end loadItemsBin()

    public int getLastIdNum() {
        return lastIdNum;
    }

    public void setLastIdNum(int lastIdNum) {
        if(lastIdNum > -1)
            this.lastIdNum = lastIdNum;
    }
}//end class
