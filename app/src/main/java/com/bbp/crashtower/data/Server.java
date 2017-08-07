package com.bbp.crashtower.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by dongbin on 2017-08-07.
 */

public class Server {

    //database에 있는 instance를 검색
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    //database 내에 data를 저장하고 싶은 위치를 참조.
    DatabaseReference mutiRef = database.getReference("multi");
    DatabaseReference singleRef = database.getReference("single");

        
}
