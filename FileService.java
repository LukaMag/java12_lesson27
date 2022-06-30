package CLASSWORK27;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path pathMovies = Paths.get("movies.json");
    private static final Gson gson = new Gson();


    public static Movies readFile() {
        String json;
        try {
            json = Files.readString(pathMovies);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return gson.fromJson(json, Movies.class);
    }


}
