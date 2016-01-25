package strd.data.nr;

/**
 * class for Chwirut2 dataset
 *
 * @author Tamer Kulaksizoglu
 */
public class Chwirut2Dataset extends NonlinearRegressionDataset {

    public Chwirut2Dataset() {
        super();
        datasetName = "Chwirut2";
        degreesOfFreedom = 51;
        levelOfDifficulty = "Lower";
        numberOfObservations = 54;
        numberOfParameters = 3;
        parameterStandardErrors = new double[]{3.8303286810E-02, 6.6621605126E-04, 1.5304234767E-03};
        parameterValues = new double[]{1.6657666537E-01, 5.1653291286E-03, 1.2150007096E-02};
        predictorVariables = new double[1][numberOfObservations];
        predictorVariables[0] = new double[]{0.500, 1.000, 1.750, 3.750, 5.750, 0.875, 2.250, 3.250, 5.250, 0.750, 1.750, 2.750, 4.750, 0.625, 1.250, 2.250, 4.250, 0.500, 3.000, 0.750, 3.000, 1.500, 6.000, 3.000, 6.000, 1.500, 3.000, 0.500, 2.000, 4.000, 0.750, 2.000, 5.000, 0.750, 2.250, 3.750, 5.750, 3.000, 0.750, 2.500, 4.000, 0.750, 2.500, 4.000, 0.750, 2.500, 4.000, 0.500, 6.000, 3.000, 0.500, 2.750, 0.500, 1.750};
        regressionStandardError = 3.1717133040E+00;
        residualSumOfSquares = 5.1304802941E+02;
        responseVariable = new double[]{92.9000, 57.1000, 31.0500, 11.5875, 8.0250, 63.6000, 21.4000, 14.2500, 8.4750, 63.8000, 26.8000, 16.4625, 7.1250, 67.3000, 41.0000, 21.1500, 8.1750, 81.5000, 13.1200, 59.9000, 14.6200, 32.9000, 5.4400, 12.5600, 5.4400, 32.0000, 13.9500, 75.8000, 20.0000, 10.4200, 59.5000, 21.6700, 8.5500, 62.0000, 20.2000, 7.7600, 3.7500, 11.8100, 54.7000, 23.7000, 11.5500, 61.3000, 17.7000, 8.7400, 59.2000, 16.3000, 8.6200, 81.0000, 4.8700, 14.6200, 81.7000, 17.1700, 81.3000, 28.9000};
        startingValues1 = new double[]{0.1, 0.01, 0.02};
        startingValues2 = new double[]{0.15, 0.008, 0.010};
    }
}
