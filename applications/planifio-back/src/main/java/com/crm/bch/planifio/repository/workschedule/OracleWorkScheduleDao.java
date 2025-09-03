package com.crm.bch.planifio.repository.workschedule;

import com.crm.bch.planifio.repository.workschedule.entities.WorkScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OracleWorkScheduleDao extends JpaRepository<WorkScheduleEntity, String> {

    @Query("SELECT w FROM WorkScheduleEntity w WHERE w.weekNumber = :weekNum AND w.yearNumber = :yearNumber")
    List<WorkScheduleEntity> getWorkScheduleByWeekNum(
            @Param("yearNumber") int yearNumber,
            @Param("weekNum") int weekNum);
}
