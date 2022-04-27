package peaksoft.car_customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.car_customer.model.UserAuth;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

    @Query("select u from UserAuth u where u.username = :username")
    public UserAuth getUserAuthByUsername(@Param("username") String username);
}