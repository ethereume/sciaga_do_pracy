package pl.strefakursow.kurs.services;

import org.springframework.stereotype.Service;
import pl.strefakursow.kurs.model.UserBaze;
import pl.strefakursow.kurs.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserBaze getUserBazeByName(String name){
        return userRepository.getUserBazeByName(name);
    }
}
