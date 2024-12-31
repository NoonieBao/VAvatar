package com.xconst.vavatar.utils;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import de.robv.android.xposed.XposedBridge;

public class RefUtil {

    public static final String TAG = "RefUtil ";

    public static HashMap<String, Object> inspect(Class<?> aClass, Object thisObject) {
        try {

            List<Field> allFields = FieldUtils.getAllFieldsList(aClass);
            HashMap<String, Object> stringObjectHashMap = new HashMap<>();

            for (Field field : allFields) {
                field.setAccessible(true);  // 设置私有字段可访问

                try {
                    Object value = field.get(thisObject);  // 获取字段的值
                    if(value==null){
                        value="null..";
                    }
                    stringObjectHashMap.put(field.getName(), value);
                } catch (Exception e) {
                    XposedBridge.log(TAG + e.getMessage());
                }
            }
            XposedBridge.log(TAG +aClass.getName()+ "OK");

            return stringObjectHashMap;
        } catch (Exception e) {
            return null;
        }
    }

    public static Object invoke_virtual(Object obj, String name, Object... argsTypesAndReturnType)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, IllegalArgumentException {
        Class<?>  clazz = obj.getClass();
        int argc = argsTypesAndReturnType.length / 2;
        Class<?> [] argt = new Class[argc];
        Object[] argv = new Object[argc];
        Class<?>  returnType = null;
        if (argc * 2 + 1 == argsTypesAndReturnType.length) {
            returnType = (Class<?> ) argsTypesAndReturnType[argsTypesAndReturnType.length - 1];
        }
        int i, ii;
        Method[] m;
        Method method = null;
        Class<?> [] _argt;
        for (i = 0; i < argc; i++) {
            argt[i] = (Class<?> ) argsTypesAndReturnType[argc + i];
            argv[i] = argsTypesAndReturnType[i];
        }
        loop_main:
        do {
            m = clazz.getDeclaredMethods();
            loop:
            for (i = 0; i < m.length; i++) {
                if (m[i].getName().equals(name)) {
                    _argt = m[i].getParameterTypes();
                    if (_argt.length == argt.length) {
                        for (ii = 0; ii < argt.length; ii++) {
                            if (!argt[ii].equals(_argt[ii])) {
                                continue loop;
                            }
                        }
                        if (returnType != null && !returnType.equals(m[i].getReturnType())) {
                            continue;
                        }
                        method = m[i];
                        break loop_main;
                    }
                }
            }
        } while (!Object.class.equals(clazz = clazz.getSuperclass()));
        if (method == null) {
            throw new NoSuchMethodException(
                    name + (Arrays.toString(argt)) + " in " + obj.getClass().getName());
        }
        method.setAccessible(true);
        return method.invoke(obj, argv);
    }

}
