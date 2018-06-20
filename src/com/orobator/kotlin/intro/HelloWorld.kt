package com.orobator.kotlin.intro

/**
 * @param args Command Line arguments
 */
fun main(args: Array<String>) {
    val scope = "World"
    println("Hello $scope!") // Kotlin supports String interpolation

    ////////////////
    /* val vs var */
    ////////////////

    val name = "Andrew" // read-only variable
    var age = 24 // read & write variable

    age = 25 // Allowed, because this is a var
    // name = "Dan" // Not allowed because this is a val


    ////////////////////
    /* Type Inference */
    ////////////////////

    val pet: String = "Husky" // Can optionally specify the type
    val food = "Tomato" // This is fine as well. The compiler knows this is a String


    /////////////////
    /* Basic Types */
    /////////////////

    // Can iterate over characters
    for (c in "Kotlin Rocks!") {
        print(c)
    }
    println()

    // String concatenation
    val concatString0 = "Two " + "strings"
    println("concatString0: $concatString0")

    val concatString1 = "String and Int" + 42
    println("concatString1: $concatString1")

    val stringTemplate = "Template ${14 + 28}"
    println("stringTemplate: $stringTemplate")

    val rawString = """
        for (c in "foo")
            print(c)

        // Looks like a comment, but is still in the string.
        """

    println("Raw String:\n $rawString")

    val withoutMargins = """ABC
                           |123
                           |456
         """.trimMargin() // prints ABC\n123\n456

    println("Without margins:\n$withoutMargins")

    val myDouble: Double = 42.0 // 64 bits wide
    val myFloat: Float = 42f // 32 bits wide

    val myLong: Long = 42L // 64 bits wide
    val myInt: Int = 42 // 32 bits wide
    val myShort: Short = 42 // 16 bits wide
    val myByte: Byte = 42 // 8 bits wide

    val hexadecimalInt: Int = 0x0F
    val binaryLong: Long = 0b101
    val oneMillion = 1_000_000

    // Everything is an object! Smaller types not subtypes of larger types.

    // val impossible: Long = myInt
    val castedLong: Long = myInt.toLong()
    println("Casted Long = $castedLong")

    // Numbers are represented as primitives unless generics or nullability is involved.


    /////////////////
    /* Nullability */
    /////////////////

    var nullableFruit: String? = "Pomegranate"
    nullableFruit = null

    var nonNullFruit: String = "Grape"
    nonNullFruit = "Apple" // Okay because it isn't null
    // nonNullFruit = null // Compiler Error

    // Safe call operator, avoids NullPointerException
    val nullableLength: Int? = nullableFruit?.length
    println("Nullable Length: $nullableLength")

    try {
        val nullLength: Int = nullableFruit!!.length
    } catch (e: NullPointerException) {
        println("Nullable fruit was null")
    }

    // Setting a variable to an expression.
    val nonNullLength: Int = if (nullableFruit == null) 0 else nullableFruit.length

    // Kotlin's Elvis operator is short form for the above
    val nonNullLength2: Int = nullableFruit?.length ?: 0

    println("nonNullLength2 = $nonNullLength2")
}