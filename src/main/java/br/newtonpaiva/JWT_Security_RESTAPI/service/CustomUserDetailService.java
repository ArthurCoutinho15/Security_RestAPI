package br.newtonpaiva.JWT_Security_RESTAPI.service;

import br.newtonpaiva.JWT_Security_RESTAPI.model.LoginRequest;
import br.newtonpaiva.JWT_Security_RESTAPI.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private SecurityRepository securityRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginRequest user = securityRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(LoginRequest user) {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
    }
}
