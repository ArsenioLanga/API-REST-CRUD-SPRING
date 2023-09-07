package com.place.apirest.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.place.apirest.domain.user.User;
import com.place.apirest.domain.user.UserType;
import com.place.apirest.dto.UserDTO;
import com.place.apirest.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void validateTransation(User sender, BigDecimal amount) throws Exception {

		//Check if the user type is legista
		if(sender.getUserType() == UserType.MERCHANT) {
			throw new Exception("O usuario legista não autorizado a realizar transações");
		}
		
		//Check if the user have amount to transfere
		if(sender.getBalance().compareTo(amount) < 0) {
			throw new Exception("O usuario não tem saldo suficiente para fazer esta transação");
		}
		
	}
	
	public User findUserById(Long id) throws Exception {
		return userRepository.findById(id).orElseThrow(()-> new Exception("Usuario inválido!"));
	}
	
	public User createUser(UserDTO data) {
		User newUser = new User(data);
		this.saveUser(newUser);
		return newUser;
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
}
