package strd.acm.nr;

import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.util.FastMath;

/**
 * class for Misra1a model
 *
 * @author Tamer Kulaksizoglu
 */
public class Misra1aModel extends NonlinearRegressionModel {

    public Misra1aModel() {
        super();
        numberOfParameters = 2;
    }

    @Override
    public MultivariateVectorFunction getModelFunction() {
        return (double[] parameters) -> {
            double b1 = parameters[0];
            double b2 = parameters[1];
            double[] x = predictorVariables[0];
            for (int i = 0; i < sampleSize; i++) {
                fittedValues[i] = b1 * (1 - FastMath.exp(-b2 * x[i]));
            }
            return fittedValues;
        };
    }

    @Override
    public MultivariateMatrixFunction getModelFunctionJacobian() {
        return (double[] parameters) -> {
            double b1 = parameters[0];
            double b2 = parameters[1];
            DerivativeStructure dsb1 = new DerivativeStructure(2, 1, 0, b1);
            DerivativeStructure dsb2 = new DerivativeStructure(2, 1, 1, b2);
            double[] x = predictorVariables[0];
            for (int i = 0; i < sampleSize; i++) {
                DerivativeStructure func = dsb2.negate().multiply(x[i]).exp().negate().add(1).multiply(dsb1);
                jacobian[i][0] = func.getPartialDerivative(1, 0); // derivative w.r.t. b1
                jacobian[i][1] = func.getPartialDerivative(0, 1); // derivative w.r.t. b2
            }
            return jacobian;
        };
    }
}
