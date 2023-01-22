package cz.mendelu.ja.xvavrina.projekt3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cz.mendelu.ja.xvavrina.projekt3.User;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
}
