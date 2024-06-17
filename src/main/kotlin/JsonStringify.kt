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
}