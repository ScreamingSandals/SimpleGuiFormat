package org.screamingsandals.simpleinventories.groovy.builder;

import groovy.lang.Closure;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.screamingsandals.simpleinventories.groovy.utils.GroovyUtils.internalCallClosure;

@AllArgsConstructor
@Getter
public class GroovyAnimationBuilder {
    private final List<Object> stacks;

    public void stack(String material) {
        putStack(material);
    }

    public void stack(String material, Closure<IGroovyStackBuilder> closure) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", material);
        putStack(map);
        internalCallClosure(closure, new GroovyLongStackBuilder(map));
    }

    public void stack(Closure<IGroovyStackBuilder> closure) {
        Map<String, Object> map = new HashMap<>();
        putStack(map);
        internalCallClosure(closure, new GroovyLongStackBuilder(map));
    }

    private void putStack(Object stack) {
        stacks.add(stack);
    }
}
