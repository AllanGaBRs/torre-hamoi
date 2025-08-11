package com.hamoi.torre.repository;
import com.hamoi.torre.entity.User;
import com.hamoi.torre.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value = """
			SELECT tb_user.name AS username, tb_user.password, roles.id AS roleId, roles.authority
			FROM tb_user
			INNER JOIN tb_user_role ON tb_user.id = tb_user_role.user_id
			INNER JOIN roles ON roles.id = tb_user_role.role_id
			WHERE tb_user.name = :name
		""")
    List<UserDetailsProjection> searchUserAndRolesByEmail(String name);

	Optional<User> findByName(String name);
}
