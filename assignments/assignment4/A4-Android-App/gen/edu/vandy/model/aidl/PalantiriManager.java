/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/William/cs282/cs282/assignments/assignment4/A4-Android-App/src/edu/vandy/model/aidl/PalantiriManager.aidl
 */
package edu.vandy.model.aidl;
/**
 * Interface defining the methods the PalantiriService implements to
 * provide synchronous access to the PalantiriManager.
 */
public interface PalantiriManager extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements edu.vandy.model.aidl.PalantiriManager
{
private static final java.lang.String DESCRIPTOR = "edu.vandy.model.aidl.PalantiriManager";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an edu.vandy.model.aidl.PalantiriManager interface,
 * generating a proxy if needed.
 */
public static edu.vandy.model.aidl.PalantiriManager asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof edu.vandy.model.aidl.PalantiriManager))) {
return ((edu.vandy.model.aidl.PalantiriManager)iin);
}
return new edu.vandy.model.aidl.PalantiriManager.Stub.Proxy(obj);
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
case TRANSACTION_makePalantiri:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.makePalantiri(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_acquire:
{
data.enforceInterface(DESCRIPTOR);
long _arg0;
_arg0 = data.readLong();
edu.vandy.model.aidl.LeaseCallback _arg1;
_arg1 = edu.vandy.model.aidl.LeaseCallback.Stub.asInterface(data.readStrongBinder());
edu.vandy.model.aidl.Palantir _result = this.acquire(_arg0, _arg1);
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_release:
{
data.enforceInterface(DESCRIPTOR);
edu.vandy.model.aidl.Palantir _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.vandy.model.aidl.Palantir.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
this.release(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_remainingTime:
{
data.enforceInterface(DESCRIPTOR);
edu.vandy.model.aidl.Palantir _arg0;
if ((0!=data.readInt())) {
_arg0 = edu.vandy.model.aidl.Palantir.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
long _result = this.remainingTime(_arg0);
reply.writeNoException();
reply.writeLong(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements edu.vandy.model.aidl.PalantiriManager
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
     * Create a resource manager that contains the designated number
     * of Palantir with random gaze times between 1 and 5 milliseconds
     * "Fair" semantics should be used to instantiate the Semaphore.
     *
     * @param palantiriCount
     *            The number of Palantiri to add to the PalantiriManager.
     */// TODO -- you fill in here.

@Override public void makePalantiri(int palantiriCount) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(palantiriCount);
mRemote.transact(Stub.TRANSACTION_makePalantiri, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Get the next available Palantir from the resource pool,
     * blocking until one is available.
     *
     * @param leaseDurationInMillis
     *            The amount of time the lease can be held, in milliseconds.
     * @param leaseCallback
     *            The object to callback if the lease expires.
     */// TODO -- you fill in here.

@Override public edu.vandy.model.aidl.Palantir acquire(long leaseDurationInMillis, edu.vandy.model.aidl.LeaseCallback leaseCallback) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
edu.vandy.model.aidl.Palantir _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeLong(leaseDurationInMillis);
_data.writeStrongBinder((((leaseCallback!=null))?(leaseCallback.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_acquire, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = edu.vandy.model.aidl.Palantir.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Releases the designated @code palantir so it's available
     * for other Beings to use.
     */// TODO -- you fill in here.

@Override public void release(edu.vandy.model.aidl.Palantir palantir) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((palantir!=null)) {
_data.writeInt(1);
palantir.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_release, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Returns the amount of time (in milliseconds) remaining on
     * the lease held on the @a resource.
     */// TODO -- you fill in here.

@Override public long remainingTime(edu.vandy.model.aidl.Palantir palantir) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
long _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((palantir!=null)) {
_data.writeInt(1);
palantir.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_remainingTime, _data, _reply, 0);
_reply.readException();
_result = _reply.readLong();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_makePalantiri = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_acquire = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_release = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_remainingTime = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
/**
     * Create a resource manager that contains the designated number
     * of Palantir with random gaze times between 1 and 5 milliseconds
     * "Fair" semantics should be used to instantiate the Semaphore.
     *
     * @param palantiriCount
     *            The number of Palantiri to add to the PalantiriManager.
     */// TODO -- you fill in here.

public void makePalantiri(int palantiriCount) throws android.os.RemoteException;
/**
     * Get the next available Palantir from the resource pool,
     * blocking until one is available.
     *
     * @param leaseDurationInMillis
     *            The amount of time the lease can be held, in milliseconds.
     * @param leaseCallback
     *            The object to callback if the lease expires.
     */// TODO -- you fill in here.

public edu.vandy.model.aidl.Palantir acquire(long leaseDurationInMillis, edu.vandy.model.aidl.LeaseCallback leaseCallback) throws android.os.RemoteException;
/**
     * Releases the designated @code palantir so it's available
     * for other Beings to use.
     */// TODO -- you fill in here.

public void release(edu.vandy.model.aidl.Palantir palantir) throws android.os.RemoteException;
/**
     * Returns the amount of time (in milliseconds) remaining on
     * the lease held on the @a resource.
     */// TODO -- you fill in here.

public long remainingTime(edu.vandy.model.aidl.Palantir palantir) throws android.os.RemoteException;
}
