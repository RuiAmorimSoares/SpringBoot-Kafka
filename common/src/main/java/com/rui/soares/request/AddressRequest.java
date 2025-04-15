package com.rui.soares.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.ToString;

/**
 * AddressRequest class represents a request for an address.
 * It contains fields for street, city, state, and zip code.
 * This class is used to encapsulate the address information in a request.
 */
@ToString
@Getter
public class AddressRequest implements Serializable {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}