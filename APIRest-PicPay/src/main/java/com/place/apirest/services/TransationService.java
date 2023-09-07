package com.place.apirest.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.place.apirest.domain.transation.Transation;
import com.place.apirest.domain.user.User;
import com.place.apirest.dto.TransationDTO;
import com.place.apirest.repositories.TransationRepository;

@Service
public class TransationService {

	@Autowired
	private TransationRepository transationRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private NotificationService notificationService;
	
	public Transation createTransation(TransationDTO transation) throws Exception {
		System.out.print("teste");
		User sender = userService.findUserById(transation.sender_id());
		User receiver = userService.findUserById(transation.receiver_id());
		
		//Valid the transation before save
		userService.validateTransation(sender, transation.value());

	
	
//		boolean isAuthorized = this.authorizeTransation(sender, transation.value());
//		if(!isAuthorized) {
//			throw new Exception("Não autorizado");	
//		}
		
		Transation newtransation = new Transation();
		newtransation.setAmount(transation.value());
		newtransation.setSender(sender);
		newtransation.setReceiver(receiver);
		newtransation.setTimestamp(LocalDateTime.now());
		
		//Subtract balance from sender
		System.out.print(sender.getBalance());
		
		sender.setBalance(sender.getBalance().subtract(transation.value()));
		//Add balance from receiver
		receiver.setBalance(receiver.getBalance().add(transation.value()));
		
		//Save
		transationRepository.save(newtransation);
		userService.saveUser(sender);
		userService.saveUser(receiver);
		
		this.notificationService.sendNotification(sender, "Transação realizada com sucess!");
		this.notificationService.sendNotification(receiver, "Recebeu "+ transation.value());
		
		return newtransation;
	}
	
	public boolean authorizeTransation(User sender, BigDecimal value) {
		ResponseEntity<Map>	authorizationResponse= restTemplate.getForEntity("https://run.mocky.io/v3/8fafdd68-a090-496f-8c9a-3442cf30dae6", Map.class);
//			if(authorizationResponse.getStatusCode() == HttpStatus.OK && authorizationResponse.getBody().get("message") == "Autorizado") {
		if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
				return true;
			}
			else  return false;
	}
	
}
