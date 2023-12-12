package ru.goryacheva.springBootSecurityApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import ru.goryacheva.springBootSecurityApp.service.PersonDetailsService;

import java.util.Collections;


public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final PersonDetailsService personDetailsService;


    public AuthenticationProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    //authenticate будет вызываться самим секьюрити и секьюрити будет передавать нам в качестве аргумента объект Authentication
    // мы введем данные в форму и секьюрити сам передаст credentials в объект Authentication
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails user = personDetailsService.loadUserByUsername(username);
        String password = authentication.getCredentials().toString();

        if(!password.equals(user.getPassword()))
            throw new BadCredentialsException("Incorrect password!!!");
        return new UsernamePasswordAuthenticationToken(user, password, Collections.emptyList());
    }

    //нужен спрингу что бы понять для какого объекта он работает
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
