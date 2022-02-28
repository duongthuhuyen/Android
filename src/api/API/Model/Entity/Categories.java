package api.API.Model.Entity;

import api.API.orm.Annotation.Column;
import api.API.orm.Annotation.Entity;
import api.API.orm.Annotation.Id;
@Entity(name ="categories")
public class Categories {
    @Id(name = "id",autoIncrement = true)
    private int id;
    @Column(name = "name")
    private String name;
}
