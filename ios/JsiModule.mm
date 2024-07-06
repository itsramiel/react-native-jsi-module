#import "JsiModule.h"
#import "react-native-jsi-module.h"
#import <jsi/jsi.h>
#import <React/RCTBridge+Private.h>

@implementation JsiModule
RCT_EXPORT_MODULE()

// Don't compile this code when we build for the old architecture.
#ifdef RCT_NEW_ARCH_ENABLED
- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeJsiModuleSpecJSI>(params);
}
#endif

RCT_EXPORT_SYNCHRONOUS_TYPED_METHOD(NSNumber *, install) {
    RCTBridge *bridge = [RCTBridge currentBridge];
    RCTCxxBridge* cxxBridge = (RCTCxxBridge *)bridge;
    
    if(cxxBridge == nil) return @NO;
    
    jsi::Runtime *jsiRuntime = (jsi::Runtime *)cxxBridge.runtime;
    
    if(jsiRuntime == nil) return @NO;
    
    jsimodule::install(*jsiRuntime);
    
    return @YES;
}

@end
