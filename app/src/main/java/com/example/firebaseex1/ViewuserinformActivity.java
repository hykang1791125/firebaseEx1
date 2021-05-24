package com.example.firebaseex1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    TextView userNameTextView,carNumTextView;
    Button saveButton,A1button,A2button,B1button,B2button,C1button,C2button,D1button,D2button;
    String carlocation;
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
        userNameTextView = findViewById(R.id.userNameTextView);
        carNumTextView = findViewById(R.id.carNumTextView);


        userNameTextView.setText(recive_username);
        carNumTextView.setText(recive_carnum);
        //차 위치 버튼 누르면 carlocation변수에 위치 저장하고 토스트 메세지 띄우기
        /**
         * 1. 차 위치 버튼 클릭 시 대화상자 띄워서 확인
         * 2. 위치 carlocation에 저장
         *
         */
        A1button = findViewById(R.id.A1button);
        A1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = "A1";
                A1button.setBackgroundColor(Color.RED);
                //토스트메세지로 자리 위치 띄워주기
                //서버에 A1자리 값 1로 변경
                //나머지 버튼도 기능 동일
            }
        });

        A2button = findViewById(R.id.A2button);
        A2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = "A2";
                A2button.setBackgroundColor(Color.RED);
            }
        });

        B1button = findViewById(R.id.B1button);
        B1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = "B1";
                B1button.setBackgroundColor(Color.RED);
            }
        });

        B2button = findViewById(R.id.B2button);
        B2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = " B2";
                B2button.setBackgroundColor(Color.RED);
            }
        });

        C1button = findViewById(R.id.C1button);
        C1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = " C1";
                C1button.setBackgroundColor(Color.RED);
            }
        });

        C2button = findViewById(R.id.C2button);
        C2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = " C2";
                C2button.setBackgroundColor(Color.RED);
            }
        });
        D1button = findViewById(R.id.D1button);
        D1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = " D1";
                D1button.setBackgroundColor(Color.RED);
            }
        });
        D2button = findViewById(R.id.D2button);
        D2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carlocation = " D2";
                D2button.setBackgroundColor(Color.RED);
            }
        });


        saveButton = findViewById(R.id.saveButton); //다음 버튼 누르면 값 담고 다음 페이지로 이동
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 사용자 정보 전역변수로 지정, 사용자정보를 확인하는 페이지로 넘김

                Intent intent = new Intent(ViewuserinformActivity.this, AfterEnterCar.class);
                intent.putExtra("username", recive_username);
                intent.putExtra("carnum", recive_carnum);
                intent.putExtra("carlocation", carlocation);
                //값을 들고있는 activity를 다음 activity로 던져야함 => startActivity(값을 담은 intent);

                startActivity(intent);
                //화면 전환 하고 받은 값 서버에 넘김
            }
        });

    }



    /********************
     * 주차중인 차의 값 0(주차가능) 1(주차불가능)에 따라서 버튼색 변경하는 함수 만들기
     *
     */

    /********************
     *  firebase에서 값이 변하면 값을 가져오는 함수
     *
     */

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



    //@@sharedPreference 객체이용 가능하면 쓰고 아니면 아닌거
    //@@ 조건에 따라 activity_alarm.xml로 이동하게

}