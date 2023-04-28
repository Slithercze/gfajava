package com.gfa.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricMatrixTest {

    @org.junit.jupiter.api.Test
    void isSymmetric() {
        //arrange
        int[][] matrix = {
                {1, 0, 1},
                {0, 2, 2},
                {1, 2, 5},

        };
        //act
        boolean result = SymmetricMatrix.isSymmetric(matrix);

        // assert
        assertTrue(result);
    }

    @Test
    void nullSymetric(){
        assertFalse(SymmetricMatrix.isSymmetric(null));
    }

}