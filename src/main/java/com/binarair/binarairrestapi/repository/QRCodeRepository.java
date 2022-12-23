package com.binarair.binarairrestapi.repository;

import com.binarair.binarairrestapi.model.entity.Booking;
import com.google.zxing.qrcode.encoder.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QRCodeRepository extends JpaRepository<QRCode, String> {
    @Query(
            nativeQuery = true,
            value = """
                    SELECT * FROM booking bk
                    JOIN booking_detail bd on bk.id = bd.booking_unique_id
                    JOIN passenger p on bd.passenger_unique_id = p.id
                    WHERE bk.id = :bookingid"""
    )
    Booking findBookingDetailsById(@Param("bookingid") String bookingId);
}
