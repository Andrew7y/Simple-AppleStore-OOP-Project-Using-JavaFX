package Main;

public class ProductApple {
    private String name;
    private String imgSrc;
    private double price;

    public ProductApple() {

    }
    public ProductApple(String name, String imgSrc, String price) {
        this.name = name;
        this.imgSrc = imgSrc;

        String newP = price;
        newP = newP.replace("฿","");
        this.price = Double.parseDouble(newP);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
