# Run application:
Main class for running application:
com.example.logproject.LogProjectApplication

# Connection to DB:
host: http://localhost:8080/h2-ui/ \
url: jdbc:h2:mem:logdb \
username: sa \
password:

# API:
1. Function readAndSave \
Method: POST \
Endpoint: http://localhost:8080/log/read_log \
JSON: \
{ \
"path": “{path to the file}” \
}

2. Function get log by level \
Method: GET \
Endpoint: http://localhost:8080/log/get_by_loglevel/{page}/{size}/{LEVEL} \

3. Function get log by message \
Method: GET \
Endpoint: http://localhost:8080/log/message/{message} \

4. Function get log by date \
Method: get \
Endpoint: http://localhost:8080/log/get_by_datetime \
JSON: \
{ \
"startDate": "2021-01-26 19:20:34.298", \
"endDate": "2021-01-28 22:12:43.405" \
}

# JSON API for postman import:
{
"info": {
"_postman_id": "0ed336f4-9d70-45c2-a5aa-43ee061704d1",
"name": "log",
"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
"_exporter_id": "6048457"
},
"item": [
{
"name": "readAndSave",
"request": {
"method": "POST",
"header": [],
"body": {
"mode": "raw",
"raw": "{\n    \"path\": \"/Users/rayalekseev/Downloads/standard.log\" \n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/log/read_log",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"log",
"read_log"
]
}
},
"response": []
},
{
"name": "getByLogLevel",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/log/get_by_loglevel/2/3/INFO",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"log",
"get_by_loglevel",
"2",
"3",
"INFO"
]
}
},
"response": []
},
{
"name": "getByMessage",
"request": {
"method": "GET",
"header": [],
"url": {
"raw": "http://localhost:8080/log/message/restartedMain",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"log",
"message",
"restartedMain"
]
}
},
"response": []
},
{
"name": "getByDateTimeBetween",
"protocolProfileBehavior": {
"disableBodyPruning": true
},
"request": {
"method": "GET",
"header": [],
"body": {
"mode": "raw",
"raw": "{\n    \"startDate\": \"2021-01-26 19:20:34.298\",\n    \"endDate\": \"2021-01-28 22:12:43.405\"\n}",
"options": {
"raw": {
"language": "json"
}
}
},
"url": {
"raw": "http://localhost:8080/log/get_by_datetime",
"protocol": "http",
"host": [
"localhost"
],
"port": "8080",
"path": [
"log",
"get_by_datetime"
]
}
},
"response": []
}
]
}

# Optimization improvement suggestions  
1. Using reactive non-blocking API for DB, like r2dbc.
That allow to work with DB not only with one thread per connection.
Integration in Spring - Spring Data R2DBC.
2. Adding one addiional column in DB timestamp that represent log creation timestamp and add new function to API for searching. 
Add index to this column and add partions by this column. EXAMPLE: \
CREATE UNIQUE INDEX LOGS_CREATION_DATE_INDEX ON LOGS (TIMESTAMP ASC)
ALTER TABLE LOGS ADD PARTITION {generate name} VALUES LESS THAN ({choose date})

# Code improvements:
1. Adding pagination for all needed functions. Not only for "get by level"
2. Parsing log row using regular expression (not realised, not unnecessary)
3. Add tests !!!
4. 
