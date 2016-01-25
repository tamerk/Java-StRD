package strd.data.nr;

/**
 * abstract base class for nonlinear regression datasets
 *
 * @author Tamer Kulaksizoglu
 */
public abstract class NonlinearRegressionDataset {

    protected String datasetName;
    protected int degreesOfFreedom;
    protected String levelOfDifficulty;
    protected int numberOfObservations;
    protected int numberOfParameters;
    protected double[] parameterStandardErrors;
    protected double[] parameterValues;
    protected double[][] predictorVariables;
    protected double regressionStandardError;
    protected double residualSumOfSquares;
    protected double[] responseVariable;
    protected double[] startingValues1;
    protected double[] startingValues2;

    public NonlinearRegressionDataset() {
        datasetName = "";
        degreesOfFreedom = 0;
        levelOfDifficulty = "";
        numberOfObservations = 0;
        numberOfParameters = 0;
        parameterStandardErrors = null;
        parameterValues = null;
        predictorVariables = null;
        regressionStandardError = Double.NaN;
        residualSumOfSquares = Double.NaN;
        responseVariable = null;
        startingValues1 = null;
        startingValues2 = null;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public int getDegreesOfFreedom() {
        return degreesOfFreedom;
    }

    public String getLevelOfDifficulty() {
        return levelOfDifficulty;
    }

    public int getNumberOfObservations() {
        return numberOfObservations;
    }

    public int getNumberOfParameters() {
        return numberOfParameters;
    }

    public double[] getParameterStandardErrors() {
        return parameterStandardErrors;
    }

    public double[] getParameterValues() {
        return parameterValues;
    }

    public double[][] getPredictorVariables() {
        return predictorVariables;
    }

    public double getRegressionStandardError() {
        return regressionStandardError;
    }

    public double getResidualSumOfSquares() {
        return residualSumOfSquares;
    }

    public double[] getResponseVariable() {
        return responseVariable;
    }

    public double[] getStartingValues1() {
        return startingValues1;
    }

    public double[] getStartingValues2() {
        return startingValues2;
    }
}
