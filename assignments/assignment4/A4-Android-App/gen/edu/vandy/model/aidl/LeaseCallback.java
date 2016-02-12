/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/William/cs282/cs282/assignments/assignment4/A4-Android-App/src/edu/vandy/model/aidl/LeaseCallback.aidl
 */
package edu.vandy.model.aidl;
/**
 * Interface defining the method the PalantiriModel implements so
 * the PalantirService can inform it when a Lease expires.
 */
public interface LeaseCallback extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.vandy.model.aidl.LeaseCallback
{
private static final java.lang.String DESCRIPTOR = "edu.vandy.model.aidl.LeaseCallback";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.vandy.model.aidl.LeaseCallback interface,
 * generating a proxy if needed.
 */
public static edu.vandy.model.aidl.LeaseCallback asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.vandy.model.aidl.LeaseCallback))) {
return ((edu.vandy.model.aidl.LeaseCallback)iin);
}
return new edu.vandy.model.aidl.LeaseCallback.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_leaseExpired:
{
data.enforceInterface(DESCRIPTOR);
edu.vandy.model.aidl.Palantir _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.vandy.model.aidl.Palantir.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.leaseExpired(_arg0);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.vandy.model.aidl.LeaseCallback
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Inform the PalantiriModel that the lease associated with @a
     * palantir has expired.  It's essential to define this method as
     * a oneway since otherwise it will block the service.
     *
     * @param palantir
     *            The Palantir that has expired.
     */// TODO -- you fill in here.

@Override public void leaseExpired(edu.vandy.model.aidl.Palantir palantir) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((palantir!=null)) {
_data.writeInt(1);
palantir.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_leaseExpired, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_leaseExpired = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
/**
     * Inform the PalantiriModel that the lease associated with @a
     * palantir has expired.  It's essential to define this method as
     * a oneway since otherwise it will block the service.
     *
     * @param palantir
     *            The Palantir that has expired.
     */// TODO -- you fill in here.

public void leaseExpired(edu.vandy.model.aidl.Palantir palantir) throws android.os.RemoteException;
}
