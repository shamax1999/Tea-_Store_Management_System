package edu.icet.service;

import edu.icet.dto.TeaCollection;

import java.util.List;

public interface TeaCollectionService {
    List<TeaCollection> getTeaCollection();

    void addTeaCollection(TeaCollection teaCollection);

    void deleteById(Integer collectionId);

    List<TeaCollection> searchByCollectionId(Integer collectionId);

    List<TeaCollection> getCollectionBySupplierId(Integer supplierId);

}
