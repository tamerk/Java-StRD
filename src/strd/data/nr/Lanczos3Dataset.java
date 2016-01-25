package strd.data.nr;

/**
 * class for Lanczos3 dataset
 *
 * @author Tamer Kulaksizoglu
 */
public class Lanczos3Dataset extends NonlinearRegressionDataset {

    public Lanczos3Dataset() {
        super();
        datasetName = "Lanczos3";
        degreesOfFreedom = 18;
        levelOfDifficulty = "Lower";
        numberOfObservations = 24;
        numberOfParameters = 6;
        parameterStandardErrors = new double[]{1.7197908859E-02, 9.7041624475E-02, 4.1488663282E-02, 1.0766312506E-01, 5.8371576281E-02, 3.4436403035E-02};
        parameterValues = new double[]{8.6816414977E-02, 9.5498101505E-01, 8.4400777463E-01, 2.9515951832E+00, 1.5825685901E+00, 4.9863565084E+00};
        predictorVariables = new double[1][numberOfObservations];
        predictorVariables[0] = new double[]{0.00000E+00, 5.00000E-02, 1.00000E-01, 1.50000E-01, 2.00000E-01, 2.50000E-01, 3.00000E-01, 3.50000E-01, 4.00000E-01, 4.50000E-01, 5.00000E-01, 5.50000E-01, 6.00000E-01, 6.50000E-01, 7.00000E-01, 7.50000E-01, 8.00000E-01, 8.50000E-01, 9.00000E-01, 9.50000E-01, 1.00000E+00, 1.05000E+00, 1.10000E+00, 1.15000E+00};
        regressionStandardError = 2.9923229172E-05;
        residualSumOfSquares = 1.6117193594E-08;
        responseVariable = new double[]{2.5134E+00, 2.0443E+00, 1.6684E+00, 1.3664E+00, 1.1232E+00, 0.9269E+00, 0.7679E+00, 0.6389E+00, 0.5338E+00, 0.4479E+00, 0.3776E+00, 0.3197E+00, 0.2720E+00, 0.2325E+00, 0.1997E+00, 0.1723E+00, 0.1493E+00, 0.1301E+00, 0.1138E+00, 0.1000E+00, 0.0883E+00, 0.0783E+00, 0.0698E+00, 0.0624E+00};
        startingValues1 = new double[]{1.2, 0.3, 5.6, 5.5, 6.5, 7.6};
        startingValues2 = new double[]{0.5, 0.7, 3.6, 4.3, 4, 6.3};
    }
}
