package com.crm.bch.planifio.repository.workschedule;

import com.crm.bch.planifio.repository.workschedule.entities.WorkScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleWorkScheduleDao extends JpaRepository<WorkScheduleEntity, String> {

}
