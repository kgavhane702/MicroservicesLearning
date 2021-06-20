package com.kiran.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for" + from + "and" + to);
		}

		currencyExchange.setEnvironment(port);
		return currencyExchange;
	}
}
