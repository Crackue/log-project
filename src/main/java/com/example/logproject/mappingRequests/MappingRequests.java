package com.example.logproject.mappingRequests;

public class MappingRequests {
    public static final String READ_LOG = "/log/read_log";

    public static final String GET_LOG_LEVEL = "/log/get_log_level/{page}/{size}";
    public static final String GET_LOG_MESSAGE = "/log/get_log_message/{page}/{size}";
    public static final String GET_LOG_LEVEL_MESSAGE = "/log/get_log_level_message/{page}/{size}";
    public static final String GET_LOG = "/log/get_log/{page}/{size}";
    public static final String SEARCH_V1 = "/log/search_v1/{page}/{size}";

    public static final String SEARCH_V2 = "/log/search_v2/{page}/{size}";
}
