package Task1;

import java.util.Locale;

public class Letter extends FondObject{
    private int inventoryNumber;
    private String author;
    private String title;
    private int year;
    private boolean isReading = false;

    public Letter(int inventoryNumber, String author, String title, int year) {
        this.inventoryNumber = inventoryNumber;
        this.author = author;
        this.title = title;
        this.year = year;
    }

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

    public void setReading(boolean reading) {
        isReading = reading;
    }

    @Override
    public void findLocation() {
        if(isReading) {
            System.out.printf(Locale.getDefault(), "Письмо с инвентарным номером %s - выдано читателю\n",
                    inventoryNumber);
        } else {
            System.out.printf(Locale.getDefault(), "Письмо с инвентарным номером %s - находится в библиотечном фонде\n",
                    inventoryNumber);
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Письмо:\n\tИнвентарный номер: %s\n\tНаименование: %s\n\tАвтор: %s\n\tГод написания: %s\n",
                inventoryNumber, title, author, year);
    }
}