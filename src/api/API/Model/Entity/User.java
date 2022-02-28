package api.API.Model.Entity;

import api.API.orm.Annotation.Column;
import api.API.orm.Annotation.Entity;
import api.API.orm.Annotation.Id;

import java.util.Date;

@Entity(name = "user")
public class User {
    @Id(name = "id",autoIncrement = true)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "created_date")
    private Date created_date;
    @Column(name = "created_by")
    private String created_by;
    @Column(name = "modified_date")
    private Date modified_date;
    @Column(name = "modified_by")
    private String modified_by;
    @Column(name = "idRole")
    private int idRole;
}
