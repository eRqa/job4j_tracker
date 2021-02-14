package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionInDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionInDiapason functionInDiapason = new FunctionInDiapason();
        List<Double> result = functionInDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqFunctionThenSqResult() {
        FunctionInDiapason functionInDiapason = new FunctionInDiapason();
        List<Double> result
                = functionInDiapason.diapason(4, 7, x -> Math.pow(2 * x, 2) + (2 * x) + 1);
        List<Double> expected = List.of(73D, 111D, 157D);
        assertThat(expected, is(result));
    }

    @Test
    public void whenLogFunctionThenLogResults() {
        FunctionInDiapason functionInDiapason = new FunctionInDiapason();
        List<Double> result = functionInDiapason.diapason(5, 8, Math::log);
        List<Double> expected
                = Arrays.asList(1.6094379124341003D, 1.791759469228055D, 1.9459101490553132D);
        assertThat(result, is(expected));
    }

}