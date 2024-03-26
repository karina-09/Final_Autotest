package Task1;

import java.util.Locale;

public class Magazine extends FondObject{
    private int inventoryNumber;
    private String author;
    private String title;
    private int year;
    private boolean isReading = false;

    public Magazine(int inventoryNumber, String autor, String title, int year) {
        this.inventoryNumber = inventoryNumber;
        this.author = autor;
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
            System.out.printf(Locale.getDefault(), "Журнал с инвентарным номером %s - выдан читателю\n",
                    inventoryNumber);
        } else {
            System.out.printf(Locale.getDefault(), "Журнал с инвентарным номером %s - находится в библиотечном фонде\n",
                    inventoryNumber);
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Журнал:\n\tИнвентарный номер: %s\n\tНаименование: %s\n\tРедактор: %s\n\tГод издания: %s\n",
                inventoryNumber, title, author, year);
    }
}
