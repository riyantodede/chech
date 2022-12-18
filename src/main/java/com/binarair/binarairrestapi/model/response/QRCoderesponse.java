package com.binarair.binarairrestapi.model.response;

import com.binarair.binarairrestapi.model.entity.QRCode;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QRCoderesponse {

    private String id;

    private String bookingCode;

    private String bookingCodeReference;

    private String passengerNameOrigin;

    private String passengerNameDestination;

    private String airportOrigin;

    private String airportDestination;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private LocalTime departureTime;

    private LocalTime arrivalTime;


    public QRCoderesponse(QRCode qrCode){
        this.id = qrCode.getId();
        this.bookingCode = qrCode.getBookingCode();
        this.bookingCodeReference = qrCode.getBookingCodeReference();
        this.passengerNameOrigin = qrCode.getPassengerNameOrigin();
        this.passengerNameDestination = qrCode.getPassengerNameDestination();
        this.airportOrigin = qrCode.getAirportOrigin();
        this.airportDestination = qrCode.getAirportDestination();

    }
}
