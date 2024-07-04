package com.example.customersapi.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "created")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer created;

    @Getter
    @Setter
    @Column(name = "updated")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer updated;

    @Getter
    @Setter
    @Column(name = "full_name")
    private String fullName;

    @Getter
    @Setter
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    @Getter
    @Setter
    @Column(name = "is_active")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isActive;
}
