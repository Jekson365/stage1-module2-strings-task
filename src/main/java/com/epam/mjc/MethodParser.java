package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     * 1. access modifier - optional, followed by space: ' '
     * 2. return type - followed by space: ' '
     * 3. method name
     * 4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     * accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     * private void log(String value)
     * Vector3 distort(int x, int y, int z, float magnitude)
     * public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        StringBuilder sb = new StringBuilder(signatureString);
        List<MethodSignature.Argument> res = new ArrayList<>();


        String[] sliced_part_1 = sb.substring(0,sb.indexOf("(")).split(" ");
        String[] sliced_part_2 = sb.substring(sb.indexOf("("),sb.length()).split(",");

        // results
        String accessModifier = sliced_part_1[0];
        String returnType = sliced_part_1[1];
        String methodName  = sliced_part_1[2];
        MethodSignature methodSignature = new MethodSignature(methodName,res);
        System.out.println(accessModifier);
        System.out.println(returnType);
        System.out.println(methodName);
        for (int i = 1; i < sliced_part_2.length - 1;i++) {

            MethodSignature.Argument arg3 = new MethodSignature.Argument(
                    sliced_part_2[i].split(" ")[0],
                    sliced_part_2[i].split(" ")[1]
            );
            res.add(arg3);
        }

        // create arguments list
        MethodSignature m = new MethodSignature("dsad",res);

        String slicedFirst = sliced_part_2[0].replace("(","");
        String slicedLast = sliced_part_2[sliced_part_2.length - 1].replace(")","");

        // first type and name;
        String firstType = slicedFirst.split(" ")[0];
        String firstName = slicedFirst.split(" ")[1];

        // last type and name;
        String lastType = slicedLast.split(" ")[0];
        String lastName = slicedLast.split(" ")[1];

        MethodSignature.Argument arg = new MethodSignature.Argument(firstType,firstName);
        MethodSignature.Argument arg2 = new MethodSignature.Argument(lastType,lastName);

        res.add(arg);
        res.add(arg2);

        methodSignature.setMethodName(methodName);
        methodSignature.setReturnType(returnType);
        methodSignature.setAccessModifier(accessModifier);


        return methodSignature;
    }

    public static void main(String[] args) {
        MethodParser m = new MethodParser();
        m.parseFunction("private void log(String logString, LogLevel level, Context context)");
    }


}
