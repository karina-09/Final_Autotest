import Task1.*;

import java.util.List;

public class main {
    public static void main(String[] args)
    {
        Book book = new Book(450001, "Толстой Л.Н.", "Война и мир", 1960);
        Book book1 = new Book(450002, "Пушкин А.С.", "Капитанская дочка", 1988);
        Book book2 = new Book(450003, "Олкотт Л.М.", "Маленькие женщины", 2021);
        book.setReading(true);
        book.findLocation();

        Magazine magazine = new Magazine(550001, "Сьюзен Голдберг", "National Geographic", 2000);
        Magazine magazine1 = new Magazine(550002, "Василевский А.В", "Новый мир", 2021);
        Magazine magazine2 = new Magazine(550003, "Чупринин С.И.", "Знамя", 2019);
        magazine.findLocation();

        Letter letter = new Letter(350001, "Пушкин А.С.", "Пушкин — Вяземскому П. А.", 1816);
        letter.setReading(true);
        letter.findLocation();

        Microfiche microfiche = new Microfiche(250001, "Герасимов И.А.", "Жизнь атома", 1995);
        microfiche.findLocation();

        List<FondObject> fondObjectList = List.of(
                book, book1, book2, magazine, magazine1, magazine2, letter, microfiche
        );

        LibraryServise libraryServise = new LibraryServise(fondObjectList);

        libraryServise.findFondObjectByAuthor("Пушкин А.С.");
        libraryServise.findFondObjectByYear(1990);
        libraryServise.findFondObjectByInventoryNumber(250001);



    }

}
