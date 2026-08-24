package com.wgu.d288.controllers;

import com.wgu.d288.services.CheckoutSrvc;
import com.wgu.d288.services.Purchase;
import com.wgu.d288.services.PurchaseResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkout")
@CrossOrigin
public class CheckoutContoller {


    private final CheckoutSrvc checkoutSrvc ;

    public CheckoutContoller(CheckoutSrvc checkoutSrvc) {
        this.checkoutSrvc = checkoutSrvc;
    }

    /*
    * controller to save the purchased plans
    * @Param purchase - this is the Purchase class contining all the items that were bought
     */

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@Valid @RequestBody Purchase purchase){
        //call the place orer method to save the items to the db
        PurchaseResponse savedPurchase = checkoutSrvc.placeOrder(purchase);
        // return the savedPurchase obj
       // PurchaseResponse savedPurchase = new PurchaseResponse();
        return savedPurchase;
    }
}
