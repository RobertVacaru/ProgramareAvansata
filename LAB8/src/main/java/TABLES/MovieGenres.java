package TABLES;

public class MovieGenres {
    private int id;
    private int idGenres;
    private int idMovies;

    public MovieGenres() {
    }

    public MovieGenres(int id, int idGenres, int idMovies) {
        this.id = id;
        this.idGenres = idGenres;
        this.idMovies = idMovies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGenres() {
        return idGenres;
    }

    public void setIdGenres(int idGenres) {
        this.idGenres = idGenres;
    }

    public int getIdMovies() {
        return idMovies;
    }

    public void setIdMovies(int idMovies) {
        this.idMovies = idMovies;
    }

    @Override
    public String toString() {
        return "MovieGenres{" +
                "id=" + id +
                ", idGenres=" + idGenres +
                ", idMovies=" + idMovies +
                '}';
    }
}
