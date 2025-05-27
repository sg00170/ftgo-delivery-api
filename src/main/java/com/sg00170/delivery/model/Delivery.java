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
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short status;
    @Column(name = "scheduled_pick_up_time")
    private LocalDateTime scheduledPickUpTime;
    @Column(name = "scheduled_delivery_time")
    private LocalDateTime scheduledDeliveryTime;
}
