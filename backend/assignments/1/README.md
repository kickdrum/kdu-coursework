# Crypto Trading System


## Test Cases

The following test cases are included:

- testParseCSV: Validates CSV file parsing
- testGetCoinDetailsByName: Checks coin lookup by name
- testGetCoinDetailsByInvalidName: Checks invalid name lookup
- testGetCoinDetailsByCode: Checks coin lookup by code
- testGetCoinDetailsByInvalidCode: Checks invalid code lookup
- testGetTop3CoinsShouldReturnTop3Coins: Verifies getting top N coins
- testConcurrentTransactions: Tests concurrent execution
- testConcurrentTransactions1: Tests concurrent execution with different input
- testConcurrentTransactionsMediumFile: Tests concurrent execution with medium file
- testConcurrentTransactionsLargeFile: Tests concurrent execution with large file
- testExecuteTransactionImplementsRunnable: Confirms ExecuteTransaction implements Runnable

Detailed JavaDoc comments are included with each test case.

The tests utilize pre-populated test data and assertions to validate the system functionality. Different input data sets are used to ensure robust testing.

## executeTransactions

### Input Format

- jsonTransactions: JsonNode containing array of transactions
- latch: CountDownLatch to synchronize thread execution

### Output Format

None

### Latch Semantics

The latch parameter is used to control concurrent execution of transactions across multiple threads.

- A countdown latch initialized with number of threads is passed to executeTransactions.

- Each transaction thread calls latch.countDown() after completion.

- The main thread calls latch.await() to wait for all transactions threads to finish.

- This ensures concurrent execution with synchronization at the end.


## Running Tests

The tests are run using JUnit and can be executed from an IDE like IntelliJ IDEA
