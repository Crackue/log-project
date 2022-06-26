# Run application:
Main class for running application:
com.example.logproject.LogProjectApplication

# Connection to DB:
host: http://localhost:8080/h2-ui/ \
url: jdbc:h2:mem:logdb \
username: sa \
password:

# API:

Function search v1\
Method: get \
Endpoint: http://localhost:8080/log/search_v1/{page}/{size}\
JSON: \
{ \
"startDate": "2021-01-19 12:19:58.694", \
"endDate": "2021-01-25 18:20:10.397"\
}

Function search v2\
Method: get \
Endpoint: http://localhost:8080/log/search_v2/{page}/{size}\
JSON: \
{ \
"keywords": ["2021-01-19 12:19:58.694", 2021-01-25 18:20:10.397], \
"columnNames": ["datetime"]\
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
1. Parsing log row using regular expression (not realised, not unnecessary)
2. Add tests !!!

