package pl.strefakursow.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.strefakursow.kurs.model.UserBaze;

@Repository
public interface UserRepository extends JpaRepository<UserBaze, Integer> {

    UserBaze getUserBazeByName(String name);
}
