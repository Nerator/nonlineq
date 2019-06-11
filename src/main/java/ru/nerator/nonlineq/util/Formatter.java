package ru.nerator.nonlineq.util;

import ru.nerator.nonlineq.model.MethodResult;

/**
 * Вспомогательный класс для форматирования количества шагов
 * и результата.
 *
 * @author nerator
 */
public class Formatter {

    private Formatter() {
    }

    /**
     * Метод для форматирования числа шагов в строку.
     *
     * @param n количество шагов
     * @return строка вида "n шагов" с верным склонением.
     */
    public static String step(int n) {
        if (n > 10 && n < 21) {
            return n + " шагов";
        } else {
            int k = n % 10;
            switch (k) {
                case 1:
                    return n + " шаг";
                case 2:
                case 3:
                case 4:
                    return n + " шага";
                default:
                    return n + " шагов";
            }
        }
    }

    /**
     * Метод для форматирования результа в строку.
     *
     * @param res объект MethodResult, представляющий результат.
     * @return форматированная строка результата.
     */
    public static String formatTuple(MethodResult res) {
        if (res.isEmpty()) {
            return "Невозможно определить корень.";
        } else if (res.haveStart()) {
            return "В качестве начальной точки выбрана точка " + res.getStart() + "\n" +
                    "Корень равен " + res.getRoot() + ", найден за " + Formatter.step(res.getSteps());
        } else {
            return "Корень равен " + res.getRoot() + ", найден за " + Formatter.step(res.getSteps());
        }
    }

}
