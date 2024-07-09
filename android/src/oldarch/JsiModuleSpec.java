package com.jsimodule;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.Promise;

abstract class JsiModuleSpec extends ReactContextBaseJavaModule {
  JsiModuleSpec(ReactApplicationContext context) {
    super(context);
  }

  public abstract boolean install();
}
