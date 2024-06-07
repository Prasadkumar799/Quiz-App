package com.example.quizapp;
public class QuestionAnswer {
    public static String questions[]={
           "Who invented Java Programming?",
           "Which component is used to compile, debug and execute the java programs?",
           "What is the extension of java code files?",
           "which of the following is a superclass of every class in java?",
           "Which one of the following is not an access modifier?"
    };
    public static String choices[][]={
            {"Guido van Rossum","James Gosling","Dennis Richie","Bjarne Stroustrup"},
            {"JRE","JIT","JDK","JVM"},
            {".js",".txt",".class",".java"},
            {"ArrayList","Abstract class","Object class","String" },
            {"Protected","Void","Public","Private"}
    };
    public static String correctanswer[]={
            "James Gosling","JDK",".java","Object class","Void"
    };
}
