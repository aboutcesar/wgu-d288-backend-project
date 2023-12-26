package com.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;


/*
This class holds all the individual items in the cart
 */
@Entity
@Table(name="cart_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    /*
    ID for the table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long id;

    /*
    joins to other tables
     */
    /*
    join to the excursions table
     */
    @ManyToMany
    @JoinTable(
            name="excursion_cartitem",
            joinColumns = @JoinColumn(name="cart_item_id"),
            inverseJoinColumns = @JoinColumn(name="excursion_id")
            )
    private Set<Excursion> excursions;

    /*
    join to the cart table
     */
    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    /*
    datetime of the table
     */
    /*
    creation datetime of the table
     */
    @CreationTimestamp
    @Column(name="crete_date")
    private Date create_date;

    /*
    update time of the table
     */
    @UpdateTimestamp
    @Column(name="last_update")
    private Date last_update;
}
