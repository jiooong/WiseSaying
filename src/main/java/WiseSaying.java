public class WiseSaying {
    int id;
    String author;
    String content;

    public WiseSaying(int id, String author, String content){
        this.id = id;
        this.author=author;
        this.content=content;
    }
    @Override
    public String toString() {
        return "WiseSaying{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
