package com.bissallombardozzi.springbootserver.Poster;
import jakarta.persistence.*;
@Entity
@Table(name="posters")
public class Poster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "link", nullable = false, length = 1000)
    private String link;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}
