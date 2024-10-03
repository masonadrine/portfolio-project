package src;

import java.util.Arrays;

import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import src.components.matrix.Matrix;

public class test {
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        Matrix m = new Matrix(new int[][] { new int[] { 2, 3 }, new int[] { 3, 2 } });
        Matrix n = new Matrix(new int[][] { new int[] { 4, 5 }, new int[] { 6, 7 } });

        // Matrix m = new Matrix(new int[][] { new int[] { 5 } });
        // Matrix n = new Matrix(new int[][] { new int[] { 2, 6 } });

        out.println(Arrays.deepToString(m.rep()));
        out.println(Arrays.deepToString(n.rep()));

        // n.transpose();

        out.println(m.mMultiply(n));

        out.println(Arrays.deepToString(m.rep()));

        out.close();
    }
}
