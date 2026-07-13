package com.giftabled.springbootwithjpql.service;

import com.giftabled.springbootwithjpql.model.Door;

import java.util.List;

public interface DoorService {
    Door addDoor(Door door);
    Door getDoorById(Integer doorId);
    List<Door> getDoorsByMaterial(String material);
    List<Door> getDoorsByTypeAndMaterial(String doorType, String material);
}
