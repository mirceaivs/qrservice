package qrcodeapi.controllers;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import qrcodeapi.model.ErrorMessage;
import qrcodeapi.services.ImageService;
import qrcodeapi.services.QRCodeService;
import qrcodeapi.services.QRCodeServiceImpl;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api")
public class QRController {

    private final ImageService imageService;
    private final ErrorMessage error;
    private final QRCodeService qrCodeService;

    @Autowired
    public QRController(ImageService imageService, ErrorMessage error, QRCodeService qrCodeService){
        this.imageService = imageService;
        this.error = error;
        this.qrCodeService = qrCodeService;
    }

    @GetMapping("/health")
    ResponseEntity<String> getHealth(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/qrcode")
    ResponseEntity<?> getQRCode(@RequestParam String contents,
                                @RequestParam(required = false, defaultValue = "250") Integer size,
                                @RequestParam(required = false, defaultValue = "png") String type,
                                @RequestParam(required = false, defaultValue = "l") String correction){

        if(contents.isEmpty() || contents.isBlank()){
            error.setError("Contents cannot be null or blank");
            System.out.println(error);
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }

        if( (size < 150) || (size > 350)){
            error.setError("Image size must be between 150 and 350 pixels");
            System.out.println(error);
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }

        ErrorCorrectionLevel level  = qrCodeService.getCorrectionLevel(correction);
        if(level == null){
            error.setError("Permitted error correction levels are L, M, Q, H");
            System.out.println(error);
            return ResponseEntity
                    .badRequest()
                    .body(error);
        }
        BufferedImage image = qrCodeService.createQRCodeToBufferedImage(contents, size, correction);

        return switch (type.toLowerCase()) {
            case "png" -> ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(image);
            case "jpeg" -> ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(image);
            case "gif" -> ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_GIF)
                    .body(image);
            default -> {
                error.setError("Only png, jpeg and gif image types are supported");
                System.out.println(error);
                yield ResponseEntity
                        .badRequest()
                        .body(error);
            }
        };



    }

}
