package com.goit11.Entity.Planet;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name="planet")
@Data
@Entity
@Getter
@Setter
@ToString
public class Planet {
    @Id
    @Column(name="ID", length = 100,unique = true)
    @Pattern(regexp = "[A-Z]+[0-9]+")
    private String id;
    @Column(name="name",length = 500)
    private String name;
}
