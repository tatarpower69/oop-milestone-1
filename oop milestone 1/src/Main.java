import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Filmmanage manager = new Filmmanage();

        while (true) {
            System.out.println("\n=== Movie Database ===");
            System.out.println("1. Add Movie");
            System.out.println("2. View All Movies");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1: {
                    try {
                        System.out.print("Enter movie type (1 for Documentary, 2 for Action): ");
                        int movieType = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine();
                        System.out.print("Enter rating: ");
                        double rating = scanner.nextDouble();
                        scanner.nextLine();

                        if (movieType == 1) {
                            System.out.print("Enter director: ");
                            String director = scanner.nextLine();
                            manager.addFilm(new DocumentaryFilm(0, title, genre, rating, director));
                        } else if (movieType == 2) {
                            System.out.print("Enter number of action scenes: ");
                            int actionScenes = scanner.nextInt();
                            scanner.nextLine();
                            manager.addFilm(new ActionFilm(0, title, genre, rating, actionScenes));
                        } else {
                            System.out.println("Invalid movie type. Please try again.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error: Invalid input. Please try again.");
                        scanner.nextLine();
                    }
                    break;
                }
                case 2: {
                    var movies = manager.getAllMovies();
                    if (movies.isEmpty()) {
                        System.out.println("No movies found.");
                    } else {
                        for (Films movie : movies) {
                            System.out.println(movie);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Exiting...");
                    Condatabase.closeConnection();
                    return;
                }
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
