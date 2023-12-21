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
@Table(name="vacations")
@Getter
@Setter
public class Vacation {

    /*
    ID of the table
    @Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    /*
    vacation title
    @String
     */
    @Column(name = "vacation_title")
    private String vacation_title;

    /*
    Description
    @String
     */
    @Column(name = "description")
    private String description;

    /*
    travel fail price
    @BigDecimal
     */
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;

    /*
    image url
    @String
     */
    @Column(name = "image_url")
    private String image_url;

    /*
    Creation timestamp
    @Timestamp
     */
    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;

    /*
    update timestamp for the table
    @timestamp
     */
    @UpdateTimestamp
    @Column(name = "last_update")
    private Date lastUpdate;

    /*
    mapping to other tables
     */
    /*
    map to the excursion table
     */
    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Excursion> excursions;
}
