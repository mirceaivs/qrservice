package qrcodeapi.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import java.awt.image.BufferedImage;

@Component
public class Image {
    private BufferedImage image;
    private int width;
    private int height;

    public void createImage(int width, int height){
        this.width = width;
        this.height = height;
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public BufferedImage getImage(){
        return image;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }


}
