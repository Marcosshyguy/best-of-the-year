package org.lessons.bestoftheyear.controllers;

import jakarta.websocket.server.PathParam;
import org.lessons.bestoftheyear.Movie;
import org.lessons.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    @GetMapping
    public String showGreetings(Model model){
        model.addAttribute("myName", "Marco");
        return "greeting";
    }

    @GetMapping("/movies")
    public String showMovies(Model model){

        model.addAttribute("movies", getBestMovies());
        return "movies";
    }

    @GetMapping("movies/{id}")
    public String showMovie(@PathVariable("id") int id, Model model){
        ArrayList<Movie> movies = getBestMovies();

        Optional<Movie> movieDetail = movies.stream().filter(m->m.getId() == id).findFirst();

        if (movieDetail.isEmpty()){
            return "redirect:/movies";
        }else{
            model.addAttribute("movieDetail", movieDetail.get().getTitle());
        }

        return "movie";
    }

    @GetMapping("/songs")
    public String showSongs(Model model){
        model.addAttribute("songs", getBestSongs());
        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String showSong(@PathVariable("id") int id, Model model){
        ArrayList<Song> bestSongs = getBestSongs();

            model.addAttribute("songDetail", getSongDetail(id));

        return "song";

    }


    private ArrayList<Movie> getBestMovies(){
        ArrayList<Movie>  movies = new ArrayList<>();
        movies.add(new Movie("Alakazam", 1));
        movies.add(new Movie("G.I.GIO",2 ));
        return movies;
    }

    private ArrayList<Song> getBestSongs(){
        ArrayList<Song>  songs = new ArrayList<>();
        songs.add(new Song("Stand by me",1));
        songs.add(new Song("Foot Loose",2));
        return songs;
    }

    private String getSongDetail(int id){
        ArrayList<Song>  songs = getBestSongs();
        String detail = "";
        for (Song s :songs){
            if (s.getId() == id){
                detail = s.getTitle();
            }
        }
        return detail;
    }

    private String getMusicDetail(int id){
        ArrayList<Movie>  movies = getBestMovies();
        String detail = "";
        for (Movie m : movies){
            if (m.getId() == id){
                detail = m.getTitle();
            }
        }
        return detail;
    }



}
