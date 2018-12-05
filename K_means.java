/**
 * K_means
 */
public class K_means {
    static double[] clusterA = { 1.0, 2.0 };
    static double[] clusterB = { 4.0, 1.0 };
    static double[] clusterC = { 4.0, 4.0 };

    static double[] point = { 1.0, 1.0, 1.0, 2.0, 1.0, 3.0, 1.0, 5.0, 2.0, 3.0, 2.0, 4.0, 3.0, 1.0, 4.0, 1.0, 4.0, 4.0,
            5.0, 3.0, 6.0, 3.0, 6.0, 5.0 };

    public static void main(String[] args) {

        int num = 0;
        double countA = 0;
        double countB = 0;
        double countC = 0;

        double[] sumA = { 0.0, 0.0 };
        double[] sumB = { 0.0, 0.0 };
        double[] sumC = { 0.0, 0.0 };
        String s;

        boolean flag = true;
        while (flag) {
            num++;
            System.out.print(num + "回目：");
            for (int i = 0; i < 24; i = i + 2) {
                s = setCluster(i);
                System.out.print(i / 2 + "-" + s + ",");
                switch (s) {
                case "A":
                    sumA[0] += point[i];
                    sumA[1] += point[i + 1];
                    countA++;
                    break;
                case "B":
                    sumB[0] += point[i];
                    sumB[1] += point[i + 1];
                    countB++;
                    break;
                case "C":
                    sumC[0] += point[i];
                    sumC[1] += point[i + 1];
                    countC++;
                    break;
                }
            }
            System.out.println();
            System.out.println();
            if (clusterA[0] == sumA[0] / countA && clusterA[1] == sumA[1] / countA && clusterB[0] == sumB[0] / countB
                    && clusterB[1] == sumB[1] / countB && clusterC[0] == sumC[0] / countC
                    && clusterC[1] == sumC[1] / countC) {

                flag = false;
            } else {

                // A
                clusterA[0] = sumA[0] / countA;
                clusterA[1] = sumA[1] / countA;
                // B
                clusterB[0] = sumB[0] / countB;
                clusterB[1] = sumB[1] / countB;
                // C
                clusterC[0] = sumC[0] / countC;
                clusterC[1] = sumC[1] / countC;
            }
            System.out.println(num + "回目:A　" + clusterA[0] + "," + clusterA[1]);
            System.out.println(num + "回目:B　" + clusterB[0] + "," + clusterB[1]);
            System.out.println(num + "回目:C　" + clusterC[0] + "," + clusterC[1]);
            System.out.println();

            sumA[0] = 0.0;
            sumA[1] = 0.0;
            sumB[0] = 0.0;
            sumB[1] = 0.0;
            sumC[0] = 0.0;
            sumC[1] = 0.0;
            countA = 0;
            countB = 0;
            countC = 0;

        }

    }

    static String setCluster(int i) {
        double a = Math.sqrt(
                Math.pow(Math.abs(clusterA[0] - point[i]), 2) + Math.pow(Math.abs(clusterA[1] - point[i + 1]), 2));

        double b = Math.sqrt(
                Math.pow(Math.abs(clusterB[0] - point[i]), 2) + Math.pow(Math.abs(clusterB[1] - point[i + 1]), 2));

        double c = Math.sqrt(
                Math.pow(Math.abs(clusterC[0] - point[i]), 2) + Math.pow(Math.abs(clusterC[1] - point[i + 1]), 2));

        if (a < b) {
            if (a < c) {
                return "A";
            } else {
                return "C";
            }
        } else {
            if (b < c) {
                return "B";
            } else {
                return "C";
            }
        }
    }
}