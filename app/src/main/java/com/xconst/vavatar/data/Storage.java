package com.xconst.vavatar.data;

import android.content.Context;

public class Storage {
    private static Storage storage;
    private volatile Object modelAvatarU0;



    private Context context;

    private ClassLoader classLoader;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void setModelAvatarU0(Object context) {
        this.modelAvatarU0 = context;
    }

    public Object getModelAvatarU0() {
        return modelAvatarU0;
    }

}
