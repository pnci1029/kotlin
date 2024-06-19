import kotlin.reflect.KProperty

class JsonStringify {

    fun <T : Any> stringifyV0(target: T): String {
        /**
         * KClass 코틀린 클래스 정의
         * 클래스::class / 인스턴스::class
         */
        target::class.members
            //Kproperty의 속성만 필터하는 함수. 이렇게 사용 안하면 두번 필터링해야함
            .filterIsInstance<KProperty<*>>()
//            .forEach{it}
        return ""

    }


    fun <T : Any> stringifyV1(target: T): String {
        val builder = StringBuilder()
        builder.append('{')
        /**
         * KClass 코틀린 클래스 정의
         * 클래스::class / 인스턴스::class
         */
        target::class.members
            //Kproperty의 속성만 필터하는 함수. 이렇게 사용 안하면 두번 필터링해야함
            .filterIsInstance<KProperty<*>>().forEach {
                builder.append(it.name, ':')
                val value = it.getter.call(target)
                builder.append(value, ',')
            }
        builder.append('}')
        return "$builder"
    }

    fun <T : Any> stringifyV2(target: T): String {
        val builder = StringBuilder()
        builder.append('{')
        /**
         * KClass 코틀린 클래스 정의
         * 클래스::class / 인스턴스::class
         */
        target::class.members
            //Kproperty의 속성만 필터하는 함수. 이렇게 사용 안하면 두번 필터링해야함
            .filterIsInstance<KProperty<*>>()
            .joinTo(builder,",","{","}"){
                val value = it.getter.call(target)
                "${jsonString(it.name)}:${if(value is String) jsonString(value) else value}"

            }
        builder.append('}')
        return "$builder"
    }

    class Json0(val a:Int, val b:String)
    class Json1(@Ex val a:Int, @Name(name = "title") val b:String)

    /**
     * {"title":"bdbdf"}
     * 로 나오길 원함
     */

    fun main(args:Array<String>){
        println(stringifyV1(Json0(11,"bdbdf")))
    }
}