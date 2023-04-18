## Task: CSV to HTML Table Converter

### Background
We have a collection of CSV files containing various data, and we need a tool to convert these files into HTML tables for better presentation on our website. We also have an HTML template that should be used to wrap the generated tables.

### Objective
Create a Java program that reads CSV files from a specified input directory, converts each file into an HTML table, and saves the result in a specified output directory. The generated HTML table should be inserted into the provided HTML template between the <body> and </body> tags.

### Requirements
Create a Java class named CsvToHtmlTable with a main() method that performs the following tasks:

* Reads all CSV files from the `/assets/csv/` directory - use `Files.newDirectoryStream()` to get a list of files in the directory
* Parses each CSV file and generates an HTML table
* Inserts the generated table into the provided HTML template between the <body> and </body> tags
* Saves the modified HTML template to the `/assets/html/` directory with the same name as the original CSV file but with an .html extension
* If the output directory does not exist, create it
* The generated HTML table should have the following structure:

* Use the first row of the CSV file as the header row (`<thead>`)
* Wrap each header cell in a `<th>` element
* Wrap each data row in a `<tr>` element and each data cell in a <td> element
* Include `<tbody>` element to wrap the data rows
* `<table>` element should have the class attribute set to "table"

### Deliverables
The CsvToHtmlTable Java class with the implemented main() method and any necessary helper methods
At least three example CSV files used for testing
The HTML template file /assets/template.html with the proper structure for inserting the generated table
Evaluation Criteria
The program successfully reads and processes all CSV files in the specified input directory
The program generates an HTML table with the correct structure and inserts it into the provided HTML template
The program saves the modified HTML template to the specified output directory
The program handles errors gracefully, such as when the input directory does not exist or the template file is missing the <body> and </body> tags
The code is well-organized, easy to read, and follows best practices for Java programming


