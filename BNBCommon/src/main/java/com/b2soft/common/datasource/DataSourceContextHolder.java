package com.b2soft.common.datasource;

import com.b2soft.common.datasource.type.DataSourceType;

public class DataSourceContextHolder {

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<DataSourceType>();

    public static void setDatasourceType(DataSourceType datasourceType) {
        contextHolder.set(datasourceType);
    }

    public static DataSourceType getDataSourceType() {
        if(contextHolder == null) {
            contextHolder.set(DataSourceType.MARIADB);
        }
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
