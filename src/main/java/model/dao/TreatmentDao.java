package model.dao;

import model.entity.Treatment;

import java.util.List;

public interface TreatmentDao extends GenericDao<Treatment> {
    List<Treatment> findAllTreatmentsByState(Boolean state);
}
