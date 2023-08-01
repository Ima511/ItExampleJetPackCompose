package com.example.itexamplejetpackcompose

fun main(){

    reverseString("Hello"){
        it.reversed()
    }

    // passing anonymous function as a parameter to hof

    val subtr = fun(a:Int, b:Int):Int{
        return a-b
    }

    hof4(subtr)

    println(hof5()())

    // Returning value from hof
    println(hof6()())

    // Passing a regular function of HOF
    hof7 (::messageFun)
}

fun reverseString(str: String, myLambda: (String) -> (String)){
    val result = myLambda(str)
    println(result)
}

fun hof4(subtract: (Int, Int) -> Int):Unit{
    val result = subtract(77,10)
    println("Subtraction result: $result")
}

fun hof5() : () -> String{
    val msg = fun(): String{
        return "Hi from hof5"
    }
    return msg
}

fun hof6(): () -> String{
    return ::messageFun
}

fun messageFun(): String {
    return "Hi From The Regular Function"
}

fun hof7(regFun: () -> String){
    println(regFun())
}
