package com.demka.blogexample.entities.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "tags")
public class TagDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String slug;

    @JsonBackReference
    @ManyToMany(mappedBy = "tags")
    private Set<PostDBEntity> posts;

    public TagDBEntity(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }
}