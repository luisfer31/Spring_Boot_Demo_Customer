package com.example.demo.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Customer {
    @Id
    private Long id;
    @NotBlank(message = "Name must be not empty")
    private String name;
    @NotBlank(message = "Password must be not empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @NotBlank
    @Email(message = "Email must be not empty")
    private String email;

    @JsonProperty("Customer_id") // change the name of property
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @JsonIgnore // don show the propertied in json
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
