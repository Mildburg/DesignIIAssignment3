package DesignIIAssigment3;

public abstract class MediaItem {

    private String id;
    private String title;

    public void summary(){}

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
}//end class
