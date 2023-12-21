package com.wgu.d288.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

/*
this is Country table
 */

@Entity
@Table(name ="countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    /*
    ID of the table
    @Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    /*
    name of the country
    @String
     */
    @Column(name="country")
    private String country_name;

    /*
    create date of the table
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date create_date;

    /*
    update time stamp for the table
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update")
    private Date last_update;

    /*
    mapping to other tables
     */
    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Division> divisions;

}
