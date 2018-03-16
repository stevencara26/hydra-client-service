package com.revature.hydra.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.hydra.client.data.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
}
