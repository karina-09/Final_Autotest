package Task1;

public abstract class FondObject {
    public int inventoryNumber;
    public String author;
    public String title;
    public int year;
    public boolean isReading;
    public int getInventoryNumber() {
        return inventoryNumber;
    }


    public String getAuthor() {
        return author;
    }


    public String getTitle() {
        return title;
    }


    public int getYear() {
        return year;
    }
    public abstract void findLocation();

}
