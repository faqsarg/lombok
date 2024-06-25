package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Beer;
import com.faqsarg.lombok.model.BeerStyle;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BeerServiceImpl implements BeerService{
    @Override
    public Beer getBeerById(UUID id) {
        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Galaxia del gato")
                .beerStyle(BeerStyle.RED_ALE)
                .upc("123456")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(100)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
