package com.example.visualstudio.canthouniversity.Service;


import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;

/**
 * Created by Visual Studio on 10/24/2017.
 */

public class SocketIOService {
    public static String BASE_URL="http://192.168.1.34:3000/";
    public static Socket mSocket = null;

    public static void getConnect(){
        if(mSocket == null){
            try {
                mSocket = IO.socket(BASE_URL);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        mSocket.connect();
    }
}
