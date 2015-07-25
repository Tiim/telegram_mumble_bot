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
// Generated from file `_ServerCallbackDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Murmur;

public interface _ServerCallbackDel extends Ice._ObjectDel
{
    void userConnected(User state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void userDisconnected(User state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void userStateChanged(User state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void userTextMessage(User state, TextMessage message, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void channelCreated(Channel state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void channelRemoved(Channel state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    void channelStateChanged(Channel state, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
