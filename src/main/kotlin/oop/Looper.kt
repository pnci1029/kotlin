package oop
/**
 * 1. loopper 는 돌면서 user를 체크한다
 */
interface Looper {
    companion object{
        var users = hashSetOf<User>()
    }
    fun start()
    fun end()
}