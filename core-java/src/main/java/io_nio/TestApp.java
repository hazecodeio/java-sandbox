package io_nio;

import java.io.*;
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


class ProcessRunner02 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder cat = new ProcessBuilder("cat").command("jq", "-c", "select(.name == \"Alis\")");//.redirectInput(ProcessBuilder.Redirect.PIPE);
        Process start = cat.start();

        OutputStream outputStream = start.getOutputStream();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"22\"}".getBytes());
        outputStream.flush();

        ProcessBuilder jq = new ProcessBuilder("jq", "-c", "select(.name != \"Alis\")");


        outputStream.close();

        InputStream inputStream = start.getInputStream();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                inputStream));
        stdInput.lines().forEach(System.out::println);
        inputStream.close();

    }
}

class ProcessRunner03 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder cat = new ProcessBuilder("cat");
        ProcessBuilder jq = new ProcessBuilder("jq", "-c", "select(.age >= \"22\")");

        List<ProcessBuilder> cmds = Arrays.asList(cat, jq);
        List<Process> processes = ProcessBuilder.startPipeline(cmds);

        Process catCmd = processes.get(0);
        OutputStream outputStream = catCmd.getOutputStream();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"20\"}\n".getBytes());
        outputStream.flush();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"21\"}\n".getBytes());
        outputStream.flush();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"22\"}\n".getBytes());
        outputStream.flush();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"23\"}\n".getBytes());
        outputStream.flush();

        outputStream.close();

        /*InputStream inputStream = catCmd.getInputStream();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                inputStream));
        stdInput.lines().forEach(System.out::println);

        inputStream.close();*/


        Process last = processes.get(processes.size() - 1);

        BufferedReader stdInput2 = new BufferedReader(new InputStreamReader(
                last.getInputStream()));
        stdInput2.lines().forEach(System.out::println);


//        outputStream.close();
        stdInput2.close();

    }
}

class ProcessRunner04 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder cat = new ProcessBuilder("cat");
        ProcessBuilder jq = new ProcessBuilder("jq", "-c", "select(.name == \"Alis\")");

        List<ProcessBuilder> cmds = Arrays.asList(cat, jq);
        List<Process> processes = ProcessBuilder.startPipeline(cmds);

        Process last = processes.get(processes.size() - 1);

        new Thread(() -> {


            System.out.println("b");
            BufferedReader stdInput2 = new BufferedReader(new InputStreamReader(
                    last.getInputStream()));
            System.out.println("ww");
            stdInput2.lines().forEach(System.out::println);
            System.out.println("a");

        }).start();


        Process catCmd = processes.get(0);
        OutputStream outputStream = catCmd.getOutputStream();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"22\"}\n".getBytes());
        outputStream.flush();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"22\"}\n".getBytes());
        outputStream.flush();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"22\"}\n".getBytes());
        outputStream.flush();
        outputStream.write("{\"name\": \"Alis\", \"age\": \"22\"}\n".getBytes());
        outputStream.flush();

//        outputStream.close();




        outputStream.close(); // ToDo - why do I need to close the stream in order for the thread to see the was written?
//        stdInput2.close();

    }
}