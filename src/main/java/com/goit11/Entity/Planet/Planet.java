package com.goit11.Entity.Planet;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Table(name="planet")
@Data
@Entity
@Getter
@Setter
@ToString
public class Planet {
    @Id
    @Column(name="ID", length = 100,unique = true)
    @Pattern(regexp = "[A-Z0-9]+")
//    @Size(min = 4,max =10)
    private String id;
    @Column(name="name",length = 500)
    private String name;
}
