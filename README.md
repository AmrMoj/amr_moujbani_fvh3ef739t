To run the application:
1/ on IDEA terminal run: cd .\docker
2/ run: docker-compose up
3/ run the spring boot application

To test the getStudent end point on Postman:
1/ GET http://localhost:8082/api/v1/students?className=Java&pageNumber=2&size=1
2/ GET http://localhost:8082/api/v1/students?className=Java&teacherName=David%20Gilmour&pageNumber=2&size=1
3/ GET http://localhost:8082/api/v1/students?teacherName=David%20Gilmour&pageNumber=2&size=1