package oop


/**
 * 1. loopper 는 돌면서 user를 체크한다
 */
abstract class Looper {
    companion object{
        var users = hashSetOf<User>()
    }


    /**
     속성은 없고 기능만 있으면 -> 인터페이스
     추상 레이어에서 처리해야할 부분이 속성을 가지고 있으면 -> 추상클래스
     */
    var isRunning=false
    fun start(){
        isRunning = true
        started()
    }
    fun end(){
        isRunning = false
        ended()
    }

    protected abstract fun started()
    protected abstract fun ended()
}