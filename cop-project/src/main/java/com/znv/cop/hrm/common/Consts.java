package com.znv.cop.hrm.common;

/**
 * 常量，枚举定义
 * @version v0.0.1
 */
public class Consts {

    public static final String SERVICE_CODE = "DTL";

    public static final String SERVICE_NAME = "DTL数据处理";

    public static final int COMPLETED = 1;

    public static final int UNCOMPLETED = 0;

    public static final String RAM_RULE_PREFIX = "RAM_CFG_RULE";

    /**
     * 告警流程
     */
    public static class Alarm {

        /** 告警类型 */
        public static final int ALARM_TYPE = 0;

        /** 中断类型 */
        public static final int EXCEPTION_TYPE = 1;
    }

    /**
     * 通知流程
     */
    public static class Notify {

        /** GET请求 */
        public static final int REQUEST_TYPE_GET = 0;

        /** POST请求 */
        public static final int REQUEST_TYPE_POST = 1;

        /** 告警通知 */
        public static final int BUSINESS_TYPE_ALARM = 101;

        /** 中断通知 */
        public static final int BUSINESS_TYPE_EXCEPTION = 102;

        /** 重试初始状态 */
        public static final String RETRY_STATUS_INIT = "0";

        /** 重试执行状态 */
        public static final String RETRY_STATUS_MARKED = "1";

        /** 重试成功状态 */
        public static final String RETRY_STATUS_SUCCESS = "2";

        /** 重试失败状态 */
        public static final String RETRY_STATUS_FAILED = "3";
    }

}
