#### Instructions how to run project

Import as Maven project with IntelliJ or Eclipse. Download dependencies with Maven.

Tests can be executed:
+ using IDE - run any chosen test. Add parameters below to VM options
+ using Maven - use command ***mvn test***.

To run API tests some parameters are needed:
+ -DBASE_URL=https://swapi.dev/api

Examples:

Run all tests with maven:
mvn test -ea -DBBASE_URL=https://swapi.dev/api

vm options:
-ea -ea -DBASE_URL=https://swapi.dev/api