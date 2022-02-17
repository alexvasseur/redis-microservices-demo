package io.redis.demos.services.redisom.domain;

import com.redis.om.spring.annotations.*;
import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "mojies")
public class Mojies {
    @Id
    private String movieId;

    @NonNull
    @Searchable(weight = 5.0)
    private String title;

    @NonNull
    @NumericIndexed(sortable = true, fieldName = "release_year")
    private int releaseYear;

    @NonNull
    @TagIndexed(separator = ",")
    private String genre;

    private String poster;

    @NonNull
    @Searchable(sortable = true, weight = 1.0)
    private String plot;

    @NumericIndexed(sortable = true)
    private double rating;

    @NumericIndexed(sortable = true)
    private int votes;
}
