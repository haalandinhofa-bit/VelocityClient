package com.velocityclient.module;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModuleManager {
    private final List<Module> modules = new ArrayList<Module>();
    public void register(Module module) { modules.add(module); }
    public List<Module> getModules() { return Collections.unmodifiableList(modules); }
}
