package sample.data;

import org.springframework.data.repository.CrudRepository;

public interface UserLoginRepository extends CrudRepository<UserLogin, Long> {
	
	 UserLogin findByEmail(String email);

}
