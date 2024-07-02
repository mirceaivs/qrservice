package qrcodeapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qrcodeapi.model.Image;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

@Service
public class ImageServiceImpl implements ImageService {
    private final Image image;

    @Autowired
    public ImageServiceImpl(Image image){
        this.image = image;
    }

    public BufferedImage processImage(int width, int height){
        image.createImage(width, height);
        Graphics2D g = (Graphics2D) image.getImage().getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        return image.getImage();
    }

    public BufferedImage getImage(){
        return this.image.getImage();
    }
}
