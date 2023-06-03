package ru.hse.babds.active.model;

import java.io.Serializable;
import lombok.Data;

/**
 * The type Employee.
 */
@Data
public class Employee implements Serializable {
    private String id;
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
}
