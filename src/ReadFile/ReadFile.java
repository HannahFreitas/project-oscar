package ReadFile;

import Person.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFile {
    private final List<Person> personList;

    public ReadFile(String filename)  {
        this.personList = readingFile(filename);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    private List<Person> readingFile(String filename)  {
        try(Stream<String> fileLines = Files.lines(Paths.get(filename))) {
            return fileLines
                    .skip(1)
                    .map(Person::of)
                    .collect(Collectors.toList());
        } catch (IOException err) {
            err.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void actorOscarMinAge() {
        System.out.print("Quem foi o ator mais jovem a ganhar um Oscar? ");
        this.getPersonList()
                .stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(it -> System.out.print("O ator mais jovem a ganhar um oscar é: "
                + it.getName()));
    }




}
