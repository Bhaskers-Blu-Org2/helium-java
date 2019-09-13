package com.microsoft.azure.helium.app.genre;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * GenresUtils
 */
public class GenresUtils {

    public static List<Genre> getGenresFromStrings(List<String> genresStr){
        Stream<String> genresStream = StreamSupport.stream(genresStr.spliterator(), false);
        List<Genre> genres = genresStream.map(g -> new Genre(g.toLowerCase(), "0", "Genre", g)).collect(Collectors.toList());
        return genres;
    }

    public static List<String> getGenresTestCases() {
        return Arrays.asList("Animation", "Comedy", "Sci-Fi", "Thriller", "Western");
    }
}