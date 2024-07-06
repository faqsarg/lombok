package com.faqsarg.lombok.services;

import com.faqsarg.lombok.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
    List<Beer> listBeers();
}
