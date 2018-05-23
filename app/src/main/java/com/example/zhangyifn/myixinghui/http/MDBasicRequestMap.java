package com.example.zhangyifn.myixinghui.http;

import java.util.HashMap;
import java.util.Map;

public class MDBasicRequestMap extends HashMap {
    public MDBasicRequestMap(){
        super();
    }
    public MDBasicRequestMap(Map<String, String> map){
        super();
        this.putAll(map);
    }
}