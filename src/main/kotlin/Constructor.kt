class Constructor {


    /**
     * 자바에서 많이 보던 형태의 생성자
     */

    // 메인 클래스명 뒤에 괄호를 통해 생성자를 바로 생성 가능 -> 주생성자
    class TestUserV1(user: String, pw: String){
        private val user: String
        private val pw: String

        /**
         * 메인 클래스의 중괄호 안에 생성되는 생성자를
         * 부생성자라고 한다.
         *
         * 주생성자와 시그니쳐가 동일한 생성자가 존재하기 떄문에
         * 컴파일 오류가 남
         * 따라서 주석 처리
         */
//        constructor(user: String, pw: String){
//            this.user = user
//            this.pw = pw
//        }


        // 부생성자 오버로딩
        /**
         * 부생성자 생성 시 반드시 주생성자를 호출해야함
         */
        constructor(user:String) :this(user +"+","")

        //            this.user = user
//            this.pw = ""
        init {
            this.user = user + "-"
            this.pw = ""
        }
        /**
         * 초기화 블록 생성
         * 부생성자가 주생성자를 호출하기 떄문에 user +-가 나온다.

         */

    }





    /**
     * 코틀린에서는 멤버변수의 속성을 주 생성자의 인자로 선언할 수 있다.
     * 주 생성자에 멤버변수 속성을 정의함으로써
     * this.user = user 같은 생성 구문 모두 생략가능
     */
    class TestUserV2(
        private val user: String,
        private val pw: String
    ){
    }
}