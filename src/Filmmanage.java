import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Filmmanage {
    private final Connection connection = Condatabase.getConnection();

    public void addFilm(Films movie) {
        String sql = "INSERT INTO movies (title, genre, rating) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, movie.getTitle());
            stmt.setString(2, movie.getGenre());
            stmt.setDouble(3, movie.getRating());
            stmt.executeUpdate();
            System.out.println("Movie added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding movie: " + e.getMessage());
        }
    }

    public List<Films> getAllMovies() {
        String sql = "SELECT * FROM movies";
        List<Films> movies = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                movies.add(new Films(
                        rs.getInt("id"),              // Передаем id из базы данных
                        rs.getString("title"),        // Название фильма
                        rs.getString("genre"),        // Жанр фильма
                        rs.getDouble("rating")        // Рейтинг фильма
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving movies: " + e.getMessage());
        }
        return movies;
    }
}
