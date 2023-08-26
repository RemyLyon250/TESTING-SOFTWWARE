package com.Theoneste.WarehouseManagement24184.service;

import com.Theoneste.WarehouseManagement24184.model.Warehouse;

import java.util.List;

public interface WarehouseServiceInterface {

    Warehouse saveWarehouse(Warehouse warehouse);
    List<Warehouse> findAllWarehouse();
    Warehouse findWarehouseById(Integer id);
    Warehouse updateDestinationById
            (Integer id, String destination)
            throws Exception;
    boolean deleteWarehouseById(Integer id);
}
