package api.API.Model.Entity;

import api.API.orm.Annotation.Column;
import api.API.orm.Annotation.Entity;
import api.API.orm.Annotation.Id;

@Entity(name = "order")
public class Order {
    @Id(name = "idOrder",autoIncrement = true)
    private int idOrder;
    @Column(name = "idUserName")
    private int idUserName;
    @Column(name = "idfoodNew")
    private int idfoodNew;
    @Column(name = "soluong")
    private int soluong;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
}
