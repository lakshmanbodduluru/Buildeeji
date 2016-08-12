package admi.buildeeji.bin;

/**
 * Created by Admin on 7/18/2016.
 */
public class Home {
    String name;
    int images;

    public Home() {

    }

    public Home(String name, int images) {
        this.name = name;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}

