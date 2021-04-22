package Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "moviegenres", schema = "lab8", catalog = "")
public class MoviegenresEntity {
    private int id;
    private Integer genresId;
    private Integer moviesId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "genresId")
    public Integer getGenresId() {
        return genresId;
    }

    public void setGenresId(Integer genresId) {
        this.genresId = genresId;
    }

    @Basic
    @Column(name = "moviesId")
    public Integer getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(Integer moviesId) {
        this.moviesId = moviesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoviegenresEntity that = (MoviegenresEntity) o;
        return id == that.id && Objects.equals(genresId, that.genresId) && Objects.equals(moviesId, that.moviesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genresId, moviesId);
    }
}
