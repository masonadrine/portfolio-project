package src.components.matrix;

//Hello Jeremy

public class Matrix {// extends components.standard<Matrix> {
    private int[][] rep;

    private void createNewRep(int i, int j) {
        this.rep = new int[i][j];

        for (int x = 0; x < i; x++) {
            for (int y = 0; y < j; y++) {
                this.rep[x][y] = 0;
            }
        }
    }

    public Matrix(int[][] m) {
        this.rep = m.clone();
    }

    public Matrix(int i, int j) {
        this.createNewRep(i, j);
    }

    public int get(int i, int j) {
        return this.rep[i][j];
    }

    public void set(int i, int j, int n) {
        this.rep[i][j] = n;
    }

    public void clear() {
        this.createNewRep(this.rep.length, this.rep[0].length);
    }

    public int[] size() {
        return new int[] { this.rep.length, this.rep[0].length };
    }

    public int[][] rep() {
        return this.rep;
    }

    public boolean add(Matrix m) {
        boolean ans = false;

        if (this.size()[0] == m.size()[0] && this.size()[1] == m.size()[1]) {
            ans = true;

            for (int i = 0; i < this.size()[0]; i++) {
                for (int j = 0; j < this.size()[1]; j++) {
                    this.set(i, j, this.get(i, j) + m.get(i, j));
                }
            }
        }

        return ans;
    }

    public boolean subtract(Matrix m) {
        boolean ans = false;

        if (this.size()[0] == m.size()[0] && this.size()[1] == m.size()[1]) {
            ans = true;

            for (int i = 0; i < this.size()[0]; i++) {
                for (int j = 0; j < this.size()[1]; j++) {
                    this.set(i, j, this.get(i, j) - m.get(i, j));
                }
            }
        }

        return ans;
    }

    public boolean mMultiply(Matrix m) {
        boolean ans = false;

        if (this.size()[1] == m.size()[0]) {
            ans = true;
            Matrix res = new Matrix(this.size()[0], m.size()[1]);

            for (int i = 0; i < this.size()[0]; i++) {
                for (int j = 0; j < m.size()[1]; j++) {
                    int sum = 0;

                    for (int k = 0; k < this.size()[1]; k++) {
                        sum += this.get(i, k) * m.get(k, j);
                    }

                    res.set(i, j, sum);
                }
            }

            // TODO: inherit standard and override transferFrom; tempFix
            this.createNewRep(res.size()[0], res.size()[1]);
            this.add(res);
        }

        return ans;
    }

    public void transpose() {
        Matrix m = new Matrix(this.size()[1], this.size()[0]);

        for (int i = 0; i < this.size()[0]; i++) {
            for (int j = 0; j < this.size()[1]; j++) {
                m.set(j, i, this.get(i, j));
            }
        }

        this.createNewRep(this.size()[1], this.size()[0]);
        this.add(m);
    }
}
