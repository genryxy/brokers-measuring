Comparative analysis of different message-brokers.

**Results for Kafka**  
10 threads  
300 sec  

| size, kb | offset |total size, gb | comment |
|----------|---------|---|---|
| 1        | 3364000 | 3,36 |  |
| 10       | 1090200 | 10,9 |  |
| 100      | 513700  | 51,37 |  | 
| 1000     | 28780   | 28,78 |  |
| 10000    |         |   | |

**Results for ActiveMQ**  
10 threads  
300 sec

| size, kb | produced | size, gb | consumed | size, gb | comment |
|----------|---------|--------|---|--------|---|
| 1        | 348000 | 0,35 | 348000 | 0,35 |  | 
| 10       | 340000 | 3,4 | 340000 | 3,4 |  |
| 100      | 192500 | 19,25 | 191500 | 19,15 |  |
| 1000     | 27300 | 27,3 | 8500  | 8,5 |  |
| 10000    | 2770 | 27,7 |  600   | 6  | |
