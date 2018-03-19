package dao;

import entity.PersonalData;

import java.util.List;

public interface TrainingDataDao {

    void add(PersonalData pd);

    List<PersonalData> getAll();

    void remove(PersonalData pd);

}
