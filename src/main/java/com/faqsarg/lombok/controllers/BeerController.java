package com.faqsarg.lombok.controllers;

import com.faqsarg.lombok.model.Beer;
import com.faqsarg.lombok.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {

    private final BeerService beerService;

    public Beer getBeerById(UUID id) {

        log.debug("getBeerById function from controller BeerController was called.");

        return beerService.getBeerById(id);
    }
}
