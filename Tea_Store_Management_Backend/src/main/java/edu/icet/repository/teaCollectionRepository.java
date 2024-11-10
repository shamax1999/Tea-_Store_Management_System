package edu.icet.repository;

import edu.icet.entity.TeaCollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface teaCollectionRepository extends JpaRepository<TeaCollectionEntity, Integer>{

    List<TeaCollectionEntity> findByCollectionId(Integer collectionId);


    List<TeaCollectionEntity> findBySupplierId(Integer supplierId);


}
