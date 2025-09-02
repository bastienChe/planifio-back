package com.crm.bch.planifio.core.employee;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String companyId;

}
