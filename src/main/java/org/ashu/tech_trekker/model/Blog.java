package org.ashu.tech_trekker.model;


import org.ashu.tech_trekker.constant.BlogCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "blog_tab")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID  )
    private String blogId;
    @NotNull
    @Column(name="blog_title")
    private String title;
    
    @Column(columnDefinition = "mediumtext")
    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull
    private BlogCategory category;
    private String banner;
}
