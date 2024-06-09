package roomescape.reservation.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import roomescape.reservation.domain.Reservation;

public record MemberReservationResponse(
        Long reservationId,
        String theme,
        LocalDate date,
        LocalTime time,
        String status,
        String paymentKey,
        String orderId,
        Long amount) {

    public MemberReservationResponse(Reservation reservation) {
        this(reservation.getId(),
                reservation.getTheme().getName(),
                reservation.getDate(),
                reservation.getTime().getStartAt(),
                reservation.getStatus().getValue(),
                null,
                null,
                null
        );
    }

    public MemberReservationResponse(Long reservationId,
                                     String theme,
                                     LocalDate date,
                                     LocalTime time,
                                     String status) {
        this(reservationId,
                theme,
                date,
                time,
                status,
                null,
                null,
                null
        );
    }

    public MemberReservationResponse(Long reservationId,
                                     String theme,
                                     LocalDate date,
                                     LocalTime time,
                                     String status,
                                     Long rank) {
        this(reservationId,
                theme,
                date,
                time,
                rank + "번째 " + status,
                null,
                null
                ,null
        );
    }
}
