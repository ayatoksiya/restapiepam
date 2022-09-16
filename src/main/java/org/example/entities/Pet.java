package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.LinkedList;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Pet {
    private int id;
    private HashMap category;
    private String name;
    private LinkedList photoUrls;
    private String status;
    private String tags;
}
