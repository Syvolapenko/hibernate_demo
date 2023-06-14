package com.goit11.Entity.Client;

import com.goit11.Entity.Ticket.Ticket;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "client")
@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", length = 200)
    private String name;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Ticket> tickets = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
