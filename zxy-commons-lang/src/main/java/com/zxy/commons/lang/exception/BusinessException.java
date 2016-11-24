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
package com.zxy.commons.lang.exception;

/**
 * 业务异常类
 * 
 * <p>
 * <a href="BusinessException.java"><i>View Source</i></a>
 * 
 * @author zhaoxunyong@qq.com
 * @version 1.0
 * @since 1.0
 */
public class BusinessException extends BaseException {
    private static final long serialVersionUID = 865028814488025693L;

    /**
     * 构造函数
     * 
     * @param code 错误代码
     */
    public BusinessException(int code) {
        super(code);
        this.code = code;
    }

    /**
     * 构造函数
     * 
     * @param msg 错误信息
     */
    public BusinessException(String msg) {
        super(msg);
    }

    /**
     * 构造函数
     * 
     * @param code 错误代码
     * @param msg 错误信息
     */
    public BusinessException(int code, String msg) {
        super(code, msg);
    }

    /**
     * 构造函数
     * 
     * @param cause Throwable异常
     */
    public BusinessException(Throwable cause) {
        super(cause);
    }

    /**
     * 构造函数
     * 
     * @param cause Throwable cause
     */
    public BusinessException(BaseException cause) {
        this(cause.getCode(), cause.getMessage());
    }

    /**
     * 构造函数
     * 
     * @param msg 错误信息
     * @param cause Throwable异常
     */
    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * 构造函数
     * 
     * @param code code
     * @param cause Throwable cause
     */
    public BusinessException(int code, Throwable cause) {
        super("", cause);
        this.code = code;
    }

    /**
     * 构造函数
     * 
     * @param code 错误代码
     * @param msg 错误信息
     * @param cause Throwable异常
     */
    public BusinessException(int code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
