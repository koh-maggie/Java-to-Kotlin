package com.lannstark.lec10

class KotlinPenguin(
    species: String ,

    // 상속과 마찬가지로 implements 도 : 을 사용하기 때문에 , 로 구분하면 됨.
) : KotlinAnimal (species , 2) , KotlinSwimable , KotlinFlyable {

    private val wingCount: Int = 2

    override fun move() {
        println("펭귄이 움직입니다~ 꿱꿱")
    }


    /*
    - 하나의 프로퍼티로 볼 수 있음.
    - custom getter 프로퍼티를 만들게 되면 반드시 이미 생성된 getter 쪽에 open 을 해줘야함.
        ( = 추상 프로퍼티가 아니라면, 상속 받을 때 open 을 꼭 붙여야 함.
    */
    override val legCount : Int
        get() = super.legCount + this.wingCount

    override fun act() {
        super<KotlinSwimable>.act()
        super<KotlinFlyable>.act()
    }

}