package oop

import java.time.Clock


/**
 * 1. loopper 는 돌면서 user를 체크한다
 */
open class Looper (
    private val started:(Looper) ->Unit
    private val ended:(Looper) ->Unit
){
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
        started(this)
    }
    fun end(){
        isRunning = false
        ended(this)
    }

    val threadLooper =  Looper({
        val thread = Thread{
            while (it.isRunning && !Thread.currentThread().isInterrupted){
                val now = Clock.systemDefaultZone()

                Looper.users.forEach { it.send(now) }
                Thread.sleep(1000)
            }
        }
        if(!thread.isAlive) thread.start()
    }) {}

}