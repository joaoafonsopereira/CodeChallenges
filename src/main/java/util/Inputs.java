package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Inputs {

    static final String INPUT_FILES_DIR = "input-files/";
    static final String INPUT_FILES_EXTENSION = ".in";
    static final String PROJ_EULER_BASE_PROBLEM_URL = "https://projecteuler.net/problem=";

    // Wrapper (dos bons)
    static boolean fileExists(String filePath) {
        Path path = Paths.get(filePath);
        return Files.exists(path);
    }

    static void downloadInputText(String URL, String destPath) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Element probContent = doc.getElementsByClass("problem_content").get(0);
            Element textElem = probContent.getElementsByClass("monospace center").get(0);
            String text = textElem.text();

            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(destPath), "utf-8"));
            writer.write(text);
            writer.close();

        } catch (Exception e) {
            System.err.println("Error in downloadInputString");
            e.printStackTrace();
        }
    }

    // Wrapper
    static String readWholeFile(String inputFilePath) {
        String res = "";
        try {
            res = new String(Files.readAllBytes(Paths.get(inputFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String getProblemInput(String problemNr) {
        String URL = PROJ_EULER_BASE_PROBLEM_URL + problemNr;
        String filePath = INPUT_FILES_DIR + problemNr + INPUT_FILES_EXTENSION;
        if(!fileExists(filePath)) {
            downloadInputText(URL, filePath);
        }
        return readWholeFile(filePath);
    }

}
