package oop

import java.time.Instant

class User(
    private val name:String
) {
    init {
        Looper.users.add(this)
    }
    private val items = hashSetOf<Item>()
    fun addItem(vararg item:Item){
        items += item
    }

    fun send(now:Instant){
        // 이 send 는 또 item으로 책임 전가
        items.forEach{item -> item.send(now)}
    }
}