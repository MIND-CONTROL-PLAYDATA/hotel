package com.example.hotelk.payment.domain.entity;

import com.example.hotelk.reservation.domain.entity.Reservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private String paymentMethod;
    private Integer price;
    private String paymentStatus;
    private String transactionId;

    // Getters and Setters
}
