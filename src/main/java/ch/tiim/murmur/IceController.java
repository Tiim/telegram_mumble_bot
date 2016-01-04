package ch.tiim.murmur;

import Murmur.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class IceController {
    private static final Logger LOGGER = Logger.getLogger(IceController.class.getName());

    private boolean available = true;
    private Murmur.MetaPrx metaProxy;
    private Ice.ObjectAdapter adapter;
    private Ice.Communicator ice;
    private ServerCallbackI callback;

    public IceController() {
        try {
            Ice.Properties prop = Ice.Util.createProperties();
            prop.setProperty("Ice.ImplicitContext", "Shared");

            Ice.InitializationData idd = new Ice.InitializationData();
            idd.properties = prop;

            ice = Ice.Util.initialize(idd);
            Ice.ObjectPrx base = ice.stringToProxy("Meta:default -p 6502");
            metaProxy = Murmur.MetaPrxHelper.checkedCast(base);
            adapter = ice.createObjectAdapterWithEndpoints("Callback.Client", "tcp -h 127.0.0.1");
            ice.getImplicitContext().put("secret", "fourtytwo");
            available = metaProxy != null;
        } catch (Ice.LocalException e) {
            LOGGER.info("ICE is not available");
            available = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Trying out ICE");
        IceController controller = new IceController();
        System.out.println("Instantiated ICEController");
        System.out.println(controller.getMumbleUsers());
    }

    public boolean isAvailable() {
        return available;
    }

    public Collection<UserWrapper> getMumbleUsers() {
        try {
            ServerPrx[] serv = metaProxy.getBootedServers();
            if (serv != null && serv.length > 0) {
                Map<Integer, User> users = serv[0].getUsers();
                if (users != null) {
                    return users.values().stream().map(UserWrapper::new).collect(Collectors.toList());
                }
            }
        } catch (InvalidSecretException | ServerBootedException e) {
            LOGGER.log(Level.WARNING, "Exception while fetching mumble users", e);
        }
        return new ArrayList<>();
    }

    public Channel getChannel(int id) {
        try {
            ServerPrx[] serv = metaProxy.getBootedServers();
            return serv[0].getChannels().get(id);
        } catch (InvalidSecretException | ServerBootedException e) {
            LOGGER.log(Level.WARNING, "Exception while fetching channels", e);
            return null;
        }
    }

    public void sendMessage(String message, String user) {
        try {
            ServerPrx prx = metaProxy.getBootedServers()[0];
            prx.getUsers().entrySet().stream().forEach((entry) -> {
                //noinspection EqualsBetweenInconvertibleTypes
                if (entry.getValue().equals(user)) {
                    try {
                        prx.sendMessage(entry.getKey(), message);
                    } catch (InvalidSecretException | InvalidSessionException | ServerBootedException e) {
                        LOGGER.log(Level.WARNING, "Could not send message to user", e);
                    }
                }
            });
        } catch (InvalidSecretException | ServerBootedException e) {
            LOGGER.log(Level.WARNING, "Error while sending message to user", e);
        }
    }

    public void stop() {
        if (ice != null) {
            try {
                ice.destroy();
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Error while cleaning up ICE", e);
            }
        }
    }
}
