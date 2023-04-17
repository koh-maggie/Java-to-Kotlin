package com.lannstark.lec10

abstract class KotlinAnimal (
   protected val species : String,
   protected open val legCount : Int
) {

    abstract fun move()
}