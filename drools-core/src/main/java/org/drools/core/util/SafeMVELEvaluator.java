/*
 * Copyright (C) 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.core.util;

import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Map;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;

import org.kie.internal.security.KiePolicyHelper;
import org.kie.soup.project.datamodel.commons.util.MVELEvaluator;
import org.mvel2.MVEL;
import org.mvel2.ParserConfiguration;
import org.mvel2.ParserContext;
import org.mvel2.compiler.CompiledExpression;
import org.mvel2.integration.VariableResolverFactory;

public class SafeMVELEvaluator implements MVELEvaluator {

    @Override
    public Object eval(final String expression) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression)
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object eval(final String expression, final Object ctx) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  ctx
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object eval(final String expression, final VariableResolverFactory resolverFactory) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  resolverFactory
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object eval(final String expression, final Object ctx, final VariableResolverFactory resolverFactory) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  ctx,
                  resolverFactory
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object eval(final String expression, final Map<String, Object> vars) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  vars
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object eval(final String expression, final Object ctx, final Map<String, Object> vars) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  ctx,
                  vars
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T eval(final String expression, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  Collections.emptyMap(),
                  toType
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T eval(final String expression, final Object ctx, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  ctx,
                  toType
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T eval(final String expression, final VariableResolverFactory vars, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  vars,
                  toType
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T eval(final String expression, final Map<String, Object> vars, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  vars,
                  toType
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T eval(final String expression, final Object ctx, final VariableResolverFactory vars, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  ctx,
                  vars,
                  toType
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T eval(final String expression, final Object ctx, final Map<String, Object> vars, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression),
                  ctx,
                  vars,
                  toType
                );
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public String evalToString(final String expression) {
        return AccessController.doPrivileged(new PrivilegedAction<String>() {
            @Override
            public String run() {
                return String.valueOf(MVELSafeHelper.getEvaluator().executeExpression(
                  compileExpression(expression)
                ));
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object executeExpression(final Object compiledExpression) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVEL.executeExpression(compiledExpression);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object executeExpression(final Object compiledExpression, final Object ctx, final Map vars) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVEL.executeExpression(compiledExpression, ctx, vars);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object executeExpression(final Object compiledExpression, final Object ctx, final VariableResolverFactory resolverFactory) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVEL.executeExpression(compiledExpression, ctx, resolverFactory);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object executeExpression(final Object compiledExpression, final VariableResolverFactory factory) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVEL.executeExpression(compiledExpression, factory);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object executeExpression(final Object compiledExpression, final Object ctx) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVEL.executeExpression(compiledExpression, ctx);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public Object executeExpression(final Object compiledExpression, final Map vars) {
        return AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                return MVEL.executeExpression(compiledExpression, vars);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T executeExpression(final Object compiledExpression, final Object ctx, final Map vars, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVEL.executeExpression(compiledExpression, ctx, vars, toType);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T executeExpression(final Object compiledExpression, final Object ctx, final VariableResolverFactory vars, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVEL.executeExpression(compiledExpression, ctx, vars, toType);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T executeExpression(final Object compiledExpression, final Map vars, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVEL.executeExpression(compiledExpression, vars, toType);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public <T> T executeExpression(final Object compiledExpression, final Object ctx, final Class<T> toType) {
        return AccessController.doPrivileged(new PrivilegedAction<T>() {

            @Override
            public T run() {
                return MVEL.executeExpression(compiledExpression, ctx, toType);
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public void executeExpression(final Iterable<CompiledExpression> compiledExpression) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                MVEL.executeExpression(compiledExpression);
                return null;
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public void executeExpression(final Iterable<CompiledExpression> compiledExpression, final Object ctx) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                MVEL.executeExpression(compiledExpression, ctx);
                return null;
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public void executeExpression(final Iterable<CompiledExpression> compiledExpression, final Map vars) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                MVEL.executeExpression(compiledExpression, vars);
                return null;
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public void executeExpression(final Iterable<CompiledExpression> compiledExpression, final Object ctx, final Map vars) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                MVEL.executeExpression(compiledExpression, ctx, vars);
                return null;
            }
        }, KiePolicyHelper.getAccessContext());
    }

    @Override
    public void executeExpression(final Iterable<CompiledExpression> compiledExpression, final Object ctx, final VariableResolverFactory vars) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            @Override
            public Object run() {
                MVEL.executeExpression(compiledExpression, ctx, vars);
                return null;
            }
        }, KiePolicyHelper.getAccessContext());
    }

    private Serializable compileExpression(String expression) {
        ParserConfiguration pconf = new ParserConfiguration();
        pconf.setClassLoader(getClass().getClassLoader());
        ParserContext context = new ParserContext(pconf);
        return MVEL.compileExpression(expression, context);
    }
}