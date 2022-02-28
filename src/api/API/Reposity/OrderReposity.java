package api.API.Reposity;

import api.API.Model.Entity.Order;
import api.API.orm.JpaRepository;

public interface OrderReposity extends JpaRepository<Order,Integer> {
}
