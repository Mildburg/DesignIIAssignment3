package DesignIIAssigment3;

public abstract class MediaItem {

    private int id = 0;
    private String title;
    private String type;

    public void summary(){}
    public String CSVFormat(){return "";}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
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
