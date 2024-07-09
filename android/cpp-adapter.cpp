#include <jni.h>
#include <jsi/jsi.h>
#include "react-native-jsi-module.h"

extern "C"
JNIEXPORT void JNICALL
Java_com_jsimodule_JsiModuleModule_nativeInstall(JNIEnv *env, jclass clazz, jlong jsi) {
    jsi::Runtime * runtime = reinterpret_cast<jsi::Runtime *>(jsi);
    jsimodule::install(*runtime);
}
