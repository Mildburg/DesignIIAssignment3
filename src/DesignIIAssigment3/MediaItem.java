package DesignIIAssigment3;

/**
 * Abstract MediaItem class.
 */
public abstract class MediaItem {

    /**
     * Standard String variables for the ID, title, and type of media.
     */
    private String id;
    private String title;
    private String type;

    /**
     *
     * @param id - id of the media item.
     * @param title - title of the media item
     * @param type - what type of media it is (subclass)
     */
    public MediaItem(String id, String title, String type){
        this.id = id;
        this.title = title;
        this.type = type;
    }

    /**
     * Abstract summary class, will be overridden for each subclasses' summaries.
     */
    public void summary(){}

    /**
     * Method that outputs a string in CSV format to save to the CSV file.
     * @return - returns empty string, overridden in subclasses.
     */
    public String CSVFormat(){return "";}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!id.isEmpty())
            this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(!title.isEmpty())
            this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(!type.isEmpty())
            this.type = type;
    }
}//end class
