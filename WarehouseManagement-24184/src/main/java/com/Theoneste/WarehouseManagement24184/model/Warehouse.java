package com.Theoneste.WarehouseManagement24184.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @Column
    private Integer warehouseId;
    @Column
    private String ItemeName;
    @Column
    private String Itemquantity;
    @Column
    private String Itemprice;

    public Warehouse() {
    }

    public Warehouse(Integer warehouseId, String ItemeName, String Itemquantity, String Itemprice) {
        this.warehouseId = warehouseId;
        this.ItemeName = ItemeName;
        this.Itemquantity = Itemquantity;
        this.Itemprice = Itemprice;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getItemeName() {
        return ItemeName;
    }

    public void setItemeName(String ItemeName) {
        this.ItemeName = ItemeName;
    }

    public String getItemquantity() {
        return Itemquantity;
    }

    public void setItemquantity(String Itemquantity) {
        this.Itemquantity = Itemquantity;
    }

    public String getItemprice() {
        return Itemprice;
    }

    public void setItemprice(String Itemprice) {
        this.Itemprice = Itemprice;
    }
}
