package util;

import org.junit.jupiter.api.Test;

class InputsTest {

    @Test
    void downloadInputString() {
        Inputs.downloadInputText("https://projecteuler.net/problem=13", "input-files/test-download");
    }

    @Test
    void testGetProblemInput() {
        Inputs.getProblemInput("13");
    }
}