import javax.swing.*;

/**
 * Kelas yang merepresentasikan item menu kopi dengan atribut nama, harga, dan gambar.
 */
class Coffee {
    String name;
    String price;
    ImageIcon image;

    /**
     * Konstruktor untuk membuat objek {@link Coffee}.
     *
     * @param name  nama item menu kopi
     * @param price harga item menu kopi dalam format string
     * @param image objek {@link ImageIcon} yang merepresentasikan gambar item
     */
    public Coffee(String name, String price, ImageIcon image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }
}
