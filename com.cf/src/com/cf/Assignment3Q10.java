package com.cf;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MovieDetails {
    private String movieName;
    private String actor;
    private String actress;
    private String genre;

    // getters and setters
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

class MovieDetailsList {
    private List<MovieDetails> movieList;

    public MovieDetailsList() {
        movieList = new ArrayList<>();
    }

    public void addMovie(MovieDetails movie) {
        movieList.add(movie);
    }

    public void removeMovie(String movieName) {
        movieList.removeIf(movie -> movie.getMovieName().equals(movieName));
    }

    public void removeAllMovies(List<MovieDetails> movies) {
        movieList.removeAll(movies);
    }

    public MovieDetails findMovieByMovieName(String movieName) {
        for (MovieDetails movie : movieList) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<MovieDetails> findMoviesByGenre(String genre) {
        List<MovieDetails> movies = new ArrayList<>();
        for (MovieDetails movie : movieList) {
            if (movie.getGenre().equals(genre)) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public static Comparator<MovieDetails> sortAccordingly(String sortBy) {
        Comparator<MovieDetails> comparator = null;
        switch (sortBy) {
        case "movieName":
            comparator = Comparator.comparing(MovieDetails::getMovieName);
            break;
        case "actor":
            comparator = Comparator.comparing(MovieDetails::getActor);
            break;
        case "actress":
            comparator = Comparator.comparing(MovieDetails::getActress);
            break;
        case "genre":
            comparator = Comparator.comparing(MovieDetails::getGenre);
            break;
        }
        return comparator;
    }

    public void sortMovieList(Comparator<MovieDetails> comparator) {
        movieList.sort(comparator);
    }

    public void printSortedMovieList() {
        for (MovieDetails movie : movieList) {
            System.out.println(
                    movie.getMovieName() + " " + movie.getActor() + " " + movie.getActress() + " " + movie.getGenre());
        }
    }
}

public class Assignment3Q10 {
    public static void main(String[] args) {
        MovieDetailsList movieList = new MovieDetailsList();

        // add some movies
        MovieDetails movie1 = new MovieDetails();
        movie1.setMovieName("Movie 1");
        movie1.setActor("Actor 1");
        movie1.setActress("Actress 1");
        movie1.setGenre("Genre 1");
        movieList.addMovie(movie1);

        MovieDetails movie2 = new MovieDetails();
        movie2.setMovieName("Movie 2");
        movie2.setActor("Actor 2");
        movie2.setActress("Actress 2");
        movie2.setGenre("Genre 2");
        movieList.addMovie(movie2);

        MovieDetails movie3 = new MovieDetails();
        movie3.setMovieName("Movie 3");
        movie3.setActor("Actor 3");
        movie3.setActress("Actress 3");
        movie3.setGenre("Genre 3");
        movieList.addMovie(movie3);

        // print the original movie list
        System.out.println("Original Movie List:");
        movieList.printSortedMovieList();

        // remove a movie by name
        movieList.removeMovie("Movie 2");
        System.out.println("\nMovie List after removing Movie 2:");
        movieList.printSortedMovieList();

        // remove all movies in a given list
        List<MovieDetails> moviesToRemove = new ArrayList<>();
        moviesToRemove.add(movie1);
        moviesToRemove.add(movie3);
        movieList.removeAllMovies(moviesToRemove);
        System.out.println("\nMovie List after removing Movie 1 and Movie 3:");
        movieList.printSortedMovieList();

        // add a new movie
        MovieDetails movie4 = new MovieDetails();
        movie4.setMovieName("Movie 4");
        movie4.setActor("Actor 4");
        movie4.setActress("Actress 4");
        movie4.setGenre("Genre 4");
        movieList.addMovie(movie4);
        System.out.println("\nMovie List after adding Movie 4:");
        movieList.printSortedMovieList();

        // find a movie by name
        System.out.println("\nFinding Movie 4 by name:");
        MovieDetails foundMovie = movieList.findMovieByMovieName("Movie 4");
        if (foundMovie != null) {
            System.out.println("Movie found: " + foundMovie.getMovieName() + " " + foundMovie.getActor() + " " + foundMovie.getActress() + " " + foundMovie.getGenre());
        } else {
            System.out.println("Movie not found.");
        }

        // find all movies by genre
        System.out.println("\nFinding all movies in Genre 1:");
        List<MovieDetails> foundMoviesByGenre = movieList.findMoviesByGenre("Genre 1");
        if (foundMoviesByGenre.size() > 0) {
            for (MovieDetails movie : foundMoviesByGenre) {
                System.out.println(movie.getMovieName() + " " + movie.getActor() + " " + movie.getActress() + " " + movie.getGenre());
            }
        } else {
            System.out.println("No movies found in Genre 1.");
        }

        // sort movies by various fields
        System.out.println("\nSorting movies by movie name:");
        Comparator<MovieDetails> movieNameComparator = MovieDetailsList.sortAccordingly("movieName");
        movieList.sortMovieList(movieNameComparator);
        movieList.printSortedMovieList();

     // sort movies by actor name
        System.out.println("Sorting movies by actor name:");
        Comparator<MovieDetails> actorNameComparator = MovieDetailsList.sortAccordingly("actor");
        movieList.sortMovieList(actorNameComparator);
        movieList.printSortedMovieList();

        // sort movies by actress name
        System.out.println("Sorting movies by actress name:");
        Comparator<MovieDetails> actressNameComparator = MovieDetailsList.sortAccordingly("actress");
        movieList.sortMovieList(actressNameComparator);
        movieList.printSortedMovieList();

        // sort movies by genre
        System.out.println("Sorting movies by genre:");
        Comparator<MovieDetails> genreComparator = MovieDetailsList.sortAccordingly("genre");
        movieList.sortMovieList(genreComparator);
        movieList.printSortedMovieList();
    }
}




