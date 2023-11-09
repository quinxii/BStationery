package btm.com.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import btm.com.core.model.Roles;

public interface RoleDAO extends JpaRepository<Roles, Integer> {

	@Query("SELECT r FROM Roles r WHERE r.role_name=?1")
	Roles findByName(String role_name);
}
