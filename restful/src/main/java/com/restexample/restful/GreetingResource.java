package com.restexample.restful;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingResource {

	private static final String template = "Hello, %s";
	private final AtomicLong id = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(id.getAndIncrement(), String.format(template, name));
	}

}
