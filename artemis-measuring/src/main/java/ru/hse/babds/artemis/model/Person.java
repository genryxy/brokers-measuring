package ru.hse.babds.artemis.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class Person implements Serializable {
    private String id;
    private String name;
}
