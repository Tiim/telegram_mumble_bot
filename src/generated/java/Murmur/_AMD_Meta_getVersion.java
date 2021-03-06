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
// Generated from file `_AMD_Meta_getVersion.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Murmur;

final class _AMD_Meta_getVersion extends IceInternal.IncomingAsync implements AMD_Meta_getVersion
{
    public
    _AMD_Meta_getVersion(IceInternal.Incoming in)
    {
        super(in);
    }

    public void
    ice_response(int major, int minor, int patch, String text)
    {
        if(__validateResponse(true))
        {
            try
            {
                IceInternal.BasicStream __os = this.__os();
                __os.writeInt(major);
                __os.writeInt(minor);
                __os.writeInt(patch);
                __os.writeString(text);
            }
            catch(Ice.LocalException __ex)
            {
                ice_exception(__ex);
            }
            __response(true);
        }
    }
}
