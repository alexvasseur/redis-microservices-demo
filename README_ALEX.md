# Search query


# Search microservice

http://localhost:8085//api/1.0/search-service/search-with-pagination?q=jedi

http://localhost:8085//api/1.0/search-service//stats/movies/all

# JSON

http://localhost:8091/api/1.0/redis-service-json/load

http://localhost:8091/api/1.0/redis-service-json/movies/13

http://localhost:8090/api/1.0/redisom-service/load

http://localhost:8090/api/1.0/redisom-service/years/2022/2024

http://localhost:8090/api/1.0/redisom-service/all


docker-compose up --build app-redisom

JSON.SET "json:demo:0" $ '
{
"movie_id": 0,
"title": "Java et Redis sont sur un bateau",
"release_year": "2022",
"genre":"Action",
"plot":"Java + JSON + Redis <3",
"poster":"https://developer.redis.com/howtos/redisjson/using-java/",
"rating":9.0,
"votes":999
}'


{
title: "Last Man Standing",
"release_year": "3011",
"genre": "Comedy",
"movie_id": 352,
"poster": "https://m.media-amazon.com/images/M/MV5BMDg1OTYxYWEtNWEyYi00OWJjLWI5MjktMTI1ZWE3YjBlMGQwXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg",
"plot": "A married father of three tries to maintain his manliness in a world increasingly dominated by women.",
"rating": 7.599999904632568,
"votes": 27589
}
'



{
"title": "Last Man Standing",
"release_year": "3011",
"genre": "Comedy",
"movie_id": 352,
"poster": "https://m.media-amazon.com/images/M/MV5BMDg1OTYxYWEtNWEyYi00OWJjLWI5MjktMTI1ZWE3YjBlMGQwXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_SX300.jpg",
"plot": "A married father of three tries to maintain his manliness in a world increasingly dominated by women.",
"rating": 7.599999904632568,
"votes": 27589
}