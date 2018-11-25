package com.example.bgabr.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {

    TextView a;
    @Override
    public void onReceive(Context context, Intent intent) {
        abortBroadcast();
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();
            SmsMessage[] msg = null;
            String Msg_from;

            if(bundle != null){
                try{
                Object[] pdus = (Object[]) bundle.get("pdus");
                msg = new SmsMessage[pdus.length];
                for (int i = 0 ;i<msg.length;i++){
                    msg[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                    Msg_from = msg[i].getOriginatingAddress();
                    String msgBody = msg[i].getMessageBody();
                    Toast.makeText(context,msgBody,Toast.LENGTH_LONG).show();


                }


            }catch (Exception e){
                    Log.d("Excep:",e.getMessage());

                }}


        }
    }
}
