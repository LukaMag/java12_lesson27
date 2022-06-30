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
//    public static MoviesHash readFileMap() {
//        Map<Integer, MoviesHash> mapMovieDes = new HashMap<>();
//        String json;
//        try {
//            json = Files.readString(pathMovies);
//            mapMovieDes = new Gson().fromJson(jsonStr, itemsMapType);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return mapMovieDes ;
//    }

    public static String file(){
        String jsonMovies;
        try {
            jsonMovies = Files.readString(pathMovies);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonMovies;
    }
//    public static MoviesHash readFileMovie() {
//        String jsonMovies;
//        try {
//            jsonMovies = Files.readString(pathMovies);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
////        Map<String, Movie> retMap = new Gson().fromJson(
////                jsonMovies, new TypeToken<HashMap<String , Movie>>() {}.getType()
////        );
////        return retMap;
//        return gson.fromJson(jsonMovies, MoviesHash.class);
//}
}
