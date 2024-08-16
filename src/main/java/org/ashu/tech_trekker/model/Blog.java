package org.ashu.tech_trekker.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Data
@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID  )
    private String blogId;
    private String title;
    @Lob
    private String description;
    private String banner;
}
