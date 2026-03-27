public class BookRecord implements DisplayableRecord {
    private String id;
    private String title;
    private String author;
    private int year;

    public BookRecord(String title, String author, int year) {

        if ((title == null) || (title.isEmpty())) {
            throw new IllegalArgumentException("Title must not be empty");
        }

        if ((author == null) || (author.isEmpty())) {
            throw new IllegalArgumentException("Author must not be empty");
        }

        if ((year < 0) || (year > 2026)) {
            throw new IllegalArgumentException("Year must be valid");
        }

        this.title = title;
        this.author = author;
        this.year = year;
        generateID();
    }
@Override
public void generateID() {
        String bookIDtitle = title.length() >= 3 ? title.substring(0, 3) : title;
        String bookIDauthor = author.length() >= 3 ? author.substring(0, 3) : author;

        String bookID = bookIDtitle + year + bookIDauthor;
    }
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void getDisplayText() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BookRecord)) {
            return false;
        }

        BookRecord book = (BookRecord) o;

        return title.equals(book.title)
                && author.equals(book.author)
                && id.equals(book.id);
    }

}
