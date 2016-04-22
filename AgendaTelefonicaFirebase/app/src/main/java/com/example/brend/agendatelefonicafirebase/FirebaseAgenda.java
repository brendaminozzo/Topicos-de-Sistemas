package com.example.brend.agendatelefonicafirebase;

import com.firebase.client.Firebase;

/**
 * Created by Brenda on 18/04/2016.
 */
public class FirebaseAgenda {
    private static Firebase firebase;
    private static final String URL ="https://aulabrenda.firebaseio.com/";

    public static Firebase getFirebase(){
        if( firebase == null ){
            firebase = new Firebase(URL);
        }
        return( firebase );
    }
}
