package com.Theoneste.WarehouseManagement24184.service;

import com.Theoneste.WarehouseManagement24184.dao.WarehouseDao;
import com.Theoneste.WarehouseManagement24184.model.Warehouse;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImplementation implements WarehouseServiceInterface {
    @Autowired
    private WarehouseDao warehouseDao;
    @Override
    public Warehouse saveWarehouse(Warehouse warehouse) {
        return warehouseDao.save(warehouse);
    }

    @Override
    public List<Warehouse> findAllWarehouse() {
        return warehouseDao.findAll();
    }

    @Override
    public Warehouse findWarehouseById(Integer id) {
        Warehouse warehouse = warehouseDao.findById(id).orElse(null);
        if(warehouse == null){
            throw new ObjectNotFoundException
                    (Warehouse.class, String.valueOf(id));
        } else {
            return warehouse;
        }
    }

    @Override
    public Warehouse updateDestinationById(Integer id, String Itemprice) throws Exception {
        Warehouse warehouse = warehouseDao.findById(id).orElse(null);
        if(warehouse != null){
            warehouse.setItemprice(Itemprice);
            return warehouseDao.save(warehouse);
        } else {
            throw new ObjectNotFoundException
                    (Warehouse.class, String.valueOf(id));
        }

    }

    @Override
    public boolean deleteWarehouseById(Integer id) {
        Warehouse warehouse = warehouseDao.findById(id).orElse(null);
        if(warehouse != null){
            warehouseDao.delete(warehouse);
            return true;
        }
        return false;
    }
}
