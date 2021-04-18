package com.practice.kafkastreams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.kafkastreams.service.Producer;

@RestController
@RequestMapping("/api")
public class KafkaController {

	@GetMapping("/version")
	public String version() {

		return "versin #001";

	}

	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		this.producer.sendMessage(message);
	}

}
