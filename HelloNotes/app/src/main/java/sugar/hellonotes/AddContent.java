package sugar.hellonotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.VideoView;

import java.util.Date;

/**
 * Created by hubingqian on 2017/6/4.
 */

public class AddContent extends AppCompatActivity implements View.OnClickListener{
    private String val;
    private Button saveBtn,deleteBtn;
    private EditText edtext;
    private ImageView c_img;
    private VideoView v_video;
    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontent);
        val = getIntent().getStringExtra("flag");

        initView();

        notesDB = new NotesDB(this);
        dbWriter = notesDB.getWritableDatabase();
    }

    private void initView() {
        saveBtn = (Button)findViewById(R.id.save);
        deleteBtn = (Button)findViewById(R.id.delete);
        edtext = (EditText)findViewById(R.id.edit_text);
        c_img = (ImageView)findViewById(R.id.c_img);
        v_video = (VideoView)findViewById(R.id.c_vide);

        saveBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                addDB();
                finish();
                break;
            case R.id.delete:
                finish();
                break;
        }
    }
    public void addDB() {
        ContentValues cv = new ContentValues();
        cv.put(NotesDB.CONTENT, edtext.getText().toString());
        cv.put(NotesDB.TIME, getTime());
        dbWriter.insert(NotesDB.TABLE_NAME, null, cv);
    }
    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = new Date();
        String str = format.format(date);
        return str;
    }
}
