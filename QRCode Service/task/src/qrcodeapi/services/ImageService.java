package qrcodeapi.services;

import java.awt.*;
import java.awt.image.BufferedImage;

public interface ImageService {
    BufferedImage processImage(int width, int height);
    BufferedImage getImage();
}
