package edu.icet.service.Impl;

import edu.icet.dto.Supplier;
import edu.icet.dto.TeaCollection;
import edu.icet.entity.SupplierEntity;
import edu.icet.entity.TeaCollectionEntity;
import edu.icet.repository.supplierRepository;
import edu.icet.repository.teaCollectionRepository;
import edu.icet.service.TeaCollectionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeaCollectionServiceImpl implements TeaCollectionService {
    final teaCollectionRepository repository;
    final ModelMapper mapper;

    @Override
    public List<TeaCollection> getTeaCollection() {
        List<TeaCollection> teaCollections = new ArrayList<>();
        repository.findAll().forEach(teaCollection->{
            teaCollections.add(mapper.map(teaCollection,TeaCollection.class));
        });
        return  teaCollections;
    }

    @Override
    public void addTeaCollection(TeaCollection teaCollection) {
        repository.save(mapper.map(teaCollection, TeaCollectionEntity.class));

    }

    @Override
    public void deleteById(Integer collectionId) {
        repository.deleteById(collectionId);

    }

    @Override
    public List<TeaCollection> searchByCollectionId(Integer collectionId) {
        List<TeaCollection> teaCollectionList =new ArrayList<>();
        repository.findByCollectionId(collectionId).forEach(entity->{
            teaCollectionList.add(mapper.map(entity, TeaCollection.class));
        });
        return teaCollectionList;
    }

    @Override
    public List<TeaCollection> getCollectionBySupplierId(Integer supplierId) {
        List<TeaCollection> teaCollectionList =new ArrayList<>();
        repository.findBySupplierId(supplierId).forEach(entity->{
            teaCollectionList.add(mapper.map(entity, TeaCollection.class));
        });
        return teaCollectionList;
    }
}
