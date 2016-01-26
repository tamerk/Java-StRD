## Java-StRD ##
This project aims to check the accuracy of Java numerical libraries against the [Statistical Reference Datasets](http://www.itl.nist.gov/div898/strd/).

## Libraries ##
- [Apache Commons Mathematics Library 3.6](http://commons.apache.org/proper/commons-math/)

## Datasets ##

Accuracy is measured by the [log of relative error](http://www.itl.nist.gov/div898/strd/nls/nls_info.shtml).

### Nonlinear Regression ###

GN1: Gauss-Newton algorithm using starting values 1<br>
GN2: Gauss-Newton algorithm using starting values 2<br>
LM1: Levenberg-Marquardt algorithm using starting values 1<br>
LM2: Levenberg-Marquardt algorithm using starting values 2<br>

<pre>
__________________________________________________
| Dataset | GN1     | GN2     | LM1     | LM2     |
|=================================================|
| Misra1a |    11.13|    11.13|     9.78|    10.13|
| Chwirut2|     9.36|     8.58|     6.18|     7.24|
</pre>




