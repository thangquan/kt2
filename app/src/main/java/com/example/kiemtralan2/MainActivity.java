package com.example.kiemtralan2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gvHinhAnh;
    ArrayList<hinhAnh> arrayImage;
    hinhAnhAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        adapter = new hinhAnhAdapter(this,R.layout.dong_hinh_anh,arrayImage);
        gvHinhAnh.setAdapter(adapter);
        gvHinhAnh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                xacNhanXoa(position);
                return false;
            }
        });
        gvHinhAnh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,profile.class);
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        gvHinhAnh = (GridView) findViewById(R.id.gridviewHinhAnh);
        arrayImage = new ArrayList<>();
        arrayImage.add(new hinhAnh(R.drawable.luffy,"Nguyễn Hữu Thắng",""));
        arrayImage.add(new hinhAnh(R.drawable.sanji,"Sanji",""));
        arrayImage.add(new hinhAnh(R.drawable.ussop,"Usopp",""));
        arrayImage.add(new hinhAnh(R.drawable.nami,"nami",""));
    }
    private void xacNhanXoa(final int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo");
        alertDialog.setMessage("bạn Có Muốn Xóa Hay Không");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            arrayImage.remove(position);
            adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }
}