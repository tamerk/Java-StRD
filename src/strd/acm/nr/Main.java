package strd.acm.nr;

import dnl.utils.text.table.TextTable;
import java.util.ArrayList;
import java.util.List;
import strd.data.nr.*;

public class Main {

    public static void test(NonlinearRegressionModel model,
            NonlinearRegressionDataset dataset, List<String> listRows) {
        model.setMaximumEvaluations(5000);
        model.setMaximumIterations(5000);
        model.setPredictorVariables(dataset.getPredictorVariables());
        model.setResponseVariable(dataset.getResponseVariable());
        model.setTolerance(1e-15);
        double[] calculated, certified;
        double logOfRelativeError;
        listRows.add(dataset.getDatasetName());

        model.setOptimizer(Optimizer.GaussNewton);
        certified = dataset.getParameterValues();

        model.estimate(dataset.getStartingValues1());
        calculated = model.getParameterValues();
        logOfRelativeError = model.logOfRelativeError(calculated, certified);
        listRows.add(String.format("%8.2f", logOfRelativeError));

        model.estimate(dataset.getStartingValues2());
        calculated = model.getParameterValues();
        logOfRelativeError = model.logOfRelativeError(calculated, certified);
        listRows.add(String.format("%8.2f", logOfRelativeError));

        model.setOptimizer(Optimizer.LevenbergMarquardt);
        certified = dataset.getParameterValues();

        model.estimate(dataset.getStartingValues1());
        calculated = model.getParameterValues();
        logOfRelativeError = model.logOfRelativeError(calculated, certified);
        listRows.add(String.format("%8.2f", logOfRelativeError));

        model.estimate(dataset.getStartingValues2());
        calculated = model.getParameterValues();
        logOfRelativeError = model.logOfRelativeError(calculated, certified);
        listRows.add(String.format("%8.2f", logOfRelativeError));
    }

    public static void main(String[] args) {
        String[] columnNames = new String[]{"Dataset", "GN1", "GN2", "LM1", "LM2"};
        Object[] row;
        Object[][] data = new Object[2][5];

        NonlinearRegressionDataset dataset;
        NonlinearRegressionModel model;
        List<String> listRows = new ArrayList<>();

        dataset = new Misra1aDataset();
        model = new Misra1aModel();
        test(model, dataset, listRows);
        row = new Object[5];
        row = listRows.toArray(row);
        listRows.clear();
        data[0] = row;

        dataset = new Chwirut2Dataset();
        model = new Chwirut2Model();
        test(model, dataset, listRows);
        row = new Object[5];
        row = listRows.toArray(row);
        listRows.clear();
        data[1] = row;

        TextTable textTable = new TextTable(columnNames, data);
        textTable.printTable();
    }
}
