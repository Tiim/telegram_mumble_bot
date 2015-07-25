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
// Generated from file `_ServerCallbackDisp.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Murmur;

/**
 * Callback interface for servers. You can supply an implementation of this to receive notification
 * messages from the server.
 * If an added callback ever throws an exception or goes away, it will be automatically removed.
 * Please note that all callbacks are done asynchronously; murmur does not wait for the callback to
 * complete before continuing processing.
 * Note that callbacks are removed when a server is stopped, so you should have a callback for
 * {@link MetaCallback.started} which calls {@link Server.addCallback}.
 * @see MetaCallback
 * @see Server.addCallback
 **/
public abstract class _ServerCallbackDisp extends Ice.ObjectImpl implements ServerCallback
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::Murmur::ServerCallback"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[1];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    /**
     * Called when a new channel is created. 
     * @param state State of new channel.
     **/
    public final void
    channelCreated(Channel state)
    {
        channelCreated(state, null);
    }

    /**
     * Called when a channel is removed. The channel has already been removed, you can no longer use methods like {@link Server.getChannelState}
     * @param state State of removed channel.
     **/
    public final void
    channelRemoved(Channel state)
    {
        channelRemoved(state, null);
    }

    /**
     * Called when a new channel state changes. This is called if the channel is moved, renamed or if new links are added.
     * @param state New state of channel.
     **/
    public final void
    channelStateChanged(Channel state)
    {
        channelStateChanged(state, null);
    }

    /**
     * Called when a user connects to the server. 
     * @param state State of connected user.
     **/
    public final void
    userConnected(User state)
    {
        userConnected(state, null);
    }

    /**
     * Called when a user disconnects from the server. The user has already been removed, so you can no longer use methods like {@link Server.getState}
     * to retrieve the user's state.
     * @param state State of disconnected user.
     **/
    public final void
    userDisconnected(User state)
    {
        userDisconnected(state, null);
    }

    /**
     * Called when a user state changes. This is called if the user moves, is renamed, is muted, deafened etc.
     * @param state New state of user.
     **/
    public final void
    userStateChanged(User state)
    {
        userStateChanged(state, null);
    }

    /**
     * Called when user writes a text message
     * @param state the User sending the message
     * @param message the TextMessage the user has sent
     **/
    public final void
    userTextMessage(User state, TextMessage message)
    {
        userTextMessage(state, message, null);
    }

    public static Ice.DispatchStatus
    ___userConnected(ServerCallback __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        User state;
        state = new User();
        state.__read(__is);
        __is.endReadEncaps();
        __obj.userConnected(state, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___userDisconnected(ServerCallback __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        User state;
        state = new User();
        state.__read(__is);
        __is.endReadEncaps();
        __obj.userDisconnected(state, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___userStateChanged(ServerCallback __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        User state;
        state = new User();
        state.__read(__is);
        __is.endReadEncaps();
        __obj.userStateChanged(state, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___userTextMessage(ServerCallback __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        User state;
        state = new User();
        state.__read(__is);
        TextMessage message;
        message = new TextMessage();
        message.__read(__is);
        __is.endReadEncaps();
        __obj.userTextMessage(state, message, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___channelCreated(ServerCallback __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        Channel state;
        state = new Channel();
        state.__read(__is);
        __is.endReadEncaps();
        __obj.channelCreated(state, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___channelRemoved(ServerCallback __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        Channel state;
        state = new Channel();
        state.__read(__is);
        __is.endReadEncaps();
        __obj.channelRemoved(state, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    public static Ice.DispatchStatus
    ___channelStateChanged(ServerCallback __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Idempotent, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        __is.startReadEncaps();
        Channel state;
        state = new Channel();
        state.__read(__is);
        __is.endReadEncaps();
        __obj.channelStateChanged(state, __current);
        return Ice.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
        "channelCreated",
        "channelRemoved",
        "channelStateChanged",
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "userConnected",
        "userDisconnected",
        "userStateChanged",
        "userTextMessage"
    };

    public Ice.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___channelCreated(this, in, __current);
            }
            case 1:
            {
                return ___channelRemoved(this, in, __current);
            }
            case 2:
            {
                return ___channelStateChanged(this, in, __current);
            }
            case 3:
            {
                return ___ice_id(this, in, __current);
            }
            case 4:
            {
                return ___ice_ids(this, in, __current);
            }
            case 5:
            {
                return ___ice_isA(this, in, __current);
            }
            case 6:
            {
                return ___ice_ping(this, in, __current);
            }
            case 7:
            {
                return ___userConnected(this, in, __current);
            }
            case 8:
            {
                return ___userDisconnected(this, in, __current);
            }
            case 9:
            {
                return ___userStateChanged(this, in, __current);
            }
            case 10:
            {
                return ___userTextMessage(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type Murmur::ServerCallback was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type Murmur::ServerCallback was not generated with stream support";
        throw ex;
    }
}
