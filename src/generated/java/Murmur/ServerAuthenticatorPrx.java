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
// Generated from file `ServerAuthenticatorPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Murmur;

/**
 * Callback interface for server authentication. You need to supply one of these for {@link Server.setAuthenticator}.
 * If an added callback ever throws an exception or goes away, it will be automatically removed.
 * Please note that unlike {@link ServerCallback} and {@link ServerContextCallback}, these methods are called
 * synchronously. If the response lags, the entire murmur server will lag.
 * Also note that, as the method calls are synchronous, making a call to {@link Server} or {@link Meta} will
 * deadlock the server.
 **/
public interface ServerAuthenticatorPrx extends Ice.ObjectPrx
{
    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param pw Password to authenticate with.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certhash Hash of user certificate, as used by murmur internally when matching.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param newname Set this to change the username from the supplied one.
     * @param groups List of groups on the root channel that the user will be added to for the duration of the connection.
     * @return UserID of authenticated user, -1 for authentication failures and -2 for unknown user (fallthrough).
     **/
    public int authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, Ice.StringHolder newname, GroupNameListHolder groups);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param pw Password to authenticate with.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certhash Hash of user certificate, as used by murmur internally when matching.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param newname Set this to change the username from the supplied one.
     * @param groups List of groups on the root channel that the user will be added to for the duration of the connection.
     * @param __ctx The Context map to send with the invocation.
     * @return UserID of authenticated user, -1 for authentication failures and -2 for unknown user (fallthrough).
     **/
    public int authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, Ice.StringHolder newname, GroupNameListHolder groups, java.util.Map<String, String> __ctx);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, java.util.Map<String, String> __ctx);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, Ice.Callback __cb);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, Callback_ServerAuthenticator_authenticate __cb);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param name Username to authenticate.
     * @param certificates List of der encoded certificates the user connected with.
     * @param certstrong True if certificate was valid and signed by a trusted CA.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_authenticate(String name, String pw, byte[][] certificates, String certhash, boolean certstrong, java.util.Map<String, String> __ctx, Callback_ServerAuthenticator_authenticate __cb);

    /**
     * Called to authenticate a user. If you do not know the username in question, always return -2 from this
     * method to fall through to normal database authentication.
     * Note that if authentication succeeds, murmur will create a record of the user in it's database, reserving
     * the username and id so it cannot be used for normal database authentication.
     * The data in the certificate (name, email addresses etc), as well as the list of signing certificates,
     * should only be trusted if certstrong is true.
     * 
     * @param newname Set this to change the username from the supplied one.
     * @param __result The asynchronous result object.
     * @return UserID of authenticated user, -1 for authentication failures and -2 for unknown user (fallthrough).
     **/
    public int end_authenticate(Ice.StringHolder newname, GroupNameListHolder groups, Ice.AsyncResult __result);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param info Information about user. This needs to include at least "name".
     * @return true if information is present, false to fall through.
     **/
    public boolean getInfo(int id, UserInfoMapHolder info);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param info Information about user. This needs to include at least "name".
     * @param __ctx The Context map to send with the invocation.
     * @return true if information is present, false to fall through.
     **/
    public boolean getInfo(int id, UserInfoMapHolder info, java.util.Map<String, String> __ctx);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getInfo(int id);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getInfo(int id, java.util.Map<String, String> __ctx);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getInfo(int id, Ice.Callback __cb);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getInfo(int id, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getInfo(int id, Callback_ServerAuthenticator_getInfo __cb);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param id User id.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_getInfo(int id, java.util.Map<String, String> __ctx, Callback_ServerAuthenticator_getInfo __cb);

    /**
     * Fetch information about a user. This is used to retrieve information like email address, keyhash etc. If you
     * want murmur to take care of this information itself, simply return false to fall through.
     * @param info Information about user. This needs to include at least "name".
     * @param __result The asynchronous result object.
     * @return true if information is present, false to fall through.
     **/
    public boolean end_getInfo(UserInfoMapHolder info, Ice.AsyncResult __result);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @return User id or -2 for unknown name.
     **/
    public int nameToId(String name);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param __ctx The Context map to send with the invocation.
     * @return User id or -2 for unknown name.
     **/
    public int nameToId(String name, java.util.Map<String, String> __ctx);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_nameToId(String name);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_nameToId(String name, java.util.Map<String, String> __ctx);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_nameToId(String name, Ice.Callback __cb);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_nameToId(String name, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_nameToId(String name, Callback_ServerAuthenticator_nameToId __cb);

    /**
     * Map a name to a user id.
     * @param name Username to map.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_nameToId(String name, java.util.Map<String, String> __ctx, Callback_ServerAuthenticator_nameToId __cb);

    /**
     * Map a name to a user id.
     * @param __result The asynchronous result object.
     * @return User id or -2 for unknown name.
     **/
    public int end_nameToId(Ice.AsyncResult __result);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @return Name of user or empty string for unknown id.
     **/
    public String idToName(int id);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @return Name of user or empty string for unknown id.
     **/
    public String idToName(int id, java.util.Map<String, String> __ctx);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToName(int id);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToName(int id, java.util.Map<String, String> __ctx);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToName(int id, Ice.Callback __cb);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToName(int id, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToName(int id, Callback_ServerAuthenticator_idToName __cb);

    /**
     * Map a user id to a username.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToName(int id, java.util.Map<String, String> __ctx, Callback_ServerAuthenticator_idToName __cb);

    /**
     * Map a user id to a username.
     * @param __result The asynchronous result object.
     * @return Name of user or empty string for unknown id.
     **/
    public String end_idToName(Ice.AsyncResult __result);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @return User texture or an empty texture for unknwon users or users without textures.
     **/
    public byte[] idToTexture(int id);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @return User texture or an empty texture for unknwon users or users without textures.
     **/
    public byte[] idToTexture(int id, java.util.Map<String, String> __ctx);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToTexture(int id);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToTexture(int id, java.util.Map<String, String> __ctx);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToTexture(int id, Ice.Callback __cb);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToTexture(int id, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToTexture(int id, Callback_ServerAuthenticator_idToTexture __cb);

    /**
     * Map a user to a custom Texture.
     * @param id User id to map.
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_idToTexture(int id, java.util.Map<String, String> __ctx, Callback_ServerAuthenticator_idToTexture __cb);

    /**
     * Map a user to a custom Texture.
     * @param __result The asynchronous result object.
     * @return User texture or an empty texture for unknwon users or users without textures.
     **/
    public byte[] end_idToTexture(Ice.AsyncResult __result);
}
