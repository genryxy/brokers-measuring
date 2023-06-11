Comparative analysis of different message-brokers.

**Results for Kafka**  
10 threads  
300 sec  

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        | 3120000 | 3,12 | 3120000 | 3,12 |  | 
| 10       | 840000 | 8,4   | 840000  | 8,4  |  |
| 100      | 423000 | 42,3  | 423000  | 42,3 |  |
| 1000     | 55600 | 55,6   | 26600   | 26,6 |  |
| 10000    |  |  |  |  |  |

**Results for ActiveMQ**  
Problems with connection: java.net.BindException: Address already in use: no further information  
10 threads  
300 sec

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        |  |  |  |  |  | 
| 10       |  |  |  |  |  |
| 100      |  |  |  |  |  |
| 1000     |  |  |   |  |  |
| 10000    |  |  |   |  | |

**Results for Artemis**  
10 threads  
300 sec

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        | 336000 | 0,34 | 336000 | 0,34 |  | 
| 10       | 336000 | 0,34 | 336000 | 0,34 |  |
| 100      | 125000 | 12,5 | 125000 | 12,5 | 16 connection timeout errors |
| 1000     | 24100  | 24,1 | 5100   | 5,1  |  |
| 10000    | 2450   | 24,5 | 660    | 6,6  | |

**Results for Redis**  
10 threads  
300 sec

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        |  |  |  |  |  | 
| 10       |  |  |  |  |  |
| 100      |  |  |  |  |  |
| 1000     |  |  |   |  |  |
| 10000    |  |  |   |  | |

**Results for Rabbit**  
10 threads  
300 sec

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        | 1953000 | 1,95  | 49000 | 0,05 |  | 
| 10       | 744500  | 7,45  | 99000 | 0,99 |  |
| 100      | 106500  | 10,65 | 26500 | 2,65 |  |
| 1000     | 10300   | 10,3  | 4300  | 4,3 |  |
| 10000    | 960     | 9,6   | 900   | 9 | |
