package ru.nerator.nonlineq;

import ru.nerator.nonlineq.model.NumericMethods;
import ru.nerator.nonlineq.util.Formatter;

public class MainAppConsole {

	public static void main(String[] args) {
		if (args[0].equals("--help")) {
			showUsage();
			System.exit(0);
		}
		if (args.length == 5) {
			double a = 0.0;
			double b = 0.0;
			int n = 0;
			double e = 0.0;
			try {
				a = Double.parseDouble(args[1]);
				b = Double.parseDouble(args[2]);
				n = Integer.parseInt(args[3]);
				e = Double.parseDouble(args[4]);
			} catch (NumberFormatException ex) {
				invalidArgs();
			}
			switch (args[0]) {
				case "bisec":
					System.out.println(Formatter.formatTuple(
							NumericMethods.rootBisec(a, b, n, e)));
					break;
				case "secant":
					System.out.println(Formatter.formatTuple(
							NumericMethods.rootSecant(a, b, n, e)));
					break;
				case "newton":
					System.out.println(Formatter.formatTuple(
							NumericMethods.rootNewton(a, b, n, e)));
					break;
				case "iter":
					System.out.println(Formatter.formatTuple(
							NumericMethods.rootIter(a, b, n, e)));
					break;
				default:
					invalidArgs();
					break;
			}
		} else {
			invalidArgs();
		}
		System.exit(0);
	}

	private static void invalidArgs() {
		System.out.println("Invalid arguments.");
		showUsage();
		System.exit(0);
	}

	private static void showUsage() {
		System.out.println("Usage:");
		System.out.println("java -jar nonlineq method a b n e");
		System.out.println();
		System.out.println("method can be: bisec, secant, newton, iter;");
		System.out.println("[a,b] - root interval;");
		System.out.println("n - parameter in formula 2^x+nx-10;");
		System.out.println("e - precision.");
	}

}
