package io.redis.demos.services.redisom.service;

import io.redis.demos.services.redisom.domain.Mojies;
import io.redis.demos.services.redisom.repositories.MojiesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/api/1.0/redisom-service/")
@RestController
public class RestStatusController {

    @Autowired
    MojiesRepository repository;

    @GetMapping("/status")
    public Map<String,String> status() {
        Map<String,String> result = new HashMap<>();
        result.put("service", "RedisOMApplication");
        result.put("status", "started");//redisService.getState());
        result.put("version", "1.0");
        return result;
    }

    @GetMapping("/start")
    public Map<String,String> start() {
        Map<String,String> result = new HashMap<>();
        result.put("service", "RedisOMApplication");
        result.put("action", "start");
        return result;
    }

    @GetMapping("/stop")
    public Map<String,String> stop() {
        Map<String,String> result = new HashMap<>();
        result.put("service", "RedisOMApplication");
        result.put("action", "stop");
        return result;
    }

    @GetMapping("/movies/{id}")
    public Optional<Mojies> getMovieById(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @GetMapping("/search")
    public Iterable<Mojies> search(@RequestParam(name="q")String term) {
        return repository.search(term);
    }

    @GetMapping("/years/{gt}/{lt}")
    public Iterable<Mojies> findByYearBetween(@PathVariable("gt") int gt,@PathVariable("lt") int lt) {
        return repository.findByReleaseYearBetween(gt,lt);
    }

    @GetMapping("/all")
    public Page<Mojies> all(Pageable pageable) {
        //TODO sort by year by default
        return repository.findAll(pageable);
    }

    @GetMapping("/allyears/{gt}/{lt}")
    public Page<Mojies> findAllByYearBetween(Pageable pageable, @PathVariable("gt") int gt,@PathVariable("lt") int lt) {
        //TODO
        return Page.empty();
    }


    @GetMapping("/load")
    public Iterable<Mojies> load() {
        repository.deleteAll();
        for (int i = 0; i < 200; i ++) {
            Mojies m = Mojies.of(
                    "Alex de Nice - chapitre " + i,
                    2022+((int)i/2),
                    "Action",
                    "Alex rencontre enfin François après le dernier(!) confinement."
            );
            m.setPoster("https://m.media-amazon.com/images/M/MV5BMDg1OTYxYWEtNWEyYi00OWJjLWI5MjktMTI1ZWE3YjBlMGQwXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg");
            m.setRating(9.0);
            m.setVotes(1);
            repository.save(m);
        }
        return repository.findAll();
    }


/*
    @GetMapping("/stats/movies/all")
    public Map<String,Object> allStats(@RequestParam(name="sort", defaultValue="year")String orderBy) {
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> stats = redisService.getMovieByYear(orderBy, 100);
        result.put("movieByYear", stats);
        stats = redisService.getMovieByGenre("genre", 100);
        result.put("movieByGenre", stats);
        return result;
    }

    @GetMapping("/movies/genres")
    public Map<String,Object> getAllGenres() {
        Map<String,Object> result = new HashMap<>();
        result = redisService.getAllGenres();
        return result;
    }

    @GetMapping("/movies/group_by/{field}")
    public Map<String,Object> getMovieGroupBy(@PathVariable("field") String field) {
        return redisService.getMovieGroupBy(field);
    }

    @GetMapping("/movies/{id}")
    public Map<String,String> getMovieById(@PathVariable("id") String id) {
        return redisService.getMovieById(id);
    }

    @GetMapping("/actors/{id}")
    public Map<String,String> getActorById(@PathVariable("id") String id) {
        return redisService.getActorById(id);
    }

 */
}
