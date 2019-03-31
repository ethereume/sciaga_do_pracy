package pl.strefakursow.kurs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.strefakursow.kurs.model.UserBaze;
import pl.strefakursow.kurs.services.UserService;
import java.util.Arrays;


@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserService service;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserBaze userBaze = service.getUserBazeByName(s);
        GrantedAuthority authority = new SimpleGrantedAuthority(userBaze.getRole());
        return new User(userBaze.getName(),userBaze.getPassword(), Arrays.asList(authority));
    }
}
