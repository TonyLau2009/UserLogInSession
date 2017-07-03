package com.joce.userloginsession;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button loginButton;
    private ImageButton listIndicatorBtn, edt_deleteBtn;
    private ImageView currentUserImage;
    private ListView lv;
    private EditText userEdit, passEdit;
    private static boolean isVisible = false;         //ListView是否可见
    private static boolean isIndicatorUp = false;     //指示器的方向

    public static int currentSelectedPosition = -1;
    //用于记录当前选择的ListView中的QQ联系人条目的ID，如果是-1表示没有选择任何QQ账户，注意在向
    //List中添加条目或者删除条目时都要实时更新该currentSelectedPosition

    String[] from = {"userPhoto", "uName", "deletBtn"};
    int[] to={R.id.userPhoto, R.id.userName, R.id.item_delete_Btn};
    ArrayList<HashMap<String,Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        listIndicatorBtn = (ImageButton) findViewById(R.id.List_Indicator);
        edt_deleteBtn = (ImageButton) findViewById(R.id.edt_delete_btn);

        currentUserImage = (ImageView) findViewById(R.id.ivIcon);

        lv = (ListView) findViewById(R.id.user_lv);

        userEdit = (EditText) findViewById(R.id.edtUname);
        passEdit = (EditText) findViewById(R.id.edtPasswds);

        list = new ArrayList<>();

        loginButton = (Button) findViewById(R.id.btnLogin);


        userEdit.setOnClickListener(this);
        edt_deleteBtn.setOnClickListener(this);
        listIndicatorBtn.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.edtUname:
                if(!userEdit.getText().toString().equals("")){
                    edt_deleteBtn.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.List_Indicator:
                lv.setVisibility(View.VISIBLE);

                break;
            case R.id.edt_delete_btn:
                userEdit.setText("");
                edt_deleteBtn.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }
}
