package api.API.Reposity;

import api.API.Model.Entity.User;
import api.API.orm.JpaRepository;

public interface UserReposity extends JpaRepository<User,Integer> {
}
