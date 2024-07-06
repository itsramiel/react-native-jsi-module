import { NativeModules, Platform } from 'react-native';
import type { Spec } from './NativeJsiModule';

const LINKING_ERROR =
  `The package 'react-native-jsi-module' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

// @ts-expect-error
const isTurboModuleEnabled = global.__turboModuleProxy != null;

const JsiModuleModule = isTurboModuleEnabled
  ? require('./NativeJsiModule').default
  : NativeModules.JsiModule;

const JsiModule: Spec = JsiModuleModule
  ? JsiModuleModule
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

if (!global.__myModule__) {
  JsiModule.install();
}

const module = global.__myModule__;

export function reverseString(str: string): string {
  return module.reverseString(str);
}

export function getNumbers(): Array<number> {
  return module.getNumbers();
}

export function getObject(): Record<string, string> {
  return module.getObject();
}

export function callMeLater(successCB: () => void, failureCB: () => void) {
  module.callMeLater(successCB, failureCB);
}

export function promiseNumber(num: number) {
  return module.promiseNumber(num);
}
