package com.eebbk.open.scrollphotoitem.DialogActiivity

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle


/**
 * Desc:
 * Author: YangShangZhen
 * Time:   2017/10/28 14:13
 * Email:  369013520@qq.com
 */
class ConfirmDialogFragment : DialogFragment() {

    val mListener: ConfirmDialogListener? = null;

    interface ConfirmDialogListener : DialogInterface.OnClickListener

    companion object {
        fun newInstance(title: String, message: String, cancelable: Boolean): ConfirmDialogFragment {
            val confirmFragment: ConfirmDialogFragment = ConfirmDialogFragment()
            val args: Bundle = Bundle()
            args.putString("title", title)
            args.putString("message", message)
            args.putBoolean("cancelable", cancelable)
            confirmFragment.arguments = args
            return confirmFragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog: AlertDialog = AlertDialog.Builder(activity)
                .setTitle(arguments.getString("title"))
                .setMessage(arguments.getString("message"))
                .setCancelable(arguments.getBoolean("cancelable"))
                .create()
        return alertDialog
    }
}
