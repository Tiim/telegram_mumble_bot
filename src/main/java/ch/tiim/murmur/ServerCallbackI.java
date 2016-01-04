package ch.tiim.murmur;

import Ice.*;
import Ice.Object;
import IceInternal.BasicStream;
import IceInternal.Direct;
import IceInternal.Incoming;
import Murmur.*;

import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

public class ServerCallbackI extends Ice.ObjectPrxHelperBase implements ServerCallbackPrx, Object {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(ServerCallbackI.class.getName());
    public static final String[] __ids = new String[]{"::Ice::Object"};
    private static final String[] __all = new String[]{"ice_id", "ice_ids", "ice_isA", "ice_ping"};

    @Override
    public void userConnected(User state) {
        LOGGER.fine("USER CONNECTED");
    }

    @Override
    public void userConnected(User state, Map<String, String> __ctx) {
        LOGGER.fine("USER CONNECTED ex");
    }

    @Override
    public void userDisconnected(User state) {
        LOGGER.fine("USER DISCONNECTED");
    }

    @Override
    public void userDisconnected(User state, Map<String, String> __ctx) {
        LOGGER.fine("USER DISCONNECTED ex");
    }

    @Override
    public void userStateChanged(User state) {
        LOGGER.fine("USER STATE CHANGED");
    }

    @Override
    public void userStateChanged(User state, Map<String, String> __ctx) {
        LOGGER.fine("USER STATE CHANGED ex");
    }

    @Override
    public void userTextMessage(User state, TextMessage message) {
        LOGGER.fine("USER TEXT MESSAGE");
    }

    @Override
    public void userTextMessage(User state, TextMessage message, Map<String, String> __ctx) {
        LOGGER.fine("USER TEXT MESSAGE ex");
    }

    @Override
    public void channelCreated(Channel state) {
        LOGGER.fine("CHANNEL CREATED");
    }

    @Override
    public void channelCreated(Channel state, Map<String, String> __ctx) {
        LOGGER.fine("CHANNEL CREATED ex");
    }

    @Override
    public void channelRemoved(Channel state) {
        LOGGER.fine("CHANNEL REMOVEC");
    }

    @Override
    public void channelRemoved(Channel state, Map<String, String> __ctx) {
        LOGGER.fine("CHANNEL REMOVEC ex");
    }

    /////////////////////////////////////////////////////////////

    @Override
    public AsyncResult begin_userConnected(User state) {
        return null;
    }

