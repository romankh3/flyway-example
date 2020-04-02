## Overview
Project example of flyway configuration.

## Building
To build maven project,type:
```
mvn archetype:generate -B 
    -DarchetypeGroupId=org.apache.maven.archetypes 
    -DarchetypeArtifactId=maven-archetype-quickstart 
    -DarchetypeVersion=1.1 
    -DgroupId=com.github.romankh3 
    -DartifactId=flyway-example 
    -Dversion=1.0-SNAPSHOT 
    -Dpackage=com.github.romankh3.flywayexample
```

Then add to App class:

```Java
public class App {
    public static void main(String[] args) {
        // Create the Flyway instance and point it to the database
        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/foobar", "sa", null).load();

        // Start the migration
        flyway.migrate();
    }
}
```

Add First migration: `src/main/resources/db/migration/V00001__Create_person_table.sql`:
```roomsql
create table PERSON (
    ID int not null,
    NAME varchar(100) not null
);
```

Execute program:
`mvn package exec:java -Dexec.mainClass=com.github.romankh3.flywayexample.App`

add second migration: `src/main/resources/db/migration/V00002__Add_people.sql`:
```roomsql
insert into PERSON (ID, NAME) values (1, 'Axel');
insert into PERSON (ID, NAME) values (2, 'Mr. Foo');
insert into PERSON (ID, NAME) values (3, 'Ms. Bar');
```

## Troubleshooting
...

## Release Notes
Can be found in [RELEASE_NOTES](RELEASE_NOTES.md).

## Authors
* Roman Beskrovnyi - [romankh3](https://github.com/romankh3)

## Acknowledgments
...

## Contributing
Please, follow [Contributing](CONTRIBUTING.md) page.

## Code of Conduct
Please, follow [Code of Conduct](CODE_OF_CONDUCT.md) page.

## License
This project is Apache License 2.0 - see the [LICENSE](LICENSE) file for details
