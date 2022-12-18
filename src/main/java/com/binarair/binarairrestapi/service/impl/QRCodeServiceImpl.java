package com.binarair.binarairrestapi.service.impl;

import com.binarair.binarairrestapi.model.entity.QRCode;
import com.binarair.binarairrestapi.model.response.QRCoderesponse;
import com.binarair.binarairrestapi.repository.QRCodeRepository;
import com.binarair.binarairrestapi.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QRCodeServiceImpl implements QRCodeService {

    private final QRCodeRepository qrCodeRepository;
    @Autowired
    public QRCodeServiceImpl(QRCodeRepository qrCodeRepository) {
        this.qrCodeRepository = qrCodeRepository;
    }

    @PostConstruct
    private void initDB(){
        List<QRCode> qrCodes = new ArrayList<>();
        for (int i = 0; i < 200; i++){
            QRCode qrCode = QRCode.builder()
                    .id(String.format("a-%s", UUID.randomUUID()))
                    .bookingCode("")
                    .bookingCodeReference("")
                    .passengerNameOrigin("")
                    .passengerNameDestination("")
                    .airportOrigin("")
                    .airportDestination("")
                    .build();
            qrCodes.add(qrCode);
        }
        qrCodeRepository.saveAll(qrCodes);
    }

    @Override
    public List<QRCode> getAllQRCode() {
        return qrCodeRepository.findAll();
    }

    @Override
    public List<QRCode> findQRCodeWithSorting(String field) {
        return qrCodeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public Page<QRCode> findQRCodeWithPegination(int offset, int pageSize) {
        return qrCodeRepository.findAll(PageRequest.of(offset, pageSize));
    }

    @Override
    public Page<QRCoderesponse> findQRCodeWithPaginationAndSorting(int offset, int pageSize, String field) {
        Page<QRCode> page = qrCodeRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.Direction.ASC, field));
        return page.map(QRCoderesponse::new);

    }

    @Override
    public Page<QRCoderesponse> findQRCodeWithPaginationFilterByGenre(String field, Pageable pageable) {
        Page<QRCode> page = (Page<QRCode>) qrCodeRepository.findBookingDetailsById(field);
        return page.map(QRCoderesponse::new);
    }
}
