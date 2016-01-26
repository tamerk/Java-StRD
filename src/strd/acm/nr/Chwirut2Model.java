package strd.acm.nr;

import org.apache.commons.math3.analysis.MultivariateMatrixFunction;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.util.FastMath;

/**
 * class for Chwirut2 model
 *
 * @author Tamer Kulaksizoglu
 */
public class Chwirut2Model extends NonlinearRegressionModel {

    public Chwirut2Model() {
        super();
        numberOfParameters = 3;
    }

    @Override
    public MultivariateVectorFunction getModelFunction() {
        return (double[] parameters) -> {
            double b1 = parameters[0];
            double b2 = parameters[1];
            double b3 = parameters[2];
            double[] x = predictorVariables[0];
            for (int i = 0; i < sampleSize; i++) {
                fittedValues[i] = FastMath.exp(-b1 * x[i]) / (b2 + b3 * x[i]);
            }
            return fittedValues;
        };
    }

    @Override
    public MultivariateMatrixFunction getModelFunctionJacobian() {
        return (double[] parameters) -> {
            double b1 = parameters[0];
            double b2 = parameters[1];
            double b3 = parameters[2];
            DerivativeStructure dsb1 = new DerivativeStructure(3, 1, 0, b1);
            DerivativeStructure dsb2 = new DerivativeStructure(3, 1, 1, b2);
            DerivativeStructure dsb3 = new DerivativeStructure(3, 1, 2, b3);
            double[] x = predictorVariables[0];
            for (int i = 0; i < sampleSize; i++) {
                DerivativeStructure funcn = dsb1.negate().multiply(x[i]).exp();
                DerivativeStructure funcd = dsb3.multiply(x[i]).add(dsb2);
                DerivativeStructure func = funcn.divide(funcd);
                jacobian[i][0] = func.getPartialDerivative(1, 0, 0); // derivative w.r.t. b1
                jacobian[i][1] = func.getPartialDerivative(0, 1, 0); // derivative w.r.t. b2
                jacobian[i][2] = func.getPartialDerivative(0, 0, 1); // derivative w.r.t. b3
            }
            return jacobian;
        };
    }
}
