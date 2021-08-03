package com.example.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapater adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();//消息初始化
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapater = new MsgAdapater(msgList);
        msgRecyclerView.setAdapter(adapater);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = "      "+inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapater.notifyItemInserted(msgList.size() - 1);//刷新recyclerView
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);//将RecycleView定位到最后一行
                    inputText.setText("");//清空
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1 = new Msg("                                   凤箫声动", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("    玉壶光转", Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("                                  一夜鱼龙舞", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
