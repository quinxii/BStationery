package btm.com.core.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import btm.com.core.dao.RoleDAO;
import btm.com.core.dao.UserDAO;
import btm.com.core.model.Roles;
import btm.com.core.model.UserProfile;
import btm.com.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;

	@Override
	public List<UserProfile> authenticate(String email, String userPwd) {
		return userDAO.authenticate(email, userPwd);
	}

	@Override
	public List<UserProfile> get(String email) {
		return userDAO.findByEmail(email);
	}

	@Override
	public Optional<UserProfile> findEmail(String email) {
		return userDAO.findById(email);
	}

	@Override
	public void addRoleNewUser(UserProfile userProfile) {
		Roles roles = roleDAO.findByName("Admin");
		userProfile.addRoles(roles);
		userDAO.save(userProfile).getRoles();
	}

	@Override
	public List<UserProfile> getAdministrators() {
		return userDAO.getAdministrators();
	}

	@Override
	public List<UserProfile> findAll() {
		return userDAO.findAll();
	}

	@Override
	public void delete(String email) {
		userDAO.deleteById(email);

	}

	@Override
	public List<UserProfile> findUserByFullNameLike(String fullName) {
		return userDAO.findUserByFullNameLike(fullName);
	}

	@Override
	public UserProfile save(UserProfile userProfile) {
		return userDAO.save(userProfile);
	}

//	@Override
//	public boolean saveUser(UserProfile userProfile) {
//		return userDAO.saveUser(userProfile);
//	}
}