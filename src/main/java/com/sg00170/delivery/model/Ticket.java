package com.sg00170.delivery.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short status;
    @Column(name = "requested_delivery_time")
    private LocalDateTime requestedDeliveryTime;
    @Column(name = "prepared_by_time")
    private LocalDateTime preparedByTime;
}
