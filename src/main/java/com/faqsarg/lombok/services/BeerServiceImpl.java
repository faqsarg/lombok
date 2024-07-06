package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Beer;
import com.faqsarg.lombok.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService{

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("galaxy cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("1234")
                .price(new BigDecimal("12.00"))
                .quantityOnHand(100)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("crank")
                .beerStyle(BeerStyle.HONEY)
                .upc("8214")
                .price(new BigDecimal("10.00"))
                .quantityOnHand(200)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("crank")
                .beerStyle(BeerStyle.HONEY)
                .upc("8214")
                .price(new BigDecimal("10.00"))
                .quantityOnHand(200)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listBeers() {
        return this.beerMap.values().stream().toList();
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("getBeerById function from service BeerServiceImpl was called.");

        return this.beerMap.get(id);
    }
}
