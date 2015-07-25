package ch.tiim.murmur;

import Ice.AsyncResult;
import Ice.Callback;
import Murmur.Callback_MetaCallback_started;
import Murmur.Callback_MetaCallback_stopped;
import Murmur.ServerPrx;
import ch.tiim.utils.log.Log;

import java.util.Map;

public class MetaCallbackI extends Ice.ObjectPrxHelperBase implements Murmur.MetaCallbackPrx {
    private static final Log LOGGER = new Log(MetaCallbackI.class);

    @Override
    public void started(ServerPrx srv) {
        LOGGER.debug("Server Started");
    }

    @Override
    public void started(ServerPrx srv, Map<String, String> __ctx) {
        LOGGER.debug("Server Started ex");
    }

    @Override
    public void stopped(ServerPrx srv) {
        LOGGER.debug("Server Stopped");
    }

    @Override
    public void stopped(ServerPrx srv, Map<String, String> __ctx) {
        LOGGER.debug("Server Stopped ex");
    }

    ///////////////////////////////////////////////////////

    @Override
    public AsyncResult begin_started(ServerPrx srv) {
        return null;
    }

    @Override
    public AsyncResult begin_started(ServerPrx srv, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_started(ServerPrx srv, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_started(ServerPrx srv, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_started(ServerPrx srv, Callback_MetaCallback_started __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_started(ServerPrx srv, Map<String, String> __ctx, Callback_MetaCallback_started __cb) {
        return null;
    }

    @Override
    public void end_started(AsyncResult __result) {

    }

    @Override
    public AsyncResult begin_stopped(ServerPrx srv) {
        return null;
    }

    @Override
    public AsyncResult begin_stopped(ServerPrx srv, Map<String, String> __ctx) {
        return null;
    }

    @Override
    public AsyncResult begin_stopped(ServerPrx srv, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_stopped(ServerPrx srv, Map<String, String> __ctx, Callback __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_stopped(ServerPrx srv, Callback_MetaCallback_stopped __cb) {
        return null;
    }

    @Override
    public AsyncResult begin_stopped(ServerPrx srv, Map<String, String> __ctx, Callback_MetaCallback_stopped __cb) {
        return null;
    }

    @Override
    public void end_stopped(AsyncResult __result) {

    }
}
