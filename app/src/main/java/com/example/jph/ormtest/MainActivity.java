package com.example.jph.ormtest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private DatabaseHelper dbhelper = null;
    public DatabaseHelper getHelper() {
        if (dbhelper == null)
            return new DatabaseHelper(this);
        else
            return dbhelper;
    }

    public void Write(View view) {
        EditText et = (EditText) findViewById(R.id.editText);
        if (et.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "No text to persist", Toast.LENGTH_SHORT).show();
            return;
        }
        RuntimeExceptionDao<TestTable, Integer> testDao = getHelper().getSimpleDataDao();
        testDao.create(new TestTable(et.getText().toString()));
        Toast.makeText(MainActivity.this, "Write complete", Toast.LENGTH_SHORT).show();
    }

    public void Read(View view) {
        RuntimeExceptionDao<TestTable, Integer> testDao = getHelper().getSimpleDataDao();
        List<TestTable> list = testDao.queryForAll();
    }

    public void Delete(View view) {
        RuntimeExceptionDao<TestTable, Integer> testDao = getHelper().getSimpleDataDao();
        List<TestTable> list = testDao.queryForAll();
        testDao.delete(list.get(list.size()));
        Toast.makeText(MainActivity.this, "Last entry removed", Toast.LENGTH_SHORT).show();
    }
}
