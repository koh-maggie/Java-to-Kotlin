package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class KotlinFilePrinter {

    /*
    Java 와는 다르게 IOException 을 throw 하지 않아도 정상 동작한다.
    Kotlin 에서는 Checked Exception 과 Unchecked Exception을 구분하지 않음.
    모두 Unchecked Exception 임.
     */
    fun readFile2() {
        val currentFile = File(".")
        val file = File(currentFile.absolutePath +"/a.txt")
        val reader = BufferedReader(FileReader(file))

        println(reader.readLine())

        reader.close()

    }


    /*
    Kotlin 에서는 try with resources 구문이 없음.
    대신, use 라는 inline 확장함수를 사용해야 함.
    */
    fun readFile(path: String) {
        BufferedReader(FileReader(path)).use {
            reader -> println(reader.readLine())

        }

    }

}