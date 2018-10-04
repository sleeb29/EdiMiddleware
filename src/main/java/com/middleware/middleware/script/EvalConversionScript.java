package com.middleware.middleware.script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvalConversionScript {

    ScriptEngineManager scriptEngineManager;
    ScriptEngine engine;

    public EvalConversionScript(){
        this.scriptEngineManager = new ScriptEngineManager();
        this.engine = scriptEngineManager.getEngineByName("nashorn");
    }

    public String convertMessage(String conversionScript, String message) throws ScriptException {

        this.engine.put("message", message);
        this.engine.eval(conversionScript);
        String newMessage = (String)this.engine.get("newMessage");

        return newMessage;

    }

}
