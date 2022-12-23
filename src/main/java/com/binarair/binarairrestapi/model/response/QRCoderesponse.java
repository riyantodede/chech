package com.binarair.binarairrestapi.model.response;

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

}
