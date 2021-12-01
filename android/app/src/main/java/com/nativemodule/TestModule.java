package com.nativemodule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import java.util.Map;
import java.util.HashMap;

import android.util.Log;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;

public class TestModule extends ReactContextBaseJavaModule{
    TestModule(ReactApplicationContext context){
        super(context);
    }
    @Override
    public String getName(){
        return "TestModule";
    }
    @ReactMethod
    public void tes(Promise promise){
        try {
            promise.resolve("halo dari native module");
        } catch (Exception e) {
            promise.reject("error dari native module", e);
        }
    }
    @ReactMethod
    public void toggleBluetooth(Promise promise){
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            if (mBluetoothAdapter.isEnabled()) {
                mBluetoothAdapter.disable(); 
            } else{
                mBluetoothAdapter.enable();
            }
            promise.resolve("bluetooth enabled");
            
        } catch (Exception e) {
            promise.reject("can't bluetooth enabled error ", e);
            //TODO: handle exception
        }
    }
}