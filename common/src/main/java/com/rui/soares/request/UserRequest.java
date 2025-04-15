package com.rui.soares.request;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * UserRequest class represents a request for user information.
 * It contains fields for first name, last name, email, NIF, CC, and an address request.
 * This class is used to encapsulate the user information in a request.
 */
@ToString
@Getter
public class UserRequest implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private int nif;
    private String cc;
    private AddressRequest addressRequest;
}