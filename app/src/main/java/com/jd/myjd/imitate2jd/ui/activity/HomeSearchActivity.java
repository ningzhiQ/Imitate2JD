package com.jd.myjd.imitate2jd.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jd.myjd.imitate2jd.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeSearchActivity extends Activity {

    @BindView(R.id.top_titleimg)
    ImageView topTitleimg;
    @BindView(R.id.too_search)
    ImageView tooSearch;
    @BindView(R.id.top_ed)
    EditText topEd;
    @BindView(R.id.search_tagFlowLayout)
    TagFlowLayout searchTagFlowLayout;
    @BindView(R.id.textView4)
    TextView textView4;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_search);
        ButterKnife.bind(this);
        strings = new ArrayList<>();
        tooSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = topEd.getText().toString();
                strings.add(s);
                Intent intent = new Intent(HomeSearchActivity.this, GoodsActivity.class);
                intent.putExtra("name",s);
                startActivity(intent);
            }
        });

        searchTagFlowLayout.setAdapter(new TagAdapter(strings) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView textView = new TextView(HomeSearchActivity.this);
                textView.setText(strings.get(position));
                return textView;
            }
        });
        searchTagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                String s = strings.get(position);
                Intent intent = new Intent(HomeSearchActivity.this, GoodsActivity.class);
                intent.putExtra("name",s);
                startActivity(intent);
                return false;
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        searchTagFlowLayout.setAdapter(new TagAdapter(strings) {
            @Override
            public View getView(FlowLayout parent, int position, Object o) {
                TextView textView = new TextView(HomeSearchActivity.this);
                textView.setText(strings.get(position));
                return textView;
            }
        });
    }

    @OnClick(R.id.too_search)
    public void onViewClicked() {

    }
}
