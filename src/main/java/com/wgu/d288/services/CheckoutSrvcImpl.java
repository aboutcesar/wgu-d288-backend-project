package com.wgu.d288.services;

import com.wgu.d288.dao.CartItemRepository;
import com.wgu.d288.dao.CartRepository;
import com.wgu.d288.entities.Cart;
import com.wgu.d288.entities.CartItem;
import com.wgu.d288.entities.Customer;
import com.wgu.d288.entities.StatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

public class CheckoutSrvcImpl implements CheckoutSrvc{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepo;

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase){
        // pull the cart and the customer info from the
        // purchase object
        Cart cart = purchase.getCart();
        Customer customer = purchase.getCustomer();
        Set<CartItem> cartItms = purchase.getCartItems();

        // generate a unique order number tracking number
        String orderTrackingNbr = UUID.randomUUID().toString();
        // set the order tracking number
        cart.setOrderTrackingNumber(orderTrackingNbr);
        // set the status of the order
        cart.setStatus(StatusType.ordered);
        // loop through all the cart items and add them to the cart obj
        cartItms.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
        });

        // if we have gotten this far then we need to save the data to the db
        cartRepository.save(cart);

        // now return the Purchase reponse opbject
        return new PurchaseResponse(orderTrackingNbr);
    }

    // consturctor of the class
    public CheckoutSrvcImpl(CartRepository cartRepository, CartItemRepository cartItemRepository){
        this.cartRepository = cartRepository;
        this.cartItemRepo = cartItemRepository  ;
    }

}
