package com.goit11.Entity.Planet;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Table(name="planet")
@Data
@Entity
@Getter
@Setter
@ToString
public class Planet {
    @Id
    @Column(name="ID", length = 100,unique = true)
    private String id;
    @Column(name="name",length = 500)
    private String name;
}
