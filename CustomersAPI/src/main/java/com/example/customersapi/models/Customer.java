package com.example.customersapi.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "The \"full_name\" is required.")
    @Size(min = 2, max = 50, message = "The \"full_name\" must between 2 and 50 characters length.")
    @Column(name = "full_name")
    private String fullName;

    @Getter
    @Setter
    @NotBlank(message = "The \"email\" is required.")
    @Email(message = "The \"email\" is not a valid email.")
    @Size(min = 2, max = 100, message = "The \"email\" must between 2 and 100 characters length.")
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Pattern(regexp = "^\\+\\d{5,13}$", message = "Please check if your phone is between 6 and 14 characters length, starts with \"+\" and contains only digits.")
    @Column(name = "phone")
    private String phone;

    @Getter
    @Setter
    @Column(name = "is_active")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean isActive;
}
