package com.backend.java.user.api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.java.user.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByCpf(String cpf);
	public List<User> queryByNameLike(String name);
	
}
