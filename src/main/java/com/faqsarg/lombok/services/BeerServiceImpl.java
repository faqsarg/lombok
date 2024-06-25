package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Beer;
import com.faqsarg.lombok.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("getBeerById function from service BeerServiceImpl was called.");

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
