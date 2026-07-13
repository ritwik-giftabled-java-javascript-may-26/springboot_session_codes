package com.giftabled.springbootwithjpql.controller;

import com.giftabled.springbootwithjpql.model.Door;
import com.giftabled.springbootwithjpql.service.DoorService;
import com.giftabled.springbootwithjpql.service.DoorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoorController {
    @Autowired
    private DoorServiceImpl doorServiceImpl;

    @PostMapping("/door")
    public ResponseEntity<Door> addDoor(@RequestBody Door door){
        Door savedDoor = doorServiceImpl.addDoor(door);
        return new ResponseEntity<>(savedDoor, HttpStatus.CREATED);
    }
    @GetMapping("/door/{doorId}")
    public ResponseEntity<Door> getDoorById(@PathVariable Integer doorId){
        Door door = doorServiceImpl.getDoorById(doorId);
        return new ResponseEntity<>(door,HttpStatus.OK);

    }
    @GetMapping("/door/material/{material}")
    public ResponseEntity<List<Door>> getDoorByMaterial(@PathVariable String material){
        List<Door> doors = doorServiceImpl.getDoorsByMaterial(material);
        return new ResponseEntity<>(doors,HttpStatus.OK);
    }
    @GetMapping("/door/typeandmaterial/{doorType}/{material}")
    public ResponseEntity<List<Door>> getDoorsByTypeAndMaterial(@PathVariable String doorType,@PathVariable String material){
        List<Door> doors = doorServiceImpl.getDoorsByTypeAndMaterial(doorType,material);
        return new ResponseEntity<>(doors,HttpStatus.OK);
    }
}
