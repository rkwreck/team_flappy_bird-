package com.nighthawk.csa;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/ourPurpose")
    public String ourPurpose(Model model) {
        return "ourPurpose";
    }

    @GetMapping("/aboutus")
    public String aboutus(Model model) {
        return "aboutus";
    }

    @GetMapping("/games")
    public String games(Model model) {
        return "games";
    }

    @GetMapping("/game1")
    public String game1(Model model) {
        return "game1";
    }

    @GetMapping("/game2")
    public String game2(Model model) {
        return "game2";
    }

    @GetMapping("/game3")
    public String game3(Model model) {
        return "game3";
    }

    @GetMapping("/greetAdi")
    public String greetAdi(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greetAdi";
    }

    /**
    @GetMapping("/greetChenxin")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greetChenxin";
    }
     */

    @GetMapping("/greetChenxin")
    public String stock(@RequestParam(name="sym", required=false, defaultValue="452") String name, Model model) throws IOException, InterruptedException {
        String rapidapiurl = "https://free-to-play-games-database.p.rapidapi.com/api/game?id=" + name;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(rapidapiurl))
                .header("x-rapidapi-host", "free-to-play-games-database.p.rapidapi.com")
                .header("x-rapidapi-key", "f8edd9e91fmsh4ba8ab5c12046e4p120635jsn54ceca15e244")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var map = new ObjectMapper().readValue(response.body(), HashMap.class);

        model.addAttribute("data", map);
        model.addAttribute("game", map.get("title"));
        model.addAttribute("explain", map.get("short_description"));
        model.addAttribute("genre", map.get("genre"));
        model.addAttribute("publisher", map.get("publisher"));
        model.addAttribute("date", map.get("release_date"));

        return "greetChenxin";
    }


    @GetMapping("/greetPrisha")
    public String greetPrisha(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greetPrisha";
    }

    @GetMapping("/greetRini")
    public String greetRini(@RequestParam(name="name", required=false, defaultValue="452") String name, Model model) throws IOException, InterruptedException {
        /*String rapidapiurl = "https://rapidapi.com/brianiswu/api/genius/" + name;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://genius.p.rapidapi.com/artists/16775/songs"))
                .header("x-rapidapi-host", "genius.p.rapidapi.com")
                .header("x-rapidapi-key", "1921f2f385msh8c6d68cf81b3011p18ec0ejsn3bb209316b36")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        var map = new ObjectMapper().readValue(response.body(), Hashmap.class);

        model.addAttribute("data", map);
        model.addAttribute("song title", map.get("full_title"));
        model.addAttribute("artist name", map.get("name"));
        model.addAttribute("song link", map.get("url"));
        model.addAttribute("song cover art", map.get("song_art_image_thumbnail_url")); */

        model.addAttribute("name", name);
        return "greetRini";
    }
}


