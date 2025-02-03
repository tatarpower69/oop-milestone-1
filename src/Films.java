class Films {
    private int id;
    private String title;
    private String genre;
    private double rating;

    public Films(int id, String title, String genre, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return "ID=" + id + ", Title='" + title + "', Genre='" + genre + "', Rating=" + rating;
    }
}
class DocumentaryFilm extends Films {
    private String director;

    public DocumentaryFilm(int id, String title, String genre, double rating, String director) {
        super(id, title, genre, rating);
        if (director == null) {
            throw new IllegalArgumentException("Director cannot be null");
        }
        this.director = director;
    }

    public String getDirector() { return director; }

    @Override
    public String toString() {
        return super.toString() + ", Director='" + director + "'";
    }
}

class ActionFilm extends Films {
    private int actionScenes;

    public ActionFilm(int id, String title, String genre, double rating, int actionScenes) {
        super(id, title, genre, rating);
        this.actionScenes = actionScenes;
    }

    public int getActionScenes() { return actionScenes; }

    @Override
    public String toString() {
        return super.toString() + ", Action Scenes=" + actionScenes;
    }
}
