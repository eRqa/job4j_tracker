package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void whenMatrixToList() {

        Integer[][] matrix = {
                {4, 3},
                {1, 2}
        };
        List<Integer> act = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of(4, 3, 1, 2);
        assertThat(act, is(expected));
    }

    @Test
    public void matrix4X2ToList() {

        Integer[][] matrix = {
                {4, 1, 3, 8},
                {1, 2}
        };
        List<Integer> act = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of(4, 1, 3, 8, 1, 2);
        assertThat(act, is(expected));
    }
}