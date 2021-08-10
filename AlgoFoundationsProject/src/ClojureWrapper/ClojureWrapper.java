package ClojureWrapper;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class ClojureWrapper {

    private IFn tailRecursiveFactorial;
    private IFn recursiveFactorial;
    private IFn tailRecursiveFibonacci;
    private IFn recursiveFibonacci;

    public ClojureWrapper() {
        this.setup();
    }

    public void setup() {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("clojuredemo.core"));

        tailRecursiveFactorial = Clojure.var("src.clojuredemo.core", "tail-recursive-factorial");
        recursiveFactorial = Clojure.var("src.clojuredemo.core", "recursive-factorial");
        tailRecursiveFibonacci = Clojure.var("src.clojuredemo.core", "tail-recursive-fibonacci");
        recursiveFibonacci = Clojure.var("src.clojuredemo.core", "recursive-fibonacci");
    }

    public long tailRecursiveFactorial(long num) {
        return (long)tailRecursiveFactorial.invoke(num);
    }

    public long recursiveFactorial(long num) {
        return (long)recursiveFactorial.invoke(num);
    }

    public long tailRecursiveFibonacci(long num) {
        return (long)tailRecursiveFibonacci.invoke(num);
    }

    public long recursiveFibonacci(long num) {
        return (long)recursiveFibonacci.invoke(num);
    }
}
