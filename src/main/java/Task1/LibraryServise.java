package Task1;

import java.util.List;

public class LibraryServise {
    public List<FondObject> fondObjects;

    public LibraryServise(List<FondObject> fondObjects) {
        this.fondObjects = fondObjects;
    }

    // Поиск фондов определенного автора
    public void findFondObjectByAuthor(String author) {
        List<FondObject> objectsByAuthor = fondObjects.stream()
                .filter(fondObject -> author.equals(fondObject.getAuthor()))
                .toList();
        if (!objectsByAuthor.isEmpty()) {
            System.out.printf("По автору %s в библиотеке найдены следующие фонды:\n" + objectsByAuthor + "\n", author);
        } else {
            System.out.println("В библиотеке отсутствуют фонды этого автора");
        }
    }

    // Поиск фондов, изданных после определенного года
    public void findFondObjectByYear(int year) {
        List<FondObject> objectsByYear = fondObjects.stream()
                .filter(fondObject -> fondObject.getYear() > year)
                .toList();
        if (!objectsByYear.isEmpty()) {
            System.out.printf("Фонды библиотеки, изданные после %s года:\n" + objectsByYear + "\n", year);
        } else {
            System.out.printf("В библиотеке отсутствуют фонды, изданные после %s года:\n", year);
        }
    }


    // Поиск фондов по инвентарному номеру
    public void findFondObjectByInventoryNumber(int inventoryNumber) {
        List<FondObject> objectsByInventoryNumber = fondObjects.stream()
                .filter(fondObject -> fondObject.getInventoryNumber() == inventoryNumber)
                .toList();
        if (!objectsByInventoryNumber.isEmpty()) {
            System.out.printf("В библиотеке найден фонд с инвентарным номером %s:\n" + objectsByInventoryNumber + "\n", inventoryNumber);
        } else {
            System.out.printf("В библиотеке отсутствуют фонды с инвентарным номером %s\n", inventoryNumber);
        }
    }
}