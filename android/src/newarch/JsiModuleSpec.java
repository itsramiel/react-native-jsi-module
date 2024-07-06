package com.jsimodule;

import com.facebook.react.bridge.ReactApplicationContext;

abstract class JsiModuleSpec extends NativeJsiModuleSpec {
  JsiModuleSpec(ReactApplicationContext context) {
    super(context);
  }
}
