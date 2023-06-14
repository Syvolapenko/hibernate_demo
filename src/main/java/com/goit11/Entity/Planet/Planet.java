package com.goit11.Entity.Planet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "planet")
@Entity
@Getter
@Setter
@ToString
public class Planet {
    @Id
    @Column(name = "id", length = 100, unique = true)
    private String id;

    @Column(name = "name", length = 500)
    private String name;


}
