package com.giftabled.springbootwithjpql.service;

import com.giftabled.springbootwithjpql.model.Door;
import com.giftabled.springbootwithjpql.repository.DoorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorServiceImpl implements DoorService {

    @Autowired
    private DoorRepo doorRepo;

    @Override
    public Door addDoor(Door door) {

        return doorRepo.save(door);
    }

    @Override
    public Door getDoorById(Integer doorId) {
        return doorRepo.getDoorById(doorId);
    }

    @Override
    public List<Door> getDoorsByMaterial(String material) {
        return doorRepo.getDoorsByMaterial(material);
    }

    @Override
    public List<Door> getDoorsByTypeAndMaterial(String doorType, String material) {
        return doorRepo.getDoorsByTypeAndMaterial(doorType,material);
    }


}
