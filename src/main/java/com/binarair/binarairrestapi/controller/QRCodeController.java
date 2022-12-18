package com.binarair.binarairrestapi.controller;

import com.binarair.binarairrestapi.service.QRcodeGeneratorService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping("/api/v1/")
public class QRCodeController {
    private final QRcodeGeneratorService qRcodeGeneratorService;
    @Autowired
    public QRCodeController(QRcodeGeneratorService qRcodeGeneratorService) {
        this.qRcodeGeneratorService = qRcodeGeneratorService;
    }

    @GetMapping("/qrcode")
    public String getQRCode(Model model){
        String medium="https://github.com/qyu4x/binar-air-rest-api";
        String ai ="This is Qrcode binar air";

        byte[] image = new byte[0];
        try {
            image = qRcodeGeneratorService.getQRCodeImage(medium,250,250);

            qRcodeGeneratorService.generatorQRCodeImage(ai,250,250);

        } catch (WriterException | IOException exception) {
            exception.printStackTrace();
        }
        String qrcode = Base64.getEncoder().encodeToString(image);

        model.addAttribute("medium",medium);
        model.addAttribute("github",ai);
        model.addAttribute("qrcode",qrcode);
        return qrcode;
    }
}
