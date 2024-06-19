class Constructor {


    /**
     * 자바에서 많이 보던 형태의 생성자
     */
    class TestUser{
        private val user: String
        private val pw: String

        /**
         * 메인 클래스의 중괄호 안에 생성되는 생성자를
         * 부생성자라고 한다.
         */
        constructor(user: String, pw: String){
            this.user = user;
            this.pw = pw;
        }

        // 부생성자 오버로딩
        constructor(user:String){
            this.user = user
            this.pw = ""
        }

    }
}