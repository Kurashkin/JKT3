public class FictionBook extends Book {
    public FictionBook(String title, String author, int year) {
        super(title, author, year);
    }

    @Override
    public void read() {
        System.out.println("Читаю художественную книгу: " + getTitle());
    }
}