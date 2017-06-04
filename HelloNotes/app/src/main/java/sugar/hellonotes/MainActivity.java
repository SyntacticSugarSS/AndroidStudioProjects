package sugar.hellonotes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button textbtn, imgbtn, videobtn;
    private ListView lv;
    private Intent i;

    private MyAdapter adapter;
    private NotesDB notesDB;
    private SQLiteDatabase dbReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        notesDB = new NotesDB(this);
        dbReader = notesDB.getReadableDatabase();

    }

    @Override
    public void onClick(View v) {
        i = new Intent(this, AddContent.class);
        switch (v.getId()) {
            case R.id.text:
                i.putExtra("flag", "1");
                startActivity(i);
                break;
            case R.id.img:
                i.putExtra("flag", "2");
                startActivity(i);
                break;
            case R.id.video:
                i.putExtra("flag", "3");
                startActivity(i);
                break;
        }
    }

    public void initView() {
        lv = (ListView) findViewById(R.id.list);
        textbtn = (Button) findViewById(R.id.text);
        textbtn.setOnClickListener(this);
        imgbtn = (Button) findViewById(R.id.img);
        imgbtn.setOnClickListener(this);
        videobtn = (Button) findViewById(R.id.video);
        videobtn.setOnClickListener(this);

    }
    public void selectDB() {
        Cursor cursor = dbReader.query(NotesDB.TABLE_NAME,null,null,null,null,null,null);
        adapter = new MyAdapter(this, cursor);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        selectDB();
    }
}
