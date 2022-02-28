package api.API.Reposity;

import api.API.Model.Entity.Restaurant;
import api.API.orm.JpaRepository;

public interface RestaurantReposity extends JpaRepository<Restaurant,Integer> {
}
