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
package com.zxy.commons.mongodb;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Mongodb utils
 *
 * <p>
 * <a href="MongodbUtils.java"><i>View Source</i></a>
 *
 * @author zhaoxunyong@qq.com
 * @version 1.0
 * @since 1.0
 */
public final class MongodbUtils {

    private MongodbUtils() {}

    /**
     * 拼装多条件查询
     *
     * @param params params
     * @return Query
     */
    public static Query getQuery(Map<String, Object> params){
        if (params == null || params.isEmpty()) {
            return null;
        }
        List<Criteria> criterias = new ArrayList<>();
        for(Map.Entry<String, Object> entry : params.entrySet()) {
            criterias.add(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return new Query(new Criteria().andOperator(criterias.toArray(new Criteria[params.size()])));

    }
}
