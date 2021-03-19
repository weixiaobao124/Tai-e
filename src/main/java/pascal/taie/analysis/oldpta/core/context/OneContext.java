/*
 * Tai-e: A Static Analysis Framework for Java
 *
 * Copyright (C) 2020-- Tian Tan <tiantan@nju.edu.cn>
 * Copyright (C) 2020-- Yue Li <yueli@nju.edu.cn>
 * All rights reserved.
 *
 * Tai-e is only for educational and academic purposes,
 * and any form of commercial use is disallowed.
 * Distribution of Tai-e is disallowed without the approval.
 */

package pascal.taie.analysis.oldpta.core.context;

/**
 * Context with one element
 *
 * @param <T> type of context elements
 */
class OneContext<T> implements Context {

    private final T element;

    OneContext(T element) {
        this.element = element;
    }

    @Override
    public int depth() {
        return 1;
    }

    @Override
    public T element(int i) {
        if (i != 1) {
            throw new IllegalArgumentException(
                    "Context " + this + " doesn't have " + i + "-th element");
        }
        return element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneContext<?> that = (OneContext<?>) o;
        return element.equals(that.element);
    }

    @Override
    public int hashCode() {
        return element.hashCode();
    }

    @Override
    public String toString() {
        return "[" + element + "]";
    }
}