package com.binarair.binarairrestapi.service;

import com.binarair.binarairrestapi.model.entity.QRCode;
import com.binarair.binarairrestapi.model.response.QRCoderesponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QRCodeService {
    List<QRCode> getAllQRCode();

    List<QRCode> findQRCodeWithSorting(String field);

    Page<QRCode> findQRCodeWithPegination(int offset, int pageSize);

    Page<QRCoderesponse> findQRCodeWithPaginationAndSorting(int offset, int pageSize, String field);
    Page<QRCoderesponse> findQRCodeWithPaginationFilterByGenre(String field, Pageable pageable);
}
