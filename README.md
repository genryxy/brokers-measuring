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
10 threads  
300 sec

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        | 348000 | 0,35  | 348000 | 0,35  |  | 
| 10       | 340000 | 3,4   | 340000 | 3,4   |  |
| 100      | 192500 | 19,25 | 191500 | 19,15 |  |
| 1000     | 27300  | 27,3  | 8500   | 8,5   |  |
| 10000    | 2770   | 27,7  | 600    | 6     | |

**Results for Artemis**  
10 threads  
300 sec

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        |  |  |  |  |  | 
| 10       |  |  |  |  |  |
| 100      |  |  |  |  |  |
| 1000     |  |  |   |  |  |
| 10000    |  |  |   |  | |
