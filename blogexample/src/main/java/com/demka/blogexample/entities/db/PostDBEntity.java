package com.demka.blogexample.entities.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@Table(name = "posts")
public class PostDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String slug;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private UserDBEntity authorPost;

    @JsonBackReference(value="post")
    @OneToMany(mappedBy = "post")
    private List<CommentDBEntity> comments;

    @JsonBackReference(value="posts_tags")
    @ManyToMany
    @JoinTable(
            name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<TagDBEntity> tags;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime dateTime;
    private String text;
    private String title;

    @JsonBackReference(value="likes")
    @ManyToMany
    @JoinTable(
            name = "likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<UserDBEntity> likes;

    @Override
    public String toString() {
        return "PostDBEntity{" +
                "id=" + id +
                ", slug='" + slug + '\'' +
                ", authorPost=" + authorPost +
                ", comments=" + comments +
                ", tags=" + tags +
                ", dateTime=" + dateTime +
                ", text='" + text + '\'' +
                ", title='" + title + '\'' +
                ", likes=" + likes +
                '}';
    }
}