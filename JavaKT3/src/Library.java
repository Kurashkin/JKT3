import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void lendBook(Book book) throws BookUnavailableException {
        if (books.contains(book)) {
            books.remove(book);
        } else {
            throw new BookUnavailableException("Данная книга недоступна.");
        }
    }

    public void returnBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }

        return result;
    }

    public ArrayList<Book> searchByGenre(Genre genre) {
        ArrayList<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book instanceof FictionBook && genre == Genre.FICTION) {
                result.add(book);
            } else if (book instanceof NonFictionBook && genre == Genre.NON_FICTION) {
                result.add(book);
            }
        }

        return result;
    }
    public static class LibraryHelper {
        public static Book searchByTitle(ArrayList<Book> books, String title) {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    return book;
                }
            }

            return null;
        }
    }
}
