import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] a = new int[N][M];
        int max = 0;

        int[][] aa_x = {{-1, 0, 0, 1}, {-1, 0, 0, 1}, {-1, -1, 0, 0}, {0, 0, 1, 1}};
        int[][] aa_y = {{0, 0, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, -1}, {-1, 0, 0, 1}};

        int[][] bb_x = {{-1, 0, 0, 0}, {0, 0, 0, -1}, {0, 0, 0, 1}, {1, 0, 0, 0}};
        int[][] bb_y = {{-1, -1, 0, 1}, {-1, 0, 1, 1}, {-1, 0, 1, 1}, {-1, -1, 0, 1}};

        int[][] bbb_x = {{-1, -1, 0, 1}, {-1, 0, 1, 1}, {-1, -1, 0, 1}, {-1, 0, 1, 1}};
        int[][] bbb_y = {{1, 0, 0, 0}, {0, 0, 0, 1}, {-1, 0, 0, 0}, {0, 0, 0, -1}};

        int[][] cc_x = {{0, 0, 0, -1}, {0, 0, 0, 1}, {-1, 0, 1, 0}, {-1, 0, 1, 0}};
        int[][] cc_y = {{-1, 0, 1, 0}, {-1, 0, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, -1}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (x - 1 >= 0 && x + 1 < M && y - 1 >= 0 && y + 1 < N) {
                    for (int j = 0; j < 4; j++) {
                        int sum = 0;
                        for (int i = 0; i < 4; i++) {
                            int ny = y + aa_y[j][i];
                            int nx = x + aa_x[j][i];
                            sum += a[ny][nx];
                        }
                        if (sum > max) max = sum;
                        sum = 0;
                        for (int i = 0; i < 4; i++) {
                            int ny = y + bb_y[j][i];
                            int nx = x + bb_x[j][i];
                            sum += a[ny][nx];
                        }
                        if (sum > max) max = sum;

                        sum = 0;
                        for (int i = 0; i < 4; i++) {
                            int ny = y + bbb_y[j][i];
                            int nx = x + bbb_x[j][i];
                            sum += a[ny][nx];
                        }
                        if (sum > max) max = sum;

                        sum = 0;
                        for (int i = 0; i < 4; i++) {
                            int ny = y + cc_y[j][i];
                            int nx = x + cc_x[j][i];
                            sum += a[ny][nx];
                        }
                        if (sum > max) max = sum;
                    }
                } else if (x - 1 >= 0 && x + 1 < M) {
                    if (y - 1 >= 0) {

                        int sum = a[y][x - 1] + a[y][x + 1] + a[y - 1][x] + a[y][x];
                        if (sum > max) max = sum;

                        for (int j = 2; j < 4; j++) {
                            sum = 0;
                            for (int i = 0; i < 4; i++) {
                                int ny = y + bbb_y[j][i];
                                int nx = x + bbb_x[j][i];
                                sum += a[ny][nx];
                            }
                            if (sum > max) max = sum;
                        }


                    } else if (y + 1 < N) {
                        for (int j = 0; j < 2; j++) {
                            int sum = 0;
                            for (int i = 0; i < 4; i++) {
                                int ny = y + aa_y[j][i];
                                int nx = x + aa_x[j][i];
                                sum += a[ny][nx];
                            }
                            if (sum > max) max = sum;
                        }

                        for (int j = 0; j < 2; j++) {
                            int sum = 0;
                            for (int i = 0; i < 4; i++) {
                                int ny = y + bbb_y[j][i];
                                int nx = x + bbb_x[j][i];
                                sum += a[ny][nx];
                            }
                            if (sum > max) max = sum;
                        }


                        int sum = a[y][x - 1] + a[y][x + 1] + a[y][x] + a[y + 1][x];
                        if (sum > max) max = sum;
                    }
                } else if (y - 1 >= 0 && y + 1 < N) {

                    if (x - 1 >= 0) {
                        for (int j = 0; j < 2; j++) {
                            int sum = 0;
                            for (int i = 0; i < 4; i++) {
                                int ny = y + bb_y[j][i];
                                int nx = x + bb_x[j][i];
                                sum += a[ny][nx];
                            }
                            if (sum > max) max = sum;
                        }
                        int sum = a[y][x - 1] + a[y - 1][x] + a[y][x] + a[y + 1][x];
                        if (sum > max) max = sum;
                        sum = a[y - 1][x] + a[y][x] + a[y][x - 1] + a[y - 1][x - 1];
                        if (sum > max) max = sum;

                    } else if (x + 1 < M) {
                        for (int j = 2; j < 4; j++) {
                            int sum = 0;
                            for (int i = 0; i < 4; i++) {
                                int ny = y + bb_y[j][i];
                                int nx = x + bb_x[j][i];
                                sum += a[ny][nx];
                            }
                            if (sum > max) max = sum;
                        }
                        int sum = a[y][x + 1] + a[y - 1][x] + a[y][x] + a[y + 1][x];
                        if (sum > max) max = sum;
                        sum = a[y - 1][x] + a[y][x] + a[y][x + 1] + a[y + 1][x + 1];
                        if (sum > max) max = sum;
                    }

                }

                if (y + 2 < N && y - 1 >= 0) {
                    int sum = a[y + 2][x] + a[y + 1][x] + a[y][x] + a[y - 1][x];
                    if (sum > max) max = sum;
                }
                if (x + 2 < M && x - 1 >= 0) {
                    int sum = a[y][x + 2] + a[y][x + 1] + a[y][x] + a[y][x - 1];
                    if (sum > max) max = sum;
                }
                if (x + 1 < M && y + 1 < N) {
                    int sum = a[y][x] + a[y][x + 1] + a[y + 1][x] + a[y + 1][x + 1];
                    if (sum > max) max = sum;
                }

            }
        }
        System.out.println(max);
    }
}
