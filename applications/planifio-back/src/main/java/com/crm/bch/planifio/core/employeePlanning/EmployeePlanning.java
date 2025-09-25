package com.crm.bch.planifio.core.employeePlanning;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePlanning {

    private String id;
    private String employeeId;
    private String title;
    private int week;
    private int year;
    private Date startTime;
    private Date endTime;

}
