package DesignIIAssigment3;


public abstract class MediaItem {

    private String id;
    private String title;
    private String type;

    public MediaItem(String id, String title, String type){
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public void summary(){}
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
