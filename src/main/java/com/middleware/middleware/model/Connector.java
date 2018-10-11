package com.middleware.middleware.model;

import java.util.Map;

public class Connector {

    String name;
    String protocol;
    String script;
    Map<String, Instance> listeningPathToInstanceMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Map<String, Instance> getListeningPathToInstanceMap() {
        return listeningPathToInstanceMap;
    }

    public void setListeningPathToInstanceMap(Map<String, Instance> listeningPathToInstanceMap) {
        this.listeningPathToInstanceMap = listeningPathToInstanceMap;
    }

}
