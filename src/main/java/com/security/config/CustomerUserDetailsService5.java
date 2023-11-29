
package com.security.config;

import com.security.entity1.UserCredential;
import com.security.repository3.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerUserDetailsService5 implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    // load user by user name from data base
    // loadUserByUserName method is there in UserDetailsService
    // UserDetailsService Is interface
    // CustomerDetails::new => username, password

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> user=userCredentialRepository.findByUsername(username);
        return user.map(CustomerDetails4::new ).orElseThrow(()-> new UsernameNotFoundException("User does not exit:" + username));
    }




}
