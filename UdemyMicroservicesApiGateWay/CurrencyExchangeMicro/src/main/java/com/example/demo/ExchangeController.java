package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
	
	@Autowired
	private Repository repo;
	
	@Autowired 
	private Environment envi;
	
	
	@GetMapping("corrency-exchange/{from}/change/{to}")
	public Exchange abc(@PathVariable("from") String from,@PathVariable("to") String to) {
		
		System.out.println(">> We are in the Convertion Method ::: ");
		String port = envi.getProperty("local.server.port");
		Exchange exchange = repo.findByFromAndTo(from, to);
		
		if(exchange.getId() == null) {
			throw new RuntimeException("Run Time");
		}
		exchange.setEnvironmentVariable(exchange.getEnvironmentVariable());
		exchange.setPortAddress(port);
		return exchange;
		
	}
	
}
