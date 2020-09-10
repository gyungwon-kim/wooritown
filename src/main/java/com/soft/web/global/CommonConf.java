package com.soft.web.global;

public class CommonConf {
    /**
     * 세션 관련 상수값
     */
    public static class session {
        /** 세션에 저장되는 사용자정보 */
        public static final String SESSION_KEY_USER = "_sessionUser";
        
        /** 세션에 저장되는 관리자정보 */
        public static final String SESSION_KEY_ADMIN = "_sessionAdmin";

        /** 세션 타임아웃(초) */
        public static final int SESSION_TIMEOUT_SECOND = 60 * 60;
    }
}
