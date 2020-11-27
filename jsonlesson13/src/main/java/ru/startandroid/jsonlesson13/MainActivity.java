package ru.startandroid.jsonlesson13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        ListView listView = findViewById(R.id.listView);
        try {
            JSONArray data = createJSON();
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            HashMap<String, String> hashMap;
            for(int i = 0; i < data.length(); i++){
                JSONObject jsonObject = data.getJSONObject(i);
                hashMap = new HashMap<>();
                hashMap.put("MemberID", jsonObject.getString("MemberID"));
                hashMap.put("Name", jsonObject.getString("Name"));
                hashMap.put("Tel", jsonObject.getString("Tel"));
                arrayList.add(hashMap);
            }
            SimpleAdapter simpleAdapter;
            simpleAdapter = new SimpleAdapter(this, arrayList,
                    R.layout.list_item, new String[]{"MemberID",
                    "Name", "Tel"}, new int[]{R.id.item_textViewMemberID,
                    R.id.item_textViewName, R.id.item_textViewNumber});
            listView.setAdapter(simpleAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private JSONArray createJSON() throws JSONException {
        ArrayList<JSONObject> jsonArrayList = new ArrayList<>();
        JSONObject object;

        object = new JSONObject();
        object.put("MemberID", "1");
        object.put("Name", "Анна");
        object.put("Tel", "4954876107");
        jsonArrayList.add(object);

        object = new JSONObject();
        object.put("MemberID", "2");
        object.put("Name", "Николай");
        object.put("Tel", "4954780121");
        jsonArrayList.add(object);

        object = new JSONObject();
        object.put("MemberID", "3");
        object.put("Name", "Сардана");
        object.put("Tel", "4954543211");
        jsonArrayList.add(object);
        JSONArray jsonArray = new JSONArray(jsonArrayList);
        return jsonArray;
    }

}