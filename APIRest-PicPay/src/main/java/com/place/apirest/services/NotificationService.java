package com.place.apirest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.place.apirest.domain.user.User;
import com.place.apirest.dto.NotificationRequest;

@Service
public class NotificationService {
	@Autowired
	private RestTemplate restTemplate;
	
	public void sendNotification(User user, String message) throws Exception {
		String email = user.getEmail();
		NotificationRequest notificationRequest = new NotificationRequest(email, message);
//		ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest, String.class);
//	
//		if(!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
//			System.out.print("Erro ao enviar a noficação");
//			throw new Exception("Serviço de notificação esta fora do ar");
//		}
		System.out.print("Transação com sucesso");
	}
}
