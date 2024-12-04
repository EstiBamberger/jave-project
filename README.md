<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - School Transactions Management</title>
</head>
<body>
    <h1>School Transactions Management</h1>
    <p>A Java project for managing school purchases using CSV file processing.</p>

    <h2>Project Overview</h2>
    <p>
        This project processes a <code>CSV</code> file that contains transaction records for schools. 
        The system allows querying the data, such as finding the school with the highest number of transactions 
        in a specific month and year.
    </p>

    <h2>Technologies Used</h2>
    <ul>
        <li>Java</li>
        <li>CSV file processing</li>
        <li>Java <code>LocalDate</code> and <code>DateTimeFormatter</code></li>
        <li>Collections (e.g., <code>Map</code>, <code>List</code>)</li>
        <li>Lambda expressions</li>
    </ul>

    <h2>Features</h2>
    <ul>
        <li>Dynamic processing of CSV data.</li>
        <li>Mapping schools to their corresponding transactions.</li>
        <li>Finding the school with the most transactions in a specific month and year.</li>
    </ul>

    <h2>Project Structure</h2>
    <ul>
        <li>
            <strong>School</strong>:
            <ul>
                <li>Attributes: <code>id</code>, <code>name</code>.</li>
                <li>Methods: Constructor, getters, setters, <code>toString()</code>, <code>equals()</code>, and <code>hashCode()</code>.</li>
            </ul>
        </li>
        <li>
            <strong>Transaction</strong>:
            <ul>
                <li>Attributes: <code>id</code>, <code>description</code>, <code>date</code>, <code>price</code>.</li>
                <li>Methods: Constructor, getters, setters, <code>toString()</code>, <code>equals()</code>, and <code>hashCode()</code>.</li>
            </ul>
        </li>
        <li>
            <strong>TransactionUtil</strong>:
            <ul>
                <li>Static utility class for reading and processing CSV data.</li>
                <li>Builds a map of schools and their transactions.</li>
                <li>Includes the method <code>maxSchoolForMonth(Month month, int year)</code> for querying the data.</li>
            </ul>
        </li>
        <li>
            <strong>Main</strong>:
            <ul>
                <li>Contains the <code>main()</code> method to demonstrate the functionality of the project.</li>
            </ul>
        </li>
    </ul>

    <h2>How to Run</h2>
    <ol>
        <li>Clone this repository to your local machine.</li>
        <li>Place the <code>transactions.csv</code> file in the <code>D:/</code> directory.</li>
        <li>Open the project in your favorite Java IDE.</li>
        <li>Run the <code>Main</code> class to see the output.</li>
    </ol>

    <h2>Example Output</h2>
    <pre>
School{id=1, name='Example School'}
    </pre>

    <h2>License</h2>
    <p>This project is licensed under the MIT License.</p>
</body>
</html>
