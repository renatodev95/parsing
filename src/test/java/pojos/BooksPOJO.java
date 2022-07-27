package pojos;

import java.time.LocalDate;

public class BooksPOJO {
    
    private String title;
    private Boolean inPrint;
    private LocalDate publishDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getInPrint() {
        return inPrint;
    }

    public void setInPrint(Boolean inPrint) {
        this.inPrint = inPrint;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
}
