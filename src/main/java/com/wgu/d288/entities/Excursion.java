package com.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {
    /*
    ID for the table
    @Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id",nullable = false, updatable = false)
    private Long excursion_id;

    /*
    Excurstion title
    @String
     */
    @Column(name = "excursion_title")
    private String excursiton_title;

    /*
    excurstion price
    @BigDecimal
     */
    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    /*
    image url
    @String
     */
    @Column(name = "image_url")
    private String image_url;

    /*
    Creation timestamp
    @Datetime
     */
    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    /*
    update timestamp
    @Datetime
     */
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    /*
    mappings to other tables
     */
    /*
    vacation map
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    /*
    map to cart items
     */
    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems;
}
