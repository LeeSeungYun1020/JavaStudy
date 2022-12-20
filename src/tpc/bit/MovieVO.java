package tpc.bit;

public class MovieVO {
    private String title;
    private int price;
    private String author;
    private int level;
    private double time;


    public MovieVO() {
    }

    public MovieVO(String title, int price, String author, int level, double time) {
        this.title = title;
        this.price = price;
        this.author = author;
        this.level = level;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "MovieVO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", level=" + level +
                ", time=" + time +
                '}';
    }
}
