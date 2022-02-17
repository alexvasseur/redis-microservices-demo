package io.redis.demos.services.redisom.repositories;

import com.redis.om.spring.repository.RedisDocumentRepository;
import io.redis.demos.services.redisom.domain.Mojies;


public interface MojiesRepository extends RedisDocumentRepository<Mojies, String> {

    Iterable<Mojies> findByReleaseYear(int year);

    Iterable<Mojies> findByReleaseYearBetween(int yearGT, int yearLT);

    Iterable<Mojies> search(String text);

    Iterable<Mojies> findByGenre(String genre);

    Iterable<Mojies> findByGenreAndReleaseYear(String genre, int year);
}
