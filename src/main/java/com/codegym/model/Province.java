package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String provinceName;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", unique = true, nullable = false)
    private Country country;

    private Long area;
    private Long population;
    private Long GDP;
    private String description;
}
