package qrcodeapi.services;

import java.awt.image.BufferedImage;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Component
public class QRCodeServiceImpl implements QRCodeService{

    private final QRCodeWriter writer = new QRCodeWriter();


    public BufferedImage createQRCodeToBufferedImage(String contents, int size, String errorCorrectionLevel) {
        ErrorCorrectionLevel errorLevel = getCorrectionLevel(errorCorrectionLevel);
        Map<EncodeHintType, ?> hints = Map.of(EncodeHintType.ERROR_CORRECTION, errorLevel);
        try {
            BitMatrix bitMatrix = writer.encode(contents, BarcodeFormat.QR_CODE, size, size, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {

            return null;
            }

    }

    public ErrorCorrectionLevel getCorrectionLevel(String level){
        return switch (level.toLowerCase()) {
            case "l" -> ErrorCorrectionLevel.L;
            case "m" -> ErrorCorrectionLevel.M;
            case "q" -> ErrorCorrectionLevel.Q;
            case "h" -> ErrorCorrectionLevel.H;
            default -> null;
        };
    }
}
