package api.API.Model.Entity;

import api.API.orm.Annotation.Column;
import api.API.orm.Annotation.Entity;
import api.API.orm.Annotation.Id;

import java.util.Date;

@Entity(name = "comment")
public class Comment {
    @Id(name = "id",autoIncrement = true)
    private int id;
    @Column(name = "idfoodNews")
    private int idfoodNew;
    @Column(name = "idUser")
    private int idUser;
    @Column(name = "content")
    private String content;
    @Column(name = "dateCreat")
    private Date dateCreat;
}
