package btm.com.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import btm.com.core.model.UserProfile;

public interface UserDAO extends JpaRepository<UserProfile, String> {
	@Query("SELECT u FROM UserProfile u WHERE u.email =?1 and u.userPwd=?2")
	List<UserProfile> authenticate(String email, String userPwd);

	@Query("SELECT u FROM UserProfile u WHERE u.email = :email")
	public UserProfile getUserByEmail(@Param("email") String email);

	@Query("SELECT DISTINCT ar.userProfile FROM Authority ar WHERE ar.roles IN('Admin')")
	List<UserProfile> getAdministrators();

	List<UserProfile> findByEmail(String email);

	List<UserProfile> findUserByFullNameLike(String fullName);

//	boolean saveUser(UserProfile userProfile);

}
