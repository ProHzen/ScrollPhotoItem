// NewBookManager.aidl
package com.eebbk.open.scrollphotoitem.IPC;
import com.eebbk.open.scrollphotoitem.IPC.NewBook;
import com.eebbk.open.scrollphotoitem.IPC.IOnNewBookArrivedListener;

// Declare any non-default types here with import statements

interface NewBookManager {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    List<NewBook> getNewBook();
    void addNewBook(in NewBook newBook);
    void registerListener(IOnNewBookArrivedListener listener);
    void unregisterListener(IOnNewBookArrivedListener listener);
}
