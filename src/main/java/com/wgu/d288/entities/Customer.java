package com.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

/*
this is the customer table
 */

@Getter
@Setter
@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    /*
    id for the table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer")
    private Long id;

    /*
    First Name
    @String
     */
    @Column(name="customer_first_name")
    private String firstName;

    /*
    Last Name
    @String
     */
    @Column(name="customer_last_name")
    private String lastName;

    /*
    Address
    @String
     */
    @Column(name="address")
    private String address;

    /*
    Postal code
    @String
    This has to be a string to handle international postal codes
     */
    @Column(name="postal_code")
    private String postal_code;

    /*
    Createion date time for the table
    @Datetime
     */
    @CreationTimestamp
    @Column(name="create_date")
    private Date create_date;

    /*
    update datetime stamp
    @Datetime
     */
    @UpdateTimestamp
    @Column(name="last_update")
    private Date last_update;

    /*
    mapping to other tables
     */
    /*
    mapping to the division table
     */
    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;

    /*
    mapping to cart table
     */
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Cart> carts;
}
