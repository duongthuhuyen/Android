package api.API.Model.Entity;

import api.API.orm.Annotation.Column;
import api.API.orm.Annotation.Entity;
import api.API.orm.Annotation.Id;

import java.util.Date;

@Entity(name = "foodnews")
public class Foodnews {
    @Id(name = "id",autoIncrement = true)
    private int id;
    @Column(name = "thumbnal")
    private String thumbnal;
    @Column(name = "foodName")
    private String foodName;
    @Column(name = "idRestaurant")
    private int idRestaurant;
    @Column(name = "vote")
    private int vote;
    @Column(name = "status")
    private int status;
    @Column(name = "price")
    private double price;
    @Column(name = "sale")
    private int sale;
    @Column(name = "dateFrom")
    private Date dateFrom;
    @Column(name = "dateTo")
    private Date dateTo;
    @Column(name = "idCategory")
    private int idCategory;
}
