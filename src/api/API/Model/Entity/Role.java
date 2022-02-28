package api.API.Model.Entity;

import api.API.orm.Annotation.Column;
import api.API.orm.Annotation.Entity;
import api.API.orm.Annotation.Id;

@Entity(name = "role")
public class Role {
    @Id(name = "id")
    private int id;
    @Column(name = "nameRole")
    private String nameRole;
}
