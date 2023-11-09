package btm.com.core.service;

import java.util.List;
import java.util.Optional;

import btm.com.core.model.UserProfile;

public interface UserService {

	Optional<UserProfile> findEmail(String email);

	List<UserProfile> get(String email);
	
	UserProfile save(UserProfile userProfile);
	
//	boolean saveUser(UserProfile userProfile);

	List<UserProfile> authenticate(String email, String userPwd);

	void addRoleNewUser(UserProfile userProfile);

	List<UserProfile> getAdministrators();

	List<UserProfile> findUserByFullNameLike(String fullName);

	List<UserProfile> findAll();

	void delete(String email);
}
