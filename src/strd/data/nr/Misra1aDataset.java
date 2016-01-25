package strd.data.nr;

/**
 * class for Misra1a dataset
 *
 * @author Tamer Kulaksizoglu
 */
public class Misra1aDataset extends NonlinearRegressionDataset {

    public Misra1aDataset() {
        super();
        datasetName = "Misra1a";
        degreesOfFreedom = 12;
        levelOfDifficulty = "Lower";
        numberOfObservations = 14;
        numberOfParameters = 2;
        parameterStandardErrors = new double[]{2.7070075241E+00, 7.2668688436E-06};
        parameterValues = new double[]{2.3894212918E+02, 5.5015643181E-04};
        predictorVariables = new double[1][numberOfObservations];
        predictorVariables[0] = new double[]{77.6, 114.9, 141.1, 190.8, 239.9, 289.0, 332.8, 378.4, 434.8, 477.3, 536.8, 593.1, 689.1, 760.0};
        regressionStandardError = 1.0187876330E-01;
        residualSumOfSquares = 1.2455138894E-01;
        responseVariable = new double[]{10.07, 14.73, 17.94, 23.93, 29.61, 35.18, 40.02, 44.82, 50.76, 55.05, 61.01, 66.40, 75.47, 81.78};
        startingValues1 = new double[]{500, 0.0001};
        startingValues2 = new double[]{250, 0.0005};
    }
}
