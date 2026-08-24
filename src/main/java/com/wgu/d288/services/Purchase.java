package com.wgu.d288.services;

import com.wgu.d288.entities.CartItem;
import com.wgu.d288.entities.Cart;
import com.wgu.d288.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class Purchase {

    private Cart cart;

    private Set<CartItem> cartItem;

    private Customer customer;
}
