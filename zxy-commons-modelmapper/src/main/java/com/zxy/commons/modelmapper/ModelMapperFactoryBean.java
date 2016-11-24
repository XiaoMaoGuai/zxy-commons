/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.zxy.commons.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * A factory bean that instantiates the {@link ModelMapper} and configures it by delegating to registered
 * {@link ModelMapperConfigurer} instances.
 *
 * <p>
 * <a href="ModelMapperFactoryBean.java"><i>View Source</i></a>
 * 
 * @author zhaoxunyong@qq.com
 * @version 1.0
 * @since 1.0
 */
public class ModelMapperFactoryBean implements FactoryBean<ModelMapper> {

    /**
     * The class literal.
     */
    private static final Class<ModelMapper> MODEL_MAPPER_CLASS = ModelMapper.class;

    /**
     * The list of configurers used for customizing the behaviour of the model mapper.
     */
    @Autowired(required = false)
    private List<ModelMapperConfigurer> configurers;

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    public ModelMapper getObject() throws Exception {

        // instantiates new instance of mapper
        final ModelMapper modelMapper = new ModelMapper();

        // configures the mapper
        configure(modelMapper);

        // returns the mapper
        return modelMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<?> getObjectType() {
        return MODEL_MAPPER_CLASS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isSingleton() {
        return true;
    }

    /**
     * Configures the model mapper instance be delegating toward registered {@link ModelMapperConfigurer} instances.
     *
     * @param modelMapper the model mapper
     */
    private void configure(ModelMapper modelMapper) {
        if (configurers != null) {
            for (ModelMapperConfigurer modelMapperConfigurer : configurers) {
                modelMapperConfigurer.configure(modelMapper);
            }
        }
    }
}
