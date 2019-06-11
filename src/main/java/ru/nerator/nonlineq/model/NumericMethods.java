package ru.nerator.nonlineq.model;

/**
 * Реализация численных методов для нахождения корня уравнения f(x)=0, где
 * <img style="vertical-align:middle"
 * src={@docRoot}/../../resources/main/ru/nerator/nonlineq/view/img/function.png>
 *
 * @author nerator
 */
public class NumericMethods {

    private NumericMethods() {
    }

    /**
     * Возвращает значение функции f в точке x
     *
     * @param x параметр функции.
     * @param n параметр N.
     * @return значение функции в точке x.
     */
    public static double func(double x, int n) {
        return Math.pow(2, x) + n * x - 10;
    }

    /**
     * Возвращает значение производной функции f в точке x
     *
     * @param x параметр функции.
     * @param n параметр N.
     * @return значение производной функции в точке x.
     */
    public static double derFunc(double x, int n) {
        return Math.pow(2, x) * Math.log(2) + n;
    }

    /**
     * Возвращает значение второй производной функции f в точке x
     *
     * @param x параметр функции.
     * @return значение второй производной функции в точке x.
     */
    public static double der2Func(double x) {
        return Math.pow(2, x) * Math.log(2) * Math.log(2);
    }

    /**
     * Возвращает значение функции \u03c6 в точке x. Функция \u03c6(x) получается
     * путём преобразования уравнения f(x)=0 в уравнение \u03c6(x)=x.
     *
     * @param x параметр функции.
     * @param n параметр N.
     * @return значение функции \u03c6 в точке x.
     */
    public static double phi(double x, int n) {
        return (10 - Math.pow(2, x)) / n;
    }

    /**
     * Возвращает значение производной функции \u03c6 в точке x. Функция \u03c6(x) получается
     * путём преобразования уравнения f(x)=0 в уравнение \u03c6(x)=x.
     *
     * @param x параметр функции.
     * @param n параметр N.
     * @return значение производной функции \u03c6 в точке x.
     */
    public static double derPhi(double x, int n) {
        return -Math.pow(2, x) * Math.log(2) / n;
    }

    /**
     * Реализация алгоритма нахождения корня функции методом бисекций.
     *
     * @param a левая граница корня
     * @param b правая граница корня
     * @param n параметр N функции
     * @param e точность
     * @return кортеж, содержащий корень и количество шагов, за которое получен корень.
     */
    public static MyTuple rootBisec(double a, double b, int n, double e) {
        int k = 0;

        while (Math.abs(a - b) > e) {
            k++;
            double c = (a + b) / 2;
            if (func(a, n) * func(c, n) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return new MyTuple(a, k);
    }

    /**
     * Реализация алгоритма нахождения корня функции методом хорд.
     *
     * @param a левая граница корня
     * @param b правая граница корня
     * @param n параметр N функции
     * @param e точность
     * @return кортеж, содержащий корень и количество шагов, за которое он получен.
     */
    public static MyTuple rootSecant(double a, double b, int n, double e) {
        int k = 0;
        double oldC, newC = 0;
        do {
            oldC = newC;
            newC = (a * func(b, n) - b * func(a, n)) / (func(b, n) - func(a, n));
            if (func(a, n) * func(newC, n) < 0) {
                b = newC;
            } else {
                a = newC;
            }
            k++;
        } while (Math.abs(oldC - newC) > e);
        return new MyTuple(newC, k - 1);
    }

    /**
     * Реализация алгоритма нахождения корня функции методом Ньютона.
     *
     * @param a левая граница корня
     * @param b правая граница корня
     * @param n параметр N функции
     * @param e точность
     * @return кортеж, содержащий корень, количество шагов, за которое он получен
     * и начальную точку работы метода.
     */
    public static MyTuple rootNewton(double a, double b, int n, double e) {
        // выберем начальную точку
        double x;
        if (func(a, n) * der2Func(a) > 0) {
            x = a;
        } else if (func(b, n) * der2Func(b) > 0) {
            x = b;
        } else {
            return new MyTuple(); // невозможно определить корень
        }
        int start = (int) x;

        int k = 0;
        while (Math.abs(func(x, n)) > e) {
            k++;
            x = x - func(x, n) / derFunc(x, n);
        }
        return new MyTuple(x, k, start);
    }

    /**
     * Реализация алгоритма нахождения корня функции методом простых итераций.
     *
     * @param a левая граница корня
     * @param b правая граница корня
     * @param n параметр N функции
     * @param e точность
     * @return кортеж, содержащий корень, количество шагов, за которое он получен
     * и начальную точку работы метода.
     */
    public static MyTuple rootIter(double a, double b, int n, double e) {
        // выберем начальную точку
        double x;
        if (Math.abs(derPhi(a, n)) < 1) {
            if (Math.abs(derPhi(b, n)) < 1) {
                x = Math.abs(derPhi(a, n)) < Math.abs(derPhi(b, n)) ? a : b;
            } else {
                x = a;
            }
        } else {
            if (Math.abs(derPhi(b, n)) < 1) {
                x = b;
            } else {
                return new MyTuple(); // невозможно определить корень
            }
        }
        int start = (int) x;

        int k = 0;
        while (Math.abs(func(x, n)) > e) {
            k++;
            x = phi(x, n);
        }
        return new MyTuple(x, k, start);
    }

}
