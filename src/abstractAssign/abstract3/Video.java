package abstractAssign.abstract3;

public class Video extends Content{
  private String genre;

  public Video(String title, String genre) {
    super(title);
    this.genre = genre;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public void totalPrice() {
    int price = switch (this.genre) {
      case "new" -> 2000;
      case "comic" -> 1500;
      case "child" -> 1000;
      default -> 500;
    };
    this.setPrice(price);
  }
}
