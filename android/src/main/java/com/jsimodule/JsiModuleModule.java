package com.jsimodule;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;

public class JsiModuleModule extends JsiModuleSpec {
  public static final String NAME = "JsiModule";

  JsiModuleModule(ReactApplicationContext context) {
    super(context);
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  static {
    System.loadLibrary("react-native-jsi-module");
  }

  public static native void nativeInstall(long jsi);

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod(isBlockingSynchronousMethod = true)
  public boolean install() {
    JavaScriptContextHolder contextHolder = getReactApplicationContext().getJavaScriptContextHolder();
    if(contextHolder != null) {
    nativeInstall(contextHolder.get());
    return true;
    }
    return false;
  }
}
