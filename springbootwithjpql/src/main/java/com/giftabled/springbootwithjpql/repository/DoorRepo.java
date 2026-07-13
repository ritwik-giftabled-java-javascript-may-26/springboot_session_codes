package com.giftabled.springbootwithjpql.repository;

import com.giftabled.springbootwithjpql.model.Door;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoorRepo extends JpaRepository<Door,Integer> {
    @Query("Select d from Door d where d.doorId = ?1")
    Door getDoorById(Integer doorId);
    @Query("Select d from Door d where d.material= ?1")
    List<Door> getDoorsByMaterial(String material);
    @Query("Select d from Door d where d.doorType= ?1 and d.material = ?2")
    List<Door> getDoorsByTypeAndMaterial(String doorType, String material);
}
