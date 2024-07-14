package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Beer;
import com.faqsarg.lombok.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

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
    public Optional<Beer> getBeerById(UUID id) {
        return Optional.of(this.beerMap.get(id));
    }

    @Override
    public Beer saveNewBeer(Beer beer) {

        Beer savedBeer = Beer.builder()
                .id(UUID.randomUUID())
                .beerName(beer.getBeerName())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .version(beer.getVersion())
                .updateDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .quantityOnHand(beer.getQuantityOnHand())
                .beerStyle(beer.getBeerStyle())
                .build();

        this.beerMap.put(savedBeer.getId(), savedBeer);

        return savedBeer;
    }

    @Override
    public void updateBeerById(UUID beerId, Beer beer) {
        Beer b = beerMap.get(beerId);
        b.setBeerName(beer.getBeerName());
        b.setBeerStyle(beer.getBeerStyle());
        b.setUpc(beer.getUpc());
        b.setPrice(beer.getPrice());
        b.setQuantityOnHand(beer.getQuantityOnHand());
        b.setUpdateDate(LocalDateTime.now());
    }

    @Override
    public void deleteById(UUID id) {
        beerMap.remove(id);
    }

    @Override
    public void patchById(UUID id, Beer beer) {
        Beer existing = beerMap.get(id);

        if (beer.getBeerStyle() != null) {
            existing.setBeerStyle(beer.getBeerStyle());
        }

        if (StringUtils.hasText(beer.getBeerName())) {
            existing.setBeerName(beer.getBeerName());
        }

        if (beer.getPrice() != null) {
            existing.setPrice(beer.getPrice());
        }

        if (beer.getQuantityOnHand() != null) {
            existing.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            existing.setUpc(beer.getUpc());
        }
    }
}
