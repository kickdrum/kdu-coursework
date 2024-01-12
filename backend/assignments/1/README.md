# Crypto Trading System


## Test Cases

The following test cases are included:

- testParseCSV: Validates CSV file parsing
- testConcurrentTransactions: Tests concurrent execution
- testConcurrentTransactions1: Tests concurrent execution with different input
- testConcurrentTransactionsMediumFile: Tests concurrent execution with medium file
- testConcurrentTransactionsLargeFile: Tests concurrent execution with large file
- testExecuteTransactionImplementsRunnable: Confirms ExecuteTransaction implements Runnable

Detailed JavaDoc comments are included with each test case.

The tests utilize pre-populated test data and assertions to validate the system functionality. 
Different input data sets are used to ensure robust testing.

## Necessary files and functions
Your src/main/java should have the following files:
- `Main.java` - which is the starting point of the program
- `ExecuteTransaction.java` - which is the main class which executes each type of crypto transaction and implements the Runnable interface

## executeTransactions function in Main.java

Main class should have a function named `executeTransactions` which takes below input and executes the transactions
from the incoming transaction data JSON files. This function needs to be called in the `main` function to execute the
incoming transactions and should use ExecuteTransaction class for processing each transaction.
- Definition - `public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch) {}`

### Input Format

- jsonTransactions: [JsonNode] containing array of transactions
- latch: [CountDownLatch] to synchronize thread execution

### Output Format

None

### Latch Semantics
Read:
[https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CountDownLatch.html ]
[https://www.baeldung.com/java-countdown-latch ]


The latch parameter is used to control concurrent execution of transactions across multiple threads.

- A countdown latch initialized with number of threads is passed to executeTransactions.

- Each transaction thread calls latch.countDown() after completion.

- The main thread calls latch.await() to wait for all transactions threads to finish.

- This ensures concurrent execution with synchronization at the end.


## Running Tests

The tests are run using JUnit and can be executed from an IDE like IntelliJ IDEA directly or via `mvn clean install`.
