package strd.acm.nr;

import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.fitting.leastsquares.EvaluationRmsChecker;
import org.apache.commons.math3.fitting.leastsquares.GaussNewtonOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresBuilder;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.apache.commons.math3.optim.ConvergenceChecker;
import org.apache.commons.math3.util.FastMath;

/**
 * abstract base class for nonlinear regression model
 *
 * @author Tamer Kulaksizoglu
 */
public abstract class NonlinearRegressionModel {

    protected double[] fittedValues;
    protected double[][] jacobian;
    private final LeastSquaresBuilder leastSquaresBuilder;
    private LeastSquaresOptimizer leastSquaresOptimizer;
    private LeastSquaresProblem leastSquaresProblem;
    protected int maximumEvaluations;
    protected int maximumIterations;
    protected int numberOfParameters;
    private Optimizer optimizer;
    private Optimum optimum;
    protected double[] parameterValues;
    protected double[][] predictorVariables;
    protected double[] responseVariable;
    protected int sampleSize;
    protected double tolerance;

    public NonlinearRegressionModel() {
        fittedValues = null;
        jacobian = null;
        leastSquaresBuilder = new LeastSquaresBuilder();
        leastSquaresOptimizer = new LevenbergMarquardtOptimizer();
        leastSquaresProblem = null;
        maximumEvaluations = 5000;
        maximumIterations = 5000;
        numberOfParameters = 0;
        optimizer = Optimizer.LevenbergMarquardt;
        optimum = null;
        parameterValues = null;
        predictorVariables = null;
        responseVariable = null;
        sampleSize = 0;
        tolerance = 1e-15;
    }

    public void setMaximumEvaluations(int maximumEvaluations) {
        this.maximumEvaluations = maximumEvaluations;
    }

    public void setMaximumIterations(int maximumIterations) {
        this.maximumIterations = maximumIterations;
    }

    public void setOptimizer(Optimizer optimizer) {
        this.optimizer = optimizer;
        if (optimizer == Optimizer.GaussNewton) {
            leastSquaresOptimizer = new GaussNewtonOptimizer();
        } else {
            leastSquaresOptimizer = new LevenbergMarquardtOptimizer();
        }
    }

    public void setPredictorVariables(double[][] predictorVariables) {
        this.predictorVariables = predictorVariables;
    }

    public void setResponseVariable(double[] responseVariable) {
        this.responseVariable = responseVariable;
        sampleSize = responseVariable.length;
        fittedValues = new double[sampleSize];
        jacobian = new double[sampleSize][numberOfParameters];
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    public Optimizer getOptimizer() {
        return optimizer;
    }

    public double[] getParameterValues() {
        return parameterValues;
    }

    public void estimate(double[] startingValues) {
        ConvergenceChecker<Evaluation> checker = new EvaluationRmsChecker(tolerance);
        leastSquaresBuilder.checker(checker);
        leastSquaresBuilder.maxEvaluations(maximumEvaluations);
        leastSquaresBuilder.maxIterations(maximumIterations);
        leastSquaresBuilder.model(this.getModelFunction(), this.getModelFunctionJacobian());
        leastSquaresBuilder.start(startingValues);
        leastSquaresBuilder.target(responseVariable);
        leastSquaresProblem = leastSquaresBuilder.build();
        optimum = leastSquaresOptimizer.optimize(leastSquaresProblem);
        parameterValues = optimum.getPoint().toArray();
    }

    public abstract MultivariateVectorFunction getModelFunction();

    public abstract MultivariateMatrixFunction getModelFunctionJacobian();

    public double logOfRelativeError(double[] calculated, double[] certified) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < certified.length; i++) {
            double value = -FastMath.log10(FastMath.abs(calculated[i] - certified[i]) / FastMath.abs(certified[i]));
            if (value < min) {
                min = value;
            }
        }
        double lre = min;
        if (min > 15) {
            lre = 15;
        } else if (min < 0) {
            lre = 0;
        }
        return lre;
    }
}
