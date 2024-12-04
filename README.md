# School Transactions Management System  

This project is a Java application for managing and analyzing school transaction data stored in a `CSV` file.  
The system allows users to process transactions and perform various operations, such as identifying the school with the highest number of transactions in a specific month and year.

## Features  
- **Read and Parse CSV Files**:  
  Reads a transactions CSV file and processes its data into structured objects.  
- **School and Transaction Management**:  
  Object-oriented classes for managing schools and their transactions.  
- **Query and Analysis**:  
  Find the school with the highest number of transactions for a given month and year using efficient lambda expressions.  

## Project Structure  
- **School Class**  
  - Manages school information:  
    ```java
    private int id;  
    private String name;
    ```  
  - Provides constructors, getters, setters, and overridden `toString`, `equals`, and `hashCode` methods.

- **Transaction Class**  
  - Manages transaction details:  
    ```java
    private int id;  
    private String description;  
    private LocalDate date;  
    private float price;
    ```  
  - Includes constructors, getters, setters, and overridden `toString`, `equals`, and `hashCode` methods.

- **TransactionUtil Class**  
  - Handles file processing and transaction data mapping:  
    - Reads and parses rows from the CSV file.  
    - Builds a map of schools to their transactions:  
      ```java
      private static Map<School, List<Transaction>> transactionsMap;
      ```  
    - Provides a method to find the school with the most transactions for a specific month and year:  
      ```java
      public static School maxSchoolForMonth(Month month, int year);
      ```  

## Usage  
1. Place the `transactions.csv` file in the directory: `D:/transactions.csv`.  
2. Run the application to execute the `main` method in the `Main` class:  
   ```java
   System.out.println(TransactionUtil.maxSchoolForMonth(Month.MARCH, 2023));
