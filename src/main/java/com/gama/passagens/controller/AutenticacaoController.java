package com.gama.passagens.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.passagens.model.Cliente;
import com.gama.passagens.model.Login;
import com.gama.passagens.security.JwtTokenProvider;
import com.gama.passagens.service.ClienteService;

@RestController
@RequestMapping("/")
public class AutenticacaoController {
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider jwtTokenUtil;
	
	@Autowired
	private ClienteService service;
	
	@PostMapping("/signin")
	public void signin(@RequestBody Cliente cliente) {
		service.save(cliente);
	}
	    
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Login login) {
		
		final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		login.getEmail(),
                		login.getSenha()
                )
        );
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
        //JwtCredencial credencial= new JwtCredencial();
        
		
		return ResponseEntity.ok(token);
		
		/*
		credencial.setLogin(login.getUsername());
        credencial.setToken(token);
        authentication.getAuthorities().forEach(a -> {
        	if(a.getAuthority().endsWith("MENU"))
        		credencial.getMenus().add(a.getAuthority());
		});
       
        */
        
	}
}
