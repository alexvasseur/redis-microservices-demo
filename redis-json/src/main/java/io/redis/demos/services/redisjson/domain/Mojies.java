package io.redis.demos.services.redisjson.domain;

import lombok.*;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Mojies {
    private String movieId;

    @NonNull
    private String title;

    @NonNull
    private int releaseYear;

    @NonNull
    private String genre;

    private String poster;

    @NonNull
    private String plot;

    private double rating;

    private int votes;
}
