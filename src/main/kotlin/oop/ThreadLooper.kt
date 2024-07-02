//package oop
//
//import java.time.Clock
//
//object ThreadLooper: Looper() {
//    /**
//     * lazy -> 지연생성델리게이트
//     * 중괄호에 포함된 내용을 thread라는 속성이 사용되기전까지
//     * 사용되지 않음
//     */
//    private val thread by lazy{
//        Thread{
//            // 안전한 스레드 종료
//            while(isRunning && !Thread.currentThread().isInterrupted){
//                val now = Clock.systemDefaultZone()
//
//                // send 하는건 user에게 책임 전가
//                Looper.users.forEach { it.send(now) }
//                Thread.sleep(1000)
//            }
//        }
//    }
//
//
//    /**
//     * V2
//     */
//    override fun started() {
//        if(!thread.isAlive) thread.start()
//    }
//
//    override fun ended() {
//        TODO("Not yet implemented")
//    }
//    /**
//     * V1
//     */
////    var isRunning = false
////        private set
////
////    override fun start() {
////        isRunning = true
////        if(!thread.isAlive) thread.start()
////    }
////
////    override fun end() {
////        isRunning = false
////    }
//
//
//}