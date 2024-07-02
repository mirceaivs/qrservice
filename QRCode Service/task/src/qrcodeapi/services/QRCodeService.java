package qrcodeapi.services;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.image.BufferedImage;

public interface QRCodeService {
    BufferedImage createQRCodeToBufferedImage(String contents, int size, String errorCorrectionLevel);
    ErrorCorrectionLevel getCorrectionLevel(String level);
}
