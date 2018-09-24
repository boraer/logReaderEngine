package org.cs.logreader.dao.repository;

import java.io.Serializable;

import org.cs.logreader.dao.entity.EventDataAlertLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventDataAlertRepository extends CrudRepository<EventDataAlertLog, Serializable> {

}
