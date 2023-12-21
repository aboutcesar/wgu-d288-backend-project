package com.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    /*
    * this is the ID for the table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    private Long id;

    /*
    Strings for the table
     */
    /*
    number to track the order
     */
    @Column(name="order_tracking number")
    private String orderTrackingNumber;

    /*
    Big decimals for the table
     */
    /*
    price of the package
     */
    @Column(name="order_tracking_number")
    private BigDecimal package_price;

    /*
    int fields for the table
     */
    /*
    number of people in the party
     */
    @Column(name="party_size")
    private int party_size;

    /*
    enums of the table
     */
    /*
    status of the order
     */
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private StatusType status;

    /*
    date and datetime fields
     */
    /*
    create_date field.  dateTime field
     */
    @CreationTimestamp
    @Column(name="create_date")
    private Date create_date;

    /*
    this is the datetime the record was updated
     */
    @UpdateTimestamp
    @Column(name="last_update")
    private Date last_update;

    /*
    relationships to this table
     */
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<CartItem> cartItem = new HashSet<>();

    public void add(CartItem cartItem){
        this.cartItem.add(cartItem);
    }

    
}
