package io_nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hsmak on 5/2/15.
 */
public class TestApp {
    public static void main(String[] args) throws URISyntaxException, IOException {

        URL resource = ClassLoader.getSystemClassLoader().getResource("test.txt");
//        URL resource = TestApp.class.getResource("test.txt");
        System.out.println(resource);
        Path p = Paths.get(resource.toURI());

        Files.lines(p)
//                .parallel()
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
//                .filter(wd -> wd.startsWith("h") || wd.startsWith("H"))
                .map(wd -> (wd.startsWith("h") || wd.startsWith("H")) ? wd.toUpperCase() : wd)
                .forEach(System.out::println);
    }
}

class ProcessRunner {
    public static void main(String[] args) throws IOException {
        /*List<ProcessBuilder> builders = Arrays.asList(
                new ProcessBuilder("find", "../../", "-name", "*.java", "-type", "f"),
                new ProcessBuilder("wc", "-l"));*/

        List<ProcessBuilder> builders = Arrays.asList(
                new ProcessBuilder("echo", "{\"name\": \"Alis\", \"age\": \"22\"}"),
                new ProcessBuilder("jq", "-c", "select(.name == \"Alis\")"));

        List<Process> processes = ProcessBuilder.startPipeline(builders);
        Process last = processes.get(processes.size() - 1);

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                last.getInputStream()));
        stdInput.lines().forEach(System.out::println);

    }
}