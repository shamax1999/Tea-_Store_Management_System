package edu.icet.repository;

import edu.icet.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface itemRepository extends JpaRepository<ItemEntity, Integer> {

    List<ItemEntity> findByItemId(Integer itemId);

    List<ItemEntity> findByItemName(String itemName);

    List<ItemEntity> findByTeaType(String teaType);

}
