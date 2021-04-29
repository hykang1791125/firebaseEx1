package com.example.firebaseex1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

// 1. 사용자 정보를 확인
// 2. 주차상태 확인하기
public class ViewuserinformActivity extends AppCompatActivity {

    //String username = firebaseDatabase.getReference("users").getKey();//이거하면 users가 나옴
    //DatabaseReference username_path = firebaseDatabase.getReference("/users/"+userid+"/username/");

  //  String userid; //intent에서 받아온 userid값(push값)-> 사용자 고유 key값
  //  String get_username, get_carnum; //로컬데이터에서 받은 값
    //-------------차위치 변수선언--------------
    String enter_carlocation;//차위치
    Boolean enter_carnum;//주차 상태
    //-----------------------------------------
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference database = firebaseDatabase.getReference();

    TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuserinform);

        //값을 받을 intent 만들기 : getIntent();
        Intent intent = getIntent();
        //Bundle로 값 받은 다음에 받은거 string으로 다시꺼내기
        Bundle bundle = intent.getExtras();
        //추가설명 : putExtra 로 값을 넣었으니까 extras 에서 값을 가져온 뒤, 거기서 아까 정해준 key값으로 꺼내야함
        String recive_username = bundle.getString("username");
        String recive_carnum = bundle.getString("carnum");
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);


        textView1.setText(recive_username);
        textView2.setText(recive_carnum);

    }
/**
    //원하는 위치에 값 추가하는 코드 구현하기//--> firebase에 users밑에 새로운 카테고리로 carstatus 생성하기 여기에는 carlocation 에 대한 carstatus 정보 담기
                                                        --> status정보가 갱신될때마다 db읽어와서 화면에 표시해주기 (주차중 or 빈자리)
    public void writeCarstatus(){//firebase에 사용자 정보에 추가해서 넣기
        CarStatus carStatus = new CarStatus();
        carStatus.setCarlocation(enter_carlocation);
        carStatus.setCarstatus(enter_carnum);

        database.child("users").child(userid).put(carStatus);
        //database.child("users").child(String.valueOf(userId)).setValue(userInfo);
//        userid = database.child("users").push().getKey();
**/

/** addchildlistener 써서 서버에서 변동된 값 가져오기**/
 //   public void getUserdata(){

   //     reference.addValueEventListener(new ValueEventListener() {
   //         @Override
   //         public void onDataChange(DataSnapshot snapshot) {
    //            if(snapshot.getKey() == userid){
    //                get_username = snapshot.child("username").getValue(String.class);
     //           }
     //       }

       //     @Override
      //      public void onCancelled(@NonNull DatabaseError error) {
       //         //failed to read value
      //      }
      //
}