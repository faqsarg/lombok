package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<Beer> getBeerById(UUID id);
    List<Beer> listBeers();
    Beer saveNewBeer(Beer beer);
    void updateBeerById(UUID beerId, Beer beer);
    void deleteById(UUID id);
    void patchById(UUID id, Beer beer);
}
