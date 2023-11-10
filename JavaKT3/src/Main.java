import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        FictionBook fictionBook1 = new FictionBook("Американский психопат", "Брет Истон Э.", 1991);
        FictionBook fictionBook2 = new FictionBook("Моби Дик", "Герман Мелвилл", 1851);
        NonFictionBook nonFictionBook1 = new NonFictionBook("И никого не стало", "Агата Кристи", 1924);
        NonFictionBook nonFictionBook2 = new NonFictionBook("Молчание ягнят", "Томас Харрис", 1988);

        Library library = new Library();
        library.addBook(fictionBook1);
        library.addBook(fictionBook2);
        library.addBook(nonFictionBook1);
        library.addBook(nonFictionBook2);

        try {
            library.lendBook(fictionBook1);
            fictionBook1.read();
            library.returnBook(fictionBook1);
        } catch (BookUnavailableException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Book> searchResult = library.searchByTitle("Моби Дик");
        if (!searchResult.isEmpty()) {
            Book book = searchResult.get(0);
            System.out.println("Найдена книга: " + book.getTitle() + "| Автор: " + book.getAuthor());
        }

        ArrayList<Book> fictionBooks = library.searchByGenre(Genre.FICTION);
        System.out.println("Художественные книги:");
        for (Book book : fictionBooks) {
            System.out.println(book.getTitle() + "| Автор: " + book.getAuthor());
        }

        ArrayList<Book> nonFictionBooks = library.searchByGenre(Genre.NON_FICTION);
        System.out.println("Научно-популярные книги:");
        for (Book book : nonFictionBooks) {
            System.out.println(book.getTitle() + "| Автор: " + book.getAuthor());
        }

        Book foundBook = Library.LibraryHelper.searchByTitle(library.books, "Молчание ягнят");
        if (foundBook != null) {
            System.out.println("Найдена книга: " + foundBook.getTitle() + "| Автор: " + foundBook.getAuthor());
        }
    }
}