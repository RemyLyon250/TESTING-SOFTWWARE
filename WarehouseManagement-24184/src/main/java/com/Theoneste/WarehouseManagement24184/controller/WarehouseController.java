package com.Theoneste.WarehouseManagement24184.controller;

import com.Theoneste.WarehouseManagement24184.model.Warehouse;
import com.Theoneste.WarehouseManagement24184.service.WarehouseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {

    private final WarehouseServiceInterface warehouseService;

    @Autowired
    public WarehouseController(WarehouseServiceInterface warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse savedWarehouse = warehouseService.saveWarehouse(warehouse);
        return ResponseEntity.ok(savedWarehouse);
    }

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        List<Warehouse> warehouses = warehouseService.findAllWarehouse();
        return ResponseEntity.ok(warehouses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int id) {
        Warehouse warehouse = warehouseService.findWarehouseById(id);
        return ResponseEntity.ok(warehouse);
    }

    @PutMapping("/{id}/destination")
    public ResponseEntity<Warehouse> updateWarehouseDestination(@PathVariable int id, @RequestParam String destination) throws Exception {
        Warehouse updatedWarehouse = warehouseService.updateDestinationById(id, destination);
        return ResponseEntity.ok(updatedWarehouse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable int id) {
        boolean isDeleted = warehouseService.deleteWarehouseById(id);
        if (isDeleted) {
            return ResponseEntity.ok("Warehouse deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
