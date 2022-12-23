package com.binarair.binarairrestapi.service.impl;

import com.binarair.binarairrestapi.model.response.QRCoderesponse;
import com.binarair.binarairrestapi.repository.BookingRepository;
import com.binarair.binarairrestapi.repository.UserRepository;
import com.binarair.binarairrestapi.service.QRcodeGeneratorService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.jfree.util.Log;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


@Service
public class QRCodeGeneratorServiceImpl implements QRcodeGeneratorService {
    private final UserRepository userRepository;
    private final BookingRepository bookingRepository;

    public QRCodeGeneratorServiceImpl(UserRepository userRepository,
                                      BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void genereateQRCodeImage(String text, int with, int height, String filePath) throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, with, height);

        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }


    @Override
    public void generatorQRCodeImage(String text, int with, int height) {
    List<QRCoderesponse> qrCoderesponses = new ArrayList<>();
        Log.info("size {}", (Exception) qrCoderesponses);
        for (QRCoderesponse ignored : qrCoderesponses) {
            booking.getBookingDetails
        }
    }

    @Override
    public byte[] getQRCodeImage(String text, int with, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, with, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageConfig config = new MatrixToImageConfig(0xFF000002 , 0xFFFFC041);

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream, config);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }
}
