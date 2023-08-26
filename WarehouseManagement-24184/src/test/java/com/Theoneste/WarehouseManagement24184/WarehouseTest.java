package com.Theoneste.WarehouseManagement24184;

import com.Theoneste.WarehouseManagement24184.model.Warehouse;
import com.Theoneste.WarehouseManagement24184.service.WarehouseServiceInterface;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WarehouseTest {
    @Autowired
    private WarehouseServiceInterface warehouseServiceInterface;

    @Test
    public void testSave(){

        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseId(2);
        warehouse.setItemeName("Milk");
        warehouse.setItemquantity("50000");
        warehouse.setItemprice("300Rwf");

        Warehouse warehouse1 = warehouseServiceInterface.saveWarehouse(warehouse);
        assertNotNull(warehouse1);
    }

    @Test
    public void testFindAll(){
        List<Warehouse> warehouses = warehouseServiceInterface.findAllWarehouse();
        assertEquals(1,warehouses.size());
    }

    @Test
    public void testFindById(){
        Warehouse warehouse = warehouseServiceInterface.findWarehouseById(1);
        assertEquals("Milk",warehouse.getItemeName());

    }

    @Test
    public void testUpdateDestination() throws Exception{
        Warehouse updatedWarehouse = warehouseServiceInterface.updateDestinationById(1,"Milk");
        assertEquals("Milk",updatedWarehouse.getItemprice());

    }



    @Test
    public void testDelete() {
        boolean isDeleted = warehouseServiceInterface.deleteWarehouseById(2);
        assertTrue(isDeleted);
    }




}
