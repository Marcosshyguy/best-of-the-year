package org.lessons.bestoftheyear.controllers;

import org.lessons.bestoftheyear.Movie;
import org.lessons.bestoftheyear.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class BestOfTheYearController {

    @GetMapping
    public String showGreetings(Model model, @RequestParam(name = "personalName")String personalName){
        model.addAttribute("myName", personalName);
        return "greeting";
    }

    @GetMapping("/movies")
    public String showMovies(Model model){
        String list = "";
        ArrayList<Song> bestMovie = getBestSongs();
        for (Movie s : bestMovie){
            list += s.getTitle() + "\n";
        }
        model.addAttribute("movie", list);
        return "movies";
    }

    @GetMapping("/songs")
    public String showSongs(Model model){
        String list = "";
        ArrayList<Song> bestSongs = getBestSongs();
        for (Song s : bestSongs){
            list += s.getTitle() + "\n";
        }
        model.addAttribute("song", list);
        return "songs";
    }

    private ArrayList<Movie> getBestMovies(){
        ArrayList<Movie>  movies = new ArrayList<>();
        movies.add(new Movie("Alakazam"));
        movies.add(new Movie("G.I.GIO"));
        return movies;
    }

    private ArrayList<Song> getBestSongs(){
        ArrayList<Song>  songs = new ArrayList<>();
        songs.add(new Song("Stand by me"));
        songs.add(new Song("Foot Loose"));
        return songs;
    }



}
