package api.API.Reposity;

import api.API.Model.Entity.Categories;
import api.API.orm.JpaRepository;

public interface CategoriesReposity extends JpaRepository<Categories,Integer> {
}
