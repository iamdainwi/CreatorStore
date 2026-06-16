package org.dainwi.creatorstore.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(nullable = false, name = "customer_name")
    private String customerName;

@Column(nullable = false, name = "customer_email")
    private String customerEmail;

@Column(nullable = false)
    private String status;

@Column(nullable = false, name = "total_price")
    private BigDecimal totalPrice;

@OneToMany(mappedBy = "order")
private List<OrderItem> orderItem;

@Column(name = "created_at")
    private LocalDateTime createdAt;

@PrePersist
    public void prePersist() {
    this.createdAt = LocalDateTime.now();
}

}
