// IOnNewBookArrivedListener.aidl
package com.eebbk.open.scrollphotoitem.IPC;
import com.eebbk.open.scrollphotoitem.IPC.NewBook;
// Declare any non-default types here with import statements

interface IOnNewBookArrivedListener {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void onNewBookArrived(in NewBook newBook);
}
