package com.oztaking.www.jsonparse;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.orhanobut.logger.Logger;
import com.oztaking.www.jsonparse.bean.Course;
import com.oztaking.www.jsonparse.bean.Student;
import com.oztaking.www.jsonparse.bean.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*  ===========================================
          1 JSONStrToJSONObject               jsonStringDoc-->JSONObject
          2 JOSONObject2JsonString            JSONObject---> json字符串

          3 JSONArrayDoc2JSONObject           jsonArrayDoc-->JSONArray
          4 JSONArrayDoc2JSONOString          JSONArray---> json字符串

          5 ComplexJSONDoc2JSONObject         ComplexJsonDoc---->JSONObject
          6 ComplexJSONDoc2JSONString         JSONObject---> json字符串

=======================用于解析服务器下载之后的jsonDoc===========================================
        7 JSONStrToJavaBean                jsonStringDoc--->JavaBean(Student.class)
        8 JSONArrayToJavaBean              jsonArrayDoc--->JavaBean（List<Student> studentList2）
        9 JavaBeanList2JSONArrayString     JavaBean ArrayList ---> JSONArrayString
        10 ComplexJsonDoc2JavaBean          ComplexJsonDoc--->JavaBean(Teacher)

======================================================================
        11 JavaBean2ComplexJsonDoc          JavaBean ---> ComplexJsonDoc
        12 JavaBeanString2JSONObject        JavaBean(String) -->JSONObject
        13 JavaBeanArray2JSONArray          JavaList --->JsonArray之间的转换
        14 ComplexJavaBean2JSONOject        ComplexJavaBean_obj与json对象之间的转换*/






public class MainActivity extends AppCompatActivity {


//    //json字符串-简单对象型
//    private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
//
//    //json字符串-数组类型
//    private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12}," +
//            "{\"studentName\":\"lucy\",\"studentAge\":15}]";
//
//    //复杂格式json字符串
//    private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\"," +
//            "\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270}," +
//            "\"students\":[{\"studentName\":\"lily\",\"studentAge\":12}," +
//            "{\"studentName\":\"lucy\",\"studentAge\":15}]}";


    private Button mBtnParseString;
    private Button mBtnParseJSONObject2JSONStr;
    private Button mBtnParseJSONArray2JSONObject;
    private Button mBtnParseJSONArrayDoc2JSONOString;
    private Button mBtnbtnparseComplexJSONDoc2JSONObject;
    private Button mBtnbtnParseComplexJSONDoc2JSONString;
    private Button mBtnbtnParseJSONStrToJavaBean;
    private Button mBtnParseJSONArrayToJavaBean;
    private Button mBtnParseJavaBeanList2JSONArrayString;
    private Button mBtnParseComplexJsonDoc2JavaBean;
    private Button mBtnParsebtnparseJavaBean2ComplexJsonDoc;
    private Button mBtnParseJavaBeanString2JSONObject;
    private Button mBtnParseJavaBeanArray2JSONObject;
    private Button mBtnParseComplexJavaBean2JSONOject;
    private Button mBtnParseComplexJsonObj2JavaBeanObj;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logger.init("MainActivity");

        Logger.i("onCreate");


        mBtnParseString = (Button) findViewById(R.id.btnParseString);
        mBtnParseJSONObject2JSONStr = (Button) findViewById(R.id.btnParseJSONOject2JsonStr);
        mBtnParseJSONArray2JSONObject = (Button) findViewById(R.id.btnParseJSONArray2JSONObject);
        mBtnParseJSONArrayDoc2JSONOString = (Button) findViewById(R.id.btnparseJSONArrayDoc2JSONOString);
        mBtnbtnparseComplexJSONDoc2JSONObject = (Button) findViewById(R.id.btnparseComplexJSONDoc2JSONObject);
        mBtnbtnParseComplexJSONDoc2JSONString = (Button) findViewById(R.id.btnparseComplexJSONDoc2JSONString);
        mBtnbtnParseJSONStrToJavaBean = (Button) findViewById(R.id.btnparseJSONStrToJavaBean);
        mBtnParseJSONArrayToJavaBean = (Button) findViewById(R.id.btnparseJSONArrayToJavaBean);
        mBtnParseJavaBeanList2JSONArrayString = (Button) findViewById(R.id.btnparseJavaBeanList2JSONArrayString);
        mBtnParseComplexJsonDoc2JavaBean = (Button) findViewById(R.id.btnparseComplexJsonDoc2JavaBean);
        mBtnParsebtnparseJavaBean2ComplexJsonDoc = (Button) findViewById(R.id.btnparseJavaBean2ComplexJsonDoc);
        mBtnParseJavaBeanArray2JSONObject = (Button) findViewById(R.id.btnparseJavaBeanArray2JSONObject);
        mBtnParseComplexJavaBean2JSONOject = (Button) findViewById(R.id.btnparseComplexJavaBean2JSONOject);
        mBtnParseComplexJsonObj2JavaBeanObj = (Button) findViewById(R.id.btnparseComplexJsonObj2JavaBeanObj);



