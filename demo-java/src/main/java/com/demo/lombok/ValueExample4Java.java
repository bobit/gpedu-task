package com.demo.lombok;

import java.util.Arrays;

/**
 * https://blog.csdn.net/jiangjiandecsd/article/details/81114704
 *
 * @Author: zhangb
 * @Date: 2019/1/2 11:58
 */
public class ValueExample4Java {
    private final String name;
    private int age;
    private final double score;
    protected final String[] tags;

    @java.beans.ConstructorProperties({"name", "age", "score", "tags"})
    public ValueExample4Java(String name, int age, double score, String[] tags) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.tags = tags;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public double getScore() {
        return this.score;
    }

    public String[] getTags() {
        return this.tags;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ValueExample4Java)) return false;
        final ValueExample4Java other = (ValueExample4Java) o;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getAge() != other.getAge()) return false;
        if (Double.compare(this.getScore(), other.getScore()) != 0) return false;
        if (!Arrays.deepEquals(this.getTags(), other.getTags())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getAge();
        final long $score = Double.doubleToLongBits(this.getScore());
        result = result * PRIME + (int) ($score >>> 32 ^ $score);
        result = result * PRIME + Arrays.deepHashCode(this.getTags());
        return result;
    }

    @Override
    public String toString() {
        return "ValueExample4Java(name=" + getName() + ", age=" + getAge() + ", score=" + getScore() + ", tags=" + Arrays.deepToString(getTags()) + ")";
    }

    ValueExample4Java withAge(int age) {
        return this.age == age ? this : new ValueExample4Java(name, age, score, tags);
    }

    public static final class Exercise<T> {
        private final String name;
        private final T value;

        private Exercise(String name, T value) {
            this.name = name;
            this.value = value;
        }

        public static <T> Exercise<T> of(String name, T value) {
            return new Exercise<T>(name, value);
        }

        public String getName() {
            return this.name;
        }

        public T getValue() {
            return this.value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof Exercise)) return false;
            final Exercise<?> other = (Exercise<?>) o;
            final Object this$name = this.getName();
            final Object other$name = other.getName();
            if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
            final Object this$value = this.getValue();
            final Object other$value = other.getValue();
            if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final Object $name = this.getName();
            result = result * PRIME + ($name == null ? 43 : $name.hashCode());
            final Object $value = this.getValue();
            result = result * PRIME + ($value == null ? 43 : $value.hashCode());
            return result;
        }

        @Override
        public String toString() {
            return "ValueExample4Java.Exercise(name=" + getName() + ", value=" + getValue() + ")";
        }
    }
}