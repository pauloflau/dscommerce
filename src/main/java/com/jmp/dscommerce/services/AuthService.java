package com.jmp.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmp.dscommerce.entities.User;
import com.jmp.dscommerce.services.exceptions.ForbiddenException;

@Service
public class AuthService {
	
	@Autowired
	private UserService userService;
	
	public void validateSelfOrAdmin(long userId) {
		User me = userService.authenticated();
		
		//se nao e admin e nao possui o meu id
		if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
			throw new ForbiddenException("Acesso negado");
		}
	}
}
