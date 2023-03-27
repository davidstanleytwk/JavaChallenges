package com.stanley;

public class MissingPostiveFactory {

    public static MissingPositive getMissPositiveClass(String type)
    {
        return switch (type) {
            case "heap" -> new MissingPositiveHeap();
            case "solution" -> new MissingPositiveSolution();
            case "arrays" -> new MissingPositiveArrays();
            default -> throw new RuntimeException("Invalid type" + type);
        };
    }
}