    @Override
    public AsyncResult begin_userConnected(User state, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_userConnected(User state, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userConnected(User state, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userConnected(User state, Callback_ServerCallback_userConnected __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userConnected(User state, Map<String, String> __ctx, Callback_ServerCallback_userConnected __cb) {
        return null;
    }

    @Override
    public void end_userConnected(AsyncResult __result) {

    }

    @Override
    public AsyncResult begin_userDisconnected(User state) {
        return null;
    }

    @Override
    public AsyncResult begin_userDisconnected(User state, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_userDisconnected(User state, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userDisconnected(User state, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userDisconnected(User state, Callback_ServerCallback_userDisconnected __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userDisconnected(User state, Map<String, String> __ctx, Callback_ServerCallback_userDisconnected __cb) {
        return null;
    }

    @Override
    public void end_userDisconnected(AsyncResult __result) {

    }

    @Override
    public AsyncResult begin_userStateChanged(User state) {
        return null;
    }

    @Override
    public AsyncResult begin_userStateChanged(User state, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_userStateChanged(User state, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userStateChanged(User state, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userStateChanged(User state, Callback_ServerCallback_userStateChanged __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userStateChanged(User state, Map<String, String> __ctx, Callback_ServerCallback_userStateChanged __cb) {
        return null;
    }

    @Override
    public void end_userStateChanged(AsyncResult __result) {

    }

    @Override
    public AsyncResult begin_userTextMessage(User state, TextMessage message) {
        return null;
    }

    @Override
    public AsyncResult begin_userTextMessage(User state, TextMessage message, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_userTextMessage(User state, TextMessage message, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userTextMessage(User state, TextMessage message, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userTextMessage(User state, TextMessage message, Callback_ServerCallback_userTextMessage __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_userTextMessage(User state, TextMessage message, Map<String, String> __ctx, Callback_ServerCallback_userTextMessage __cb) {
        return null;
    }

    @Override
    public void end_userTextMessage(AsyncResult __result) {

    }

    @Override
    public AsyncResult begin_channelCreated(Channel state) {
        return null;
    }

    @Override
    public AsyncResult begin_channelCreated(Channel state, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_channelCreated(Channel state, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelCreated(Channel state, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelCreated(Channel state, Callback_ServerCallback_channelCreated __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelCreated(Channel state, Map<String, String> __ctx, Callback_ServerCallback_channelCreated __cb) {
        return null;
    }

    @Override
    public void end_channelCreated(AsyncResult __result) {

    }

    @Override
    public AsyncResult begin_channelRemoved(Channel state) {
        return null;
    }

    @Override
    public AsyncResult begin_channelRemoved(Channel state, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_channelRemoved(Channel state, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelRemoved(Channel state, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelRemoved(Channel state, Callback_ServerCallback_channelRemoved __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelRemoved(Channel state, Map<String, String> __ctx, Callback_ServerCallback_channelRemoved __cb) {
        return null;
    }

    @Override
    public void end_channelRemoved(AsyncResult __result) {

    }

    @Override
    public void channelStateChanged(Channel state) {

    }

    @Override
    public void channelStateChanged(Channel state, Map<String, String> __ctx) {

    }

    @Override
    public AsyncResult begin_channelStateChanged(Channel state) {
        return null;
    }

    @Override
    public AsyncResult begin_channelStateChanged(Channel state, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_channelStateChanged(Channel state, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelStateChanged(Channel state, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelStateChanged(Channel state, Callback_ServerCallback_channelStateChanged __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_channelStateChanged(Channel state, Map<String, String> __ctx, Callback_ServerCallback_channelStateChanged __cb) {
        return null;
    }

    @Override
    public void end_channelStateChanged(AsyncResult __result) {

    }

    public java.lang.Object clone() {
        java.lang.Object o = null;

        try {
            o = super.clone();
        } catch (CloneNotSupportedException var3) {
            assert false;
        }

        return o;
    }

    /**
     * @deprecated
     */
    public int ice_hash() {
        return this.hashCode();
    }


    public boolean ice_isA(String s, Current current) {
        return s.equals(__ids[0]);
    }

    public static DispatchStatus ___ice_isA(Object __obj, Incoming __inS, Current __current) {
        BasicStream __is = __inS.is();
        __is.startReadEncaps();
        String __id = __is.readString();
        __is.endReadEncaps();
        boolean __ret = __obj.ice_isA(__id, __current);
        BasicStream __os = __inS.os();
        __os.writeBool(__ret);
        return DispatchStatus.DispatchOK;
    }

    public void ice_ping(Current current) {
    }

    public static DispatchStatus ___ice_ping(Object __obj, Incoming __inS, Current __current) {
        __inS.is().skipEmptyEncaps();
        __obj.ice_ping(__current);
        return DispatchStatus.DispatchOK;
    }

    public String[] ice_ids(Current current) {
        return __ids;
    }

    public static DispatchStatus ___ice_ids(Object __obj, Incoming __inS, Current __current) {
        __inS.is().skipEmptyEncaps();
        String[] __ret = __obj.ice_ids(__current);
        BasicStream __os = __inS.os();
        __os.writeStringSeq(__ret);
        return DispatchStatus.DispatchOK;
    }

    public String ice_id(Current current) {
        return __ids[0];
    }

    public static DispatchStatus ___ice_id(Object __obj, Incoming __inS, Current __current) {
        __inS.is().skipEmptyEncaps();
        String __ret = __obj.ice_id(__current);
        BasicStream __os = __inS.os();
        __os.writeString(__ret);
        return DispatchStatus.DispatchOK;
    }

    public static String ice_staticId() {
        return __ids[0];
    }

    public int ice_operationAttributes(String operation) {
        return 0;
    }

    public void ice_preMarshal() {
    }

    public void ice_postUnmarshal() {
    }

    public DispatchStatus ice_dispatch(Request request, DispatchInterceptorAsyncCallback cb) {
        if (request.isCollocated()) {
            return this.__collocDispatch((Direct) request);
        } else {
            Incoming in = (Incoming) request;
            if (cb != null) {
                in.push(cb);
            }

            DispatchStatus var4;
            try {
                in.startOver();
                var4 = this.__dispatch(in, in.getCurrent());
            } finally {
                if (cb != null) {
                    in.pop();
                }

            }

            return var4;
        }
    }

    public DispatchStatus ice_dispatch(Request request) {
        return this.ice_dispatch(request, (DispatchInterceptorAsyncCallback) null);
    }

    public DispatchStatus __dispatch(Incoming in, Current current) {
        int pos = Arrays.binarySearch(__all, current.operation);
        if (pos < 0) {
            throw new OperationNotExistException(current.id, current.facet, current.operation);
        } else {
            switch (pos) {
                case 0:
                    return ___ice_id(this, in, current);
                case 1:
                    return ___ice_ids(this, in, current);
                case 2:
                    return ___ice_isA(this, in, current);
                case 3:
                    return ___ice_ping(this, in, current);
                default:
                    assert false;

                    throw new OperationNotExistException(current.id, current.facet, current.operation);
            }
        }
    }

    public DispatchStatus __collocDispatch(Direct request) {
        return request.run(this);
    }

    public void __write(BasicStream __os) {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.writeSize(0);
        __os.endWriteSlice();
    }

    public void __read(BasicStream __is, boolean __rid) {
        if (__rid) {
            __is.readTypeId();
        }

        __is.startReadSlice();
        int sz = __is.readSize();
        if (sz != 0) {
            throw new MarshalException();
        } else {
            __is.endReadSlice();
        }
    }

    public void __write(OutputStream __outS) {
        __outS.writeTypeId(ice_staticId());
        __outS.startSlice();
        __outS.writeSize(0);
        __outS.endSlice();
    }

    public void __read(InputStream __inS, boolean __rid) {
        if (__rid) {
            __inS.readTypeId();
        }

        __inS.startSlice();
        int sz = __inS.readSize();
        if (sz != 0) {
            throw new MarshalException();
        } else {
            __inS.endSlice();
        }
    }

    private static String operationModeToString(OperationMode mode) {
        return mode == OperationMode.Normal ? "::Ice::Normal" : (mode == OperationMode.Nonmutating ? "::Ice::Nonmutating" : (mode == OperationMode.Idempotent ? "::Ice::Idempotent" : "???"));
    }

    protected static void __checkMode(OperationMode expected, OperationMode received) {
        if (expected != received && (expected != OperationMode.Idempotent || received != OperationMode.Nonmutating)) {
            MarshalException ex = new MarshalException();
            ex.reason = "unexpected operation mode. expected = " + operationModeToString(expected) + " received = " + operationModeToString(received);
            throw ex;
        }
    }
}
