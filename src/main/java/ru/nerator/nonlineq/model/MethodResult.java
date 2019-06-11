package ru.nerator.nonlineq.model;

/**
 * Ad-hoc реализация кортежа для хранения результатов работы
 * вычислительных методов.
 *
 * @author nerator
 */
public class MethodResult {
    
    private Double root;
    private Integer steps;
    private Integer start;

    /**
     * Конструктор для результата работы метода бисекций и метода хорд.
     *
     * @param r найденный корень.
     * @param s количество шагов.
     */
    public MethodResult(double r, int s) {
        this.root = r;
        this.steps = s;
        this.start = null;
    }

    /**
     * Конструктор для результа работы метода Ньютона и метода простых итераций.
     *
     * @param r   найденный корень.
     * @param stp количество шагов.
     * @param str приближение корня, откуда метод начал работу.
     */
    public MethodResult(double r, int stp, int str) {
        this.root = r;
        this.steps = stp;
        this.start = str;
    }

    /**
     * Конструктор без параметров, используется в случае,
     * если решение найти не удается.
     */
    public MethodResult() {
        this.root = null;
        this.steps = null;
        this.start = null;
    }

    /**
     * Возвращает значение корня.
     *
     * @return найденный корень.
     */
    public double getRoot() {
        return root;
    }

    /**
     * Возвращает количество шагов, за которое найден корень.
     *
     * @return количество шагов.
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Возвращает начальную точку (для методов Ньютона и простых итераций)
     *
     * @return начальная точка.
     */
    public int getStart() {
        return start;
    }

    /**
     * Определяет, имеется ли в кортеже начальная точка.
     *
     * @return true, если начальная точка есть; false в противном случае.
     */
    public boolean haveStart() {
        return start != null;
    }

    /**
     * Определяет, является ли кортеж пустым, т.е содержит ли он решение.
     *
     * @return true, если кортеж пустой; false в противном случае.
     */
    public boolean isEmpty() {
        return root == null;
    }

}
