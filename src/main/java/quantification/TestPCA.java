package quantification;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class TestPCA {
    public static void main(String[] args) {
        // Centered input data
        // Test Data
        double ar[][] = new double[][]{
                {-4.5, -10.103},
                {-3.5, -8.313},
                {-2.5, -6.223},
                {-1.5, -6.533},
                {-0.5, -2.673},
                {0.5, 2.457},
                {1.5, 5.807},
                {2.5, 3.687},
                {3.5, 9.097},
                {4.5, 12.797}
        };

        INDArray tt = Nd4j.create(ar);
        quantification.PCA q = new PCA(tt);
        System.out.println("COVARIANCE: \n" + q.getCovarianceMatrix());
        System.out.println("VA: \n" + q.getEigenvalues());
        System.out.println("VE: \n" + q.getEigenvectors());
        System.out.println("COMPONENTS: \n" + q.convertToComponents(tt));
    }
}
