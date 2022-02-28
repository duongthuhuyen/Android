package api.API.Model.Entity;

import api.API.orm.Annotation.Column;
import api.API.orm.Annotation.Entity;
import api.API.orm.Annotation.Id;

@Entity(name = "restaurant")
public class Restaurant {
    @Id(name = "id",autoIncrement = true)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "idUser")
    private int idUser;
}
