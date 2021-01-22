package com.hj;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) {
            return null;
        }
        return props.get(key);
    }

    public static int getInt(String key) {
        if (getString(key) != null) {
            return Integer.parseInt(getString(key));
        }
        throw new RuntimeException("配置文件错误！！");
    }

    public static String getString(String key) {
        if (get(key) != null) {
            return (String) get(key);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("initTankCount"));

    }
}
