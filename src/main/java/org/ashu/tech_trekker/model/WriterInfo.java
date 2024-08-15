package org.ashu.tech_trekker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity //used to map with relational table
public class WriterInfo {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // for auto-increment
    private int writerId;
    private String writerName;
    private String email;
    private String password;
    private String writerProfession;
    private String profilePicture;
}
