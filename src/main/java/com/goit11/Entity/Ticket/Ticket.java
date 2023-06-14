package com.goit11.Entity.Ticket;

import com.goit11.Entity.Client.Client;
import com.goit11.Entity.Planet.Planet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Table(name = "ticket")
@Entity
@Getter
@Setter
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic(optional = false)
    @Column(name = "created_at")
    @Temporal(value = TemporalType.TIMESTAMP)

    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)

    private Client client;
    @ManyToOne
    @JoinColumn(name = "from_planet_id", nullable = false)
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", nullable = false)
    private Planet toPlanet;

}

