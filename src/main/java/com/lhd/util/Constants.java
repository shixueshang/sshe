package com.lhd.util;

/**
 * Created by lihongde on 2016/9/8 11:47
 */
public class Constants {

    /**
     * 默认分页起始页
     */
    public static final Integer DEFAULT_PAGE = 1;
    /**
     * 默认页面大小
     */
    public static final Integer DEFAULT_PAGE_SIZE = 25;


    /**
     * 服务器返回状态
     * @author lihongde
     *
     */
    public static class JSON_RESULT{
        /**
         * 成功
         */
        public static int OK = 200;

        /**
         * 客户端请求无效
         */
        public static int BAD_REQUEST = 400;

        /**
         * token失效或非法，需要重新登录
         */
        public static int NEED_LOGIN = 401;

        /**
         * 普通失败，message中带原因
         */
        public static int FAILED = 403;

        /**
         * 未找到请求页面
         */
        public static int NOT_FOUND = 404;

        /**
         * 服务器错误
         */
        public static int SERVER_ERROR = 500;

    }

    /**
     * 是否
     */
    public static class YES_OR_NO{

        /**
         * 是
         */
        public static final Integer YES = 1;

        /**
         * 否
         */
        public static final Integer NO = 0;

    }

}
