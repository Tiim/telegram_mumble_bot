// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `AMD_Server_stop.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Murmur;

/**
 * Stop server.
 * Note: Server will be restarted on Murmur restart unless explicitly disabled
 * with setConf("boot", false)
 **/

public interface AMD_Server_stop extends Ice.AMDCallback
{
    /**
     * ice_response indicates that
     * the operation completed successfully.
     **/
    void ice_response();
}
