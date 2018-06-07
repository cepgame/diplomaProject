package quantification;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.eigen.Eigen;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.indexing.INDArrayIndex;
import org.nd4j.linalg.indexing.NDArrayIndex;
import org.nd4j.linalg.ops.transforms.Transforms;

public class PCA {
    private INDArray covarianceMatrix;
    private INDArray mean;
    private INDArray eigenvectors;
    private INDArray eigenvalues;


    public PCA(INDArray dataset) {
        INDArray[] covmean = covarianceMatrix(dataset);
        this.covarianceMatrix = covmean[0];
        this.mean = covmean[1];
        INDArray[] pce = principalComponents(covmean[0]);
        this.eigenvectors = pce[0];
        this.eigenvalues = pce[1];
    }

    public INDArray reducedBasis(double variance) {
        INDArray vars = Transforms.pow(this.eigenvalues, -0.5, true);
        double res = vars.sumNumber().doubleValue();
        double total = 0.0;
        int ndims = 0;

        for(int result = 0; result < vars.columns(); ++result) {
            ++ndims;
            total += vars.getDouble(result);
            if(total / res > variance) {
                break;
            }
        }

        INDArray var11 = Nd4j.create(this.eigenvectors.rows(), ndims);

        for(int i = 0; i < ndims; ++i) {
            var11.putColumn(i, this.eigenvectors.getColumn(i));
        }

        return var11;
    }

    public INDArray convertToComponents(INDArray data) {
        INDArray dx = data.subRowVector(this.mean);
        return Nd4j.tensorMmul(this.eigenvectors.transpose(), dx, new int[][]{{1}, {1}}).transposei();
    }

    public INDArray convertBackToFeatures(INDArray data) {
        return Nd4j.tensorMmul(this.eigenvectors, data, new int[][]{{1}, {1}}).transposei().addiRowVector(this.mean);
    }

    public double estimateVariance(INDArray data, int ndims) {
        INDArray dx = data.sub(this.mean);
        INDArray v = this.eigenvectors.transpose().mmul(dx.reshape(dx.columns(), 1));
        INDArray t2 = Transforms.pow(v, 2);
        double fraction = t2.get(new INDArrayIndex[]{NDArrayIndex.interval(0, ndims)}).sumNumber().doubleValue();
        double total = t2.sumNumber().doubleValue();
        return fraction / total;
    }

    public INDArray generateGaussianSamples(int count) {
        INDArray samples = Nd4j.randn(count, this.eigenvalues.columns());
        INDArray factors = Transforms.pow(this.eigenvalues, -0.5, true);
        samples.muliRowVector(factors);
        return Nd4j.tensorMmul(this.eigenvectors, samples, new int[][]{{1}, {1}}).transposei().addiRowVector(this.mean);
    }

    public static INDArray pca(INDArray A, int nDims, boolean normalize) {
        INDArray factor = pca_factor(A, nDims, normalize);
        return A.mmul(factor);
    }

    public static INDArray pca_factor(INDArray A, int nDims, boolean normalize) {
        if(normalize) {
            INDArray m = A.mean(0);
            A.subiRowVector(m);
        }

        int var10 = A.rows();
        int n = A.columns();
        INDArray s = Nd4j.create(var10 < n?var10:n);
        INDArray VT = Nd4j.create(n, n, 'f');
        Nd4j.getBlasWrapper().lapack().gesvd(A, s, (INDArray)null, VT);
        INDArray V = VT.transpose();
        INDArray factor = Nd4j.create(n, nDims, 'f');

        for(int i = 0; i < nDims; ++i) {
            factor.putColumn(i, V.getColumn(i));
        }

        return factor;
    }

    public static INDArray pca(INDArray A, double variance, boolean normalize) {
        INDArray factor = pca_factor(A, variance, normalize);
        return A.mmul(factor);
    }

    public static INDArray pca_factor(INDArray A, double variance, boolean normalize) {
        if(normalize) {
            INDArray m = A.mean(0);
            A.subiRowVector(m);
        }

        int var16 = A.rows();
        int n = A.columns();
        INDArray s = Nd4j.create(var16 < n?var16:n);
        INDArray VT = Nd4j.create(n, n, 'f');
        Nd4j.getBlasWrapper().lapack().gesvd(A, s, (INDArray)null, VT);

        for(int totalEigSum = 0; totalEigSum < s.length(); ++totalEigSum) {
            s.putScalar(totalEigSum, Math.sqrt(s.getDouble(totalEigSum)) / (double)(var16 - 1));
        }

        double var17 = s.sumNumber().doubleValue() * variance;
        int k = -1;
        double runningTotal = 0.0D;

        for(int V = 0; V < s.length(); ++V) {
            runningTotal += s.getDouble(V);
            if(runningTotal >= var17) {
                k = V + 1;
                break;
            }
        }

        if(k == -1) {
            throw new RuntimeException("No reduction possible for reqd. variance - use smaller variance");
        } else {
            INDArray var18 = VT.transpose();
            INDArray factor = Nd4j.create(n, k, 'f');

            for(int i = 0; i < k; ++i) {
                factor.putColumn(i, var18.getColumn(i));
            }

            return factor;
        }
    }

    public static INDArray pca2(INDArray in, double variance) {
        INDArray[] covmean = covarianceMatrix(in);
        INDArray[] pce = principalComponents(covmean[0]);
        INDArray vars = Transforms.pow(pce[1], Double.valueOf(-0.5D), true);
        double res = vars.sumNumber().doubleValue();
        double total = 0.0D;
        int ndims = 0;

        for(int result = 0; result < vars.columns(); ++result) {
            ++ndims;
            total += vars.getDouble(result);
            if(total / res > variance) {
                break;
            }
        }

        INDArray var13 = Nd4j.create(in.columns(), ndims);

        for(int i = 0; i < ndims; ++i) {
            var13.putColumn(i, pce[0].getColumn(i));
        }

        return var13;
    }

    public static INDArray[] covarianceMatrix(INDArray in) {
        int dlength = in.rows();
        int vlength = in.columns();
        INDArray sum = Nd4j.create(vlength);
        INDArray product = Nd4j.create(vlength, vlength);

        int i;
        for(i = 0; i < vlength; ++i) {
            sum.getColumn(i).assign(Double.valueOf(in.getColumn(i).sumNumber().doubleValue() / (double)dlength));
        }

        for(i = 0; i < dlength; ++i) {
            INDArray dx1 = in.getRow(i).sub(sum);
            product.addi(dx1.reshape(vlength, 1).mmul(dx1.reshape(1, vlength)));
        }

        product.divi(Integer.valueOf(dlength));
        return new INDArray[]{product, sum};
    }

    public static INDArray[] principalComponents(INDArray cov) {
        assert cov.rows() == cov.columns();

        INDArray[] result = new INDArray[]{Nd4j.eye(cov.rows()), null};
        result[1] = Eigen.symmetricGeneralizedEigenvalues(result[0], cov, true);
        return result;
    }

    public INDArray getCovarianceMatrix() {
        return this.covarianceMatrix;
    }

    public INDArray getMean() {
        return this.mean;
    }

    public INDArray getEigenvectors() {
        return this.eigenvectors;
    }

    public INDArray getEigenvalues() {
        return this.eigenvalues;
    }
}