        mBtnParseJavaBeanString2JSONObject = (Button) findViewById(R.id.btnparseJavaBeanString2JSONObject);

        mBtnParseString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONStrToJSONObject();
            }
        });

        mBtnParseJSONObject2JSONStr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JOSONObject2JsonString();
            }
        });

        mBtnParseJSONArray2JSONObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJSONArrayDoc2JSONObject();
            }
        });

        mBtnParseJSONArrayDoc2JSONOString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJSONArrayDoc2JSONOString();
            }
        });

        mBtnbtnparseComplexJSONDoc2JSONObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComplexJSONDoc2JSONObject();
            }
        });

        mBtnbtnParseComplexJSONDoc2JSONString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComplexJSONDoc2JSONString();
            }
        });

        mBtnbtnParseJSONStrToJavaBean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONStrToJavaBean();
            }
        });

        mBtnParseJSONArrayToJavaBean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONArrayToJavaBean();
            }
        });

        mBtnParseJavaBeanList2JSONArrayString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JavaBeanList2JSONArrayString();
            }
        });

        mBtnParseComplexJsonDoc2JavaBean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComplexJsonDoc2JavaBean();
            }
        });

        mBtnParsebtnparseJavaBean2ComplexJsonDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JavaBean2ComplexJsonDoc();
            }
        });

        mBtnParseJavaBeanString2JSONObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JavaBeanString2JSONObject();
            }
        });

        mBtnParseJavaBeanArray2JSONObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JavaBeanArray2JSONArray();
            }
        });

        mBtnParseComplexJavaBean2JSONOject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComplexJavaBean2JSONOject();
            }
        });

        mBtnParseComplexJsonObj2JavaBeanObj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComplexJsonObj2JavaBeanObj();
            }
        });
    }

    /**
     * 【1】json字符串-->JSONObject的转换
     * {
     "    studentName": "lily",
     "    studentAge": 12
     * }
     */
    public void JSONStrToJSONObject() {

        String jsonStr = getJson("StringJson.json", getApplicationContext());


        //解析json字符串
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        Toast.makeText(getApplicationContext(), jsonStr, Toast.LENGTH_LONG).show();

        System.out.println(
                "studentName:  " + jsonObject.getString("studentName") + ":" +
                        "  studentAge:  " + jsonObject.getInteger("studentAge"));

        //studentName:  lily:  studentAge:  12


    }

    /**
     * 【2】JSONObject的转换 ---> json字符串
     */

    private void JOSONObject2JsonString(){

        //假设已知JSONObject
        String jsonStr = getJson("StringJson.json", getApplicationContext());

        Logger.i("Logger:"+jsonStr);

//        LogUtils.d("LogUtils:"+jsonStr);
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        //【方法1】
        String s = jsonObject.toJSONString();
//        System.out.println("无参 JOSONObject2JsonString :"+s);
        Logger.i("s:"+s);


        //【方法2】
        String s1 = JSONObject.toJSONString(jsonObject);

//        System.out.println("有参 JOSONObject2JsonString :"+s1);

//        无参 JOSONObject2JsonString :{"studentName":"lily","studentAge":12}
//        有参 JOSONObject2JsonString :{"studentName":"lily","studentAge":12}

    }

    /**
     * [3]jsonArray文件-->JSONArray对象
     */

    private void parseJSONArrayDoc2JSONObject(){
        String jsonArray = getJson("ArrayJson.json", getApplicationContext());

        //解析json数组
        JSONArray objectArray = JSONObject.parseArray(jsonArray);
        System.out.println(objectArray);

        int length = objectArray.size();
        for (int i=0; i<length; i++){
            JSONObject jsonObject = objectArray.getJSONObject(i);
            System.out.println(
                    "studentName:"+ jsonObject.getString("studentName")+":"+
                     "studentAge:"+jsonObject.getString("studentAge"));
        }

//         [{"studentName":"lily","studentAge":12},{"studentName":"lucy","studentAge":15}]
//         studentName:lily:studentAge:12
//         studentName:lucy:studentAge:15

        System.out.println("+++++++++++++++++++++++++");

        for(Object o:objectArray){
            JSONObject jsonObject = (JSONObject) o;
            String studentName = jsonObject.getString("studentName");
            String studentAge = jsonObject.getString("studentAge");

            System.out.println(
                    "studentName:"+ studentName+":"+
                     "studentAge:"+studentAge);
        }
    }

    /**
     *【4】JSONArrayDoc文件中的数组转化为JSONOString;
     */
    private void parseJSONArrayDoc2JSONOString(){
        String jsonArrayDoc = getJson("ArrayJson.json", getApplicationContext());
        System.out.println("jsonArrayDoc :" +jsonArrayDoc);

        JSONArray jsonArray = JSONObject.parseArray(jsonArrayDoc);

        //【方法1】直接无参
        String s = jsonArray.toJSONString();
        System.out.println("JSONOString :" +s);
        //【方法2】有参，作为参数传递；
        String s1 = JSONArray.toJSONString(jsonArray);
        System.out.println("JSONOString :" +s1);
//         jsonArrayDoc :[  {    "studentName": "lily",    "studentAge": 12  },  {    "studentName": "lucy",    "studentAge": 15  }]
//         JSONOString :[{"studentName":"lily","studentAge":12},{"studentName":"lucy","studentAge":15}]
//         JSONOString :[{"studentName":"lily","studentAge":12},{"studentName":"lucy","studentAge":15}]
    }


    /**
     * 【5】Json文件中的string和array组合---->JSONObject;
     *
     * {
     * "teacherName": "crystall",
     * "teacherAge": 27,
     * "course": {
     *        "courseName": "english",
     *        "code": 1270
     *              },
     * "students": [
     *       {
     *        "studentName": "lily",
     *        "studentAge": 12
     *        },
     *       {
     *        "studentName": "lucy",
     *        "studentAge": 15
     *        }
     *             ]
     *    }
     *
     */
    private void ComplexJSONDoc2JSONObject(){
        String jsonDoc = getJson("StringAndArrayJson.json", getApplicationContext());
        Logger.i(String.valueOf(jsonDoc));

        JSONObject jsonObject = JSONObject.parseObject(jsonDoc);
        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");

        System.out.println("teacherName:"+teacherName+"-"
                +"teacherAge:"+teacherAge);

        JSONObject course = jsonObject.getJSONObject("course");
        String courseName = course.getString("courseName");
        String code = course.getString("code");

        System.out.println("courseName:"+courseName+"-"
                +"code:"+code);

        JSONArray studentsArray = jsonObject.getJSONArray("students");
        int length = studentsArray.size();
        for (int i=0; i<length; i++){
            JSONObject object = studentsArray.getJSONObject(i);
            String studentName = object.getString("studentName");
            String studentAge = object.getString("studentAge");
            System.out.println("studentName:"+studentName+"-"
                +"studentAge:"+studentAge);
            }

//       teacherName:crystall-teacherAge:27
//       courseName:english-code:1270
//       studentName:lily-studentAge:12
//       studentName:lucy-studentAge:15

    }


    /**
     *[6]复杂的jsonDoc--->JSONString
     * 两种方法
     */

    private void ComplexJSONDoc2JSONString() {

        String jsonDoc = getJson("StringAndArrayJson.json", getApplicationContext());

        JSONObject jsonObject = JSONObject.parseObject(jsonDoc);

        //方法1
        String s = jsonObject.toJSONString();
        System.out.println("ComplexJSONDoc2JSONString:"+s);

        //方法2
        String s1 = JSONObject.toJSONString(jsonObject);
        System.out.println("ComplexJSONDoc2JSONString:"+s1);

//        ComplexJSONDoc2JSONString:{"course":{"code":1270,"courseName":"english"},"students":[{"studentName":"lily","studentAge":12},{"studentName":"lucy","studentAge":15}],"teacherAge":27,"teacherName":"crystall"}
//        ComplexJSONDoc2JSONString:{"course":{"code":1270,"courseName":"english"},"students":[{"studentName":"lily","studentAge":12},{"studentName":"lucy","studentAge":15}],"teacherAge":27,"teacherName":"crystall"}

    }


    /**
     *[7]简单的StringJSONDoc--->Student.class
     * [注意]在书写student的时候需要书写无参构造方法，否则无法执行，会闪退；
     */

    private void JSONStrToJavaBean(){
        String jsonDoc = getJson("StringJson.json", getApplicationContext());

        //方法1
        JSONObject jsonObject = JSONObject.parseObject(jsonDoc);
        String studentName = jsonObject.getString("studentName");
        Integer studentAge = jsonObject.getInteger("studentAge");

        Student student0 = new Student(studentName, studentAge);
        System.out.println(student0.toString());
        // 输出结果：Student{studentName='lily', studentAge=12}

        //方法2
        //第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
        Student student1 = JSONObject.parseObject(jsonDoc, new TypeReference<Student>() {
        });
        System.out.println(student1.toString());
        // 输出结果：Student{studentName='lily', studentAge=12}
//
        //方法3：直接解析到class中；
        Student student2 = JSONObject.parseObject(jsonDoc, Student.class);
        System.out.println(student2.toString());
        // 输出结果：Student{studentName='lily', studentAge=12}

    }

    /**
     * [8]将arrayJsonDoc--->JavaBean
     * [注意]获取数据时候的数据类型一定要匹配，否则获取的数据为空；
     */
    private void JSONArrayToJavaBean(){

        String jsonArrayDoc = getJson("ArrayJson.json", getApplicationContext());

        //【方法1】
        List<Student> studentsList0 = new ArrayList<>();

        Student student = null;

        JSONArray jsonArray = JSONObject.parseArray(jsonArrayDoc);
        int length = jsonArray.size();
        for (int i=0; i<length; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String studentName = jsonObject.getString("studentName");
            int studentAge = jsonObject.getInteger("studentAge");

            //新建了一个student，然后将student加入到studentlist中；
            student = new Student(studentName, studentAge);
            studentsList0.add(student);
        }
        System.out.println("studentsList0:"+studentsList0);

        //studentsList:[Student{studentName='lily', studentAge=12}, Student{studentName='lucy', studentAge=15}]


//        【方法2】--【注意3】：此出使用的是JSONArray，不是JSONObjcet，否则报错；
        List<Student> studentsList1 = JSONArray.parseObject(jsonArrayDoc, new TypeReference<ArrayList<Student>>() {
        });
        System.out.println("studentsList1:"+studentsList1);

        //【方法3】
        List<Student> studentList2 = JSONArray.parseArray(jsonArrayDoc, Student.class);
        System.out.println("studentList2:"+studentList2);
    }


    /**
     * [9]JavaBean ArrayList ---> JSONArrayString;
     */
    private void JavaBeanList2JSONArrayString(){

        Student dMing = new Student("DMing", 11);
        Student cBing = new Student("CBing", 22);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(dMing);
        studentArrayList.add(cBing);

        String s = JSONArray.toJSONString(studentArrayList);
        System.out.println("s:"+s);
        //输出结果：s:[{"studentAge":11,"studentName":"DMing"},{"studentAge":22,"studentName":"CBing"}]
    }

    /**
     * [10]将ComplexJsonDoc--->JavaBean
     * [注意]获取数据时候的数据类型一定要匹配，否则获取的数据为空；
     */

    private void ComplexJsonDoc2JavaBean(){

        String jsonDoc = getJson("StringAndArrayJson.json", getApplicationContext());

        //方法1
        Teacher teacher0 = JSONObject.parseObject(jsonDoc, new TypeReference<Teacher>(){});
        System.out.println("teacher0:"+teacher0);

        //方法2
        Teacher teacher1 = JSONObject.parseObject(jsonDoc, Teacher.class);
        System.out.println("teacher1:"+teacher1);

//        teacher0:Teacher{teacherName='crystall', teacherAge=27, course=Course{courseName='english', code=1270}, students=[Student{studentName='lily', studentAge=12}, Student{studentName='lucy', studentAge=15}]}
//        teacher1:Teacher{teacherName='crystall', teacherAge=27, course=Course{courseName='english', code=1270}, students=[Student{studentName='lily', studentAge=12}, Student{studentName='lucy', studentAge=15}]}

    }

    /**
     * [11] 将JavaBean ---> ComplexJsonDoc
     * JavaBean2ComplexJsonDoc
     */
    private void JavaBean2ComplexJsonDoc(){

        String jsonDoc = getJson("StringAndArrayJson.json", getApplicationContext());

        Teacher teacher = JSONObject.parseObject(jsonDoc, Teacher.class);

        String s = JSONObject.toJSONString(teacher);
        System.out.println("s:"+s);
    }


    /**
     * [12] JavaBean(String) -->JSONObject
     * 此时的数据来源是：javaBean对象，非Json文件；
     *
     */

    private  void JavaBeanString2JSONObject(){

        Student student0 = new Student("lily", 88);

        //方式1：
        String s = JSONObject.toJSONString(student0);
        JSONObject jsonObject0 = JSONObject.parseObject(s);
        System.out.println(jsonObject0);

        //方法2
        JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(student0);
        System.out.println(jsonObject1);
    }


    /**
     * [13] JavaList --->JsonArray之间的转换
     * 此时的数据来源是：javaBean对象，非Json文件；
     *
     */

    private  void JavaBeanArray2JSONArray(){

        Student student0 = new Student("lily", 119);
        Student student1 = new Student("mei", 120);
        Student student2 = new Student("gang", 110);

        List<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(student0);
        studentArrayList.add(student1);
        studentArrayList.add(student2);

        // 方法1
        JSONArray o0 = (JSONArray)JSONArray.toJSON(studentArrayList);
        System.out.println(o0);

        //方法2
        String s = JSONArray.toJSONString(studentArrayList);
        JSONArray o1 = JSONArray.parseArray(s);
        System.out.println(o1);

    }

    /**
     * [14] 复杂JavaBean_obj与json对象之间的转换
     *
     */

    private void ComplexJavaBean2JSONOject(){

        //已知复杂JavaBean_obj
        Student student = new Student("lily", 12);
        Student studenttwo = new Student("lucy", 15);

        List<Student> students = new ArrayList<Student>();
        students.add(student);
        students.add(studenttwo);
        Course course = new Course("english", 1270);

        Teacher teacher = new Teacher("crystall", 27, course, students);


        //方法1
        String s = JSONObject.toJSONString(teacher);
        JSONObject jsonObject0 = JSONObject.parseObject(s);
        System.out.println(jsonObject0);

        //方法2
        JSONObject jsonObject1 = (JSONObject)JSONObject.toJSON(teacher);
        System.out.println(jsonObject1);

    }


    /**
     * 【15】复杂json对象--->javaBean_obj的转换
     *
     */

    private void ComplexJsonObj2JavaBeanObj(){
        String jsonDoc = getJson("StringAndArrayJson.json", getApplicationContext());
        JSONObject jsonObject = JSONObject.parseObject(jsonDoc);

        //方法1
        Teacher teacher1 = JSONObject.parseObject(jsonObject.toJSONString(), new
                TypeReference<Teacher>() {
        });
        System.out.println(teacher1);

        Teacher teacher2 = JSONObject.parseObject(jsonObject.toJSONString(), Teacher.class);
        System.out.println(teacher2);

    }


    @NonNull
    private static String getJson(String name, Context context) {
        String line;

        StringBuilder builder = new StringBuilder();

        try {
            //获取assets资源管理器
            AssetManager am = context.getAssets();
            //通过管理器打开文件并读取
            InputStream in = am.open(name);
            InputStreamReader ir = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(ir);
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.json(builder.toString());
        return builder.toString();
    }


}
