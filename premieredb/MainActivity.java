package com.instinctcoder.sqlitedbmultitbl;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import com.instinctcoder.sqlitedbmultitbl.data.Repo.ServiceProviderRepo;
        import com.instinctcoder.sqlitedbmultitbl.data.model.Channel;
        import com.instinctcoder.sqlitedbmultitbl.data.model.TimeZone;
        import com.instinctcoder.sqlitedbmultitbl.data.model.Premiere;
        import com.instinctcoder.sqlitedbmultitbl.data.model.ServiceProvider;
        import com.instinctcoder.sqlitedbmultitbl.data.Repo.ChannelRepo;
        import com.instinctcoder.sqlitedbmultitbl.data.Repo.TimeZoneRepo;
        import com.instinctcoder.sqlitedbmultitbl.data.Repo.PremiereRepo;
        import com.instinctcoder.sqlitedbmultitbl.model.PremiereList;

        import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStuCourseGrade,btnCourseNameGradeTotal,btnCourseNotTakenByStudent,btnFail,btnDelete,btnInsert;

    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStuCourseGrade= (Button)findViewById(R.id.btnStuCourseGrade);
        btnStuCourseGrade.setOnClickListener(this);

        insertSampleData();



    }

    private void insertSampleData(){

        PremiereRepo premiereRepo = new PremiereRepo();
        ChannelRepo channelRepo = new ChannelRepo();
        TimeZoneRepo timeZoneRepo = new TimeZoneRepo();
        ServiceProviderRepo serviceProviderRepo = new ServiceProviderRepo();


        serviceProviderRepo.delete();
        timeZoneRepo.delete();
        channelRepo.delete();
        premiereRepo.delete();


        //Insert Sample data if the table is empty
        Channel channel = new Channel();

        channel.setChannelName("CBS");
        channel.setChannelId("1111");
        channelRepo.insert(channel);

        channel.setChannelName("CBS");
        channel.setChannelId("2111");
        channelRepo.insert(channel);

        channel.setChannelName("CBS");
        channel.setChannelId("3111");
        channelRepo.insert(channel);

        channel.setChannelName("CBS");
        channel.setChannelId("4111");
        channelRepo.insert(channel);

        channel.setChannelName("CBS");
        channel.setChannelId("5111");
        channelRepo.insert(channel);

        channel.setChannelName("CBS");
        channel.setChannelId("6111");
        channelRepo.insert(channel);

        TimeZone timeZone = new TimeZone();

        timeZone.setTimeZoneId("1111");
        timeZone.setTimeZone("EST");
        timeZone.setAirTime("9:00pm");
        timeZoneRepo.insert(timeZone);

        timeZone.setTimeZoneId(("1112"));
        timeZone.setTimeZone("EST");
        timeZone.setAirTime("9:00pm");
        timeZoneRepo.insert(timeZone);

        Premiere premiere = new Premiere();

        premiere.setPremiereId("1111");
        premiere.setPremiereTitle("APB");
        premiere.setPremiereGenre("Drama");
        premiere.setPremiereCategory("Crime");
        premiere.setPremiereInfo("Crap");
        premiereRepo.insert(premiere);

        premiere.setPremiereId("2111");
        premiere.setPremiereTitle("APB");
        premiere.setPremiereGenre("Drama");
        premiere.setPremiereCategory("Crime");
        premiere.setPremiereInfo("Crap");
        premiereRepo.insert(premiere);


        premiere.setPremiereId("3111");
        premiere.setPremiereTitle("APB");
        premiere.setPremiereGenre("Drama");
        premiere.setPremiereCategory("Crime");
        premiere.setPremiereInfo("Crap");
        premiereRepo.insert(premiere);


        premiere.setPremiereId("4111");
        premiere.setPremiereTitle("APB");
        premiere.setPremiereGenre("Drama");
        premiere.setPremiereCategory("Crime");
        premiere.setPremiereInfo("Crap");
        premiereRepo.insert(premiere);

        premiere.setPremiereId("5111");
        premiere.setPremiereTitle("APB");
        premiere.setPremiereGenre("Drama");
        premiere.setPremiereCategory("Crime");
        premiere.setPremiereInfo("Crap");
        premiereRepo.insert(premiere);


        ServiceProvider serviceProvider = new ServiceProvider();

        serviceProvider.setPremiereId("1111");
        serviceProvider.setChannelId("1111");
        serviceProvider.setChannelNumber("19");
        serviceProviderRepo.insert(serviceProvider);

        serviceProvider.setPremiereId("1111");
        serviceProvider.setChannelId("1111");
        serviceProvider.setChannelNumber("22");
        serviceProviderRepo.insert(serviceProvider);



        serviceProvider.setPremiereId("1111");
        serviceProvider.setChannelId("2111");
        serviceProvider.setChannelNumber("8");
        serviceProviderRepo.insert(serviceProvider);

        serviceProvider.setPremiereId("1111");
        serviceProvider.setChannelId("4111");
        serviceProvider.setChannelNumber("37");
        serviceProviderRepo.insert(serviceProvider);


        serviceProvider.setPremiereId("1111");
        serviceProvider.setChannelId("2111");
        serviceProvider.setChannelNumber("44");
        serviceProviderRepo.insert(serviceProvider);


        serviceProvider.setPremiereId("1111");
        serviceProvider.setChannelId("3111");
        serviceProvider.setChannelNumber("9");
        serviceProviderRepo.insert(serviceProvider);



    }

    private void ListStudentWithCourseNameAndGrade(){

        ServiceProviderRepo serviceProviderRepo = new ServiceProviderRepo();
        List<PremiereList> premiereLists = serviceProviderRepo.getServiceProvider();

        Log.d(TAG,String.format("%-35s", "Premiere ID") +
                String.format("%-35s", "Premiere Title") +
                String.format("%-35s", "Premiere Genre") +
                String.format("%-35s", "Premiere Category") +
                String.format("%-35s", "Premiere Information") +
                String.format("%-35s", "Channel") +
                String.format("%-35s", "Channel Name") +
                String.format("%-35s", "Channel Number") +
                String.format("%-35s", "TimeZone") +
                String.format("%-105s", "TimeZone Name")
        );

        Log.d(TAG,"=============================================================");
        for (int i = 0; i< premiereLists.size(); i++ ){
            Log.d(TAG, "0000000000".substring( premiereLists.get(i).getPremiereId().length())+ premiereLists.get(i).getPremiereId() +
                    "                                 " + String.format("%-35s", premiereLists.get(i).getPremiereTitle())+
                    String.format("%-35s", premiereLists.get(i).getPremiereGenre())+
                    String.format("%-35s", premiereLists.get(i).getPremiereCategory())+
                    String.format("%-35s", premiereLists.get(i).getPremiereInfo())+
                    String.format("%-35s", premiereLists.get(i).getChannelName())+
                    String.format("%-35s", premiereLists.get(i).getChannelName())+
                    String.format("%-31s", premiereLists.get(i).getChannelNumber())+
                    String.format("%-6s", premiereLists.get(i).getAirTime())

            );


        }
        Log.d(TAG,"=============================================================");
    }

 /*   private void ListCourseNameAndGradeCount(){

        ServiceProviderRepo studentCourseRepo = new ServiceProviderRepo();
        List<CourseGradeCount> courseGradeCounts= studentCourseRepo.getCourseGradeCount();

        Log.d(TAG,String.format("%-7s", "Channel") +
                String.format("%-31s", "Channel Name") +
                String.format("%-6s", "Grade") +
                String.format("%-5s", "Total") );
        Log.d(TAG,"=============================================================");
        for (int i= 0; i< courseGradeCounts.size();i++ ){
            Log.d(TAG,String.format("%-7s", courseGradeCounts.get(i).getCourseID())+
                    String.format("%-31s", courseGradeCounts.get(i).getCourseName()) +
                    String.format("%-6s", courseGradeCounts.get(i).getGrade()) +
                    String.format("%-5s", courseGradeCounts.get(i).getCount()));

        }
        Log.d(TAG,"=============================================================");

    }

    private void ListCourseNotTakenByStudent(){

        ServiceProviderRepo studentCourseRepo = new ServiceProviderRepo();
        List<CourseNotTakenByStudent> courseGradeCounts= studentCourseRepo.getCourseNotTakenByStudent("1212");

        Log.d(TAG,"Channel Not taken By Premiere ID = 1212 (Jennifer Ames )") ;
        Log.d(TAG, String.format("%-7s", "Channel") +
                String.format("%-31s", "Channel Name"));
        Log.d(TAG,"=============================================================");
        for (int i= 0; i< courseGradeCounts.size();i++ ){
            Log.d(TAG,String.format("%-7s", courseGradeCounts.get(i).getCourseID())+
                    String.format("%-31s", courseGradeCounts.get(i).getCourseName()));
        }
        Log.d(TAG,"=============================================================");

    }

    private void failAllBUStudent(){
        ServiceProviderRepo studentCourseRepo = new ServiceProviderRepo();
        studentCourseRepo.failALLBUStudent();

    }

    private void deleteAllBUStudent(){
        ServiceProviderRepo studentCourseRepo = new ServiceProviderRepo();
        studentCourseRepo.deleteAllBUStudent();

    }


 //   @Override
 //   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
 //       getMenuInflater().inflate(R.menu.menu_main, menu);
 //       return true;
 //   }

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
*/
    @Override
    public void onClick(View view) {
        if (view ==findViewById(R.id.btnStuCourseGrade)){
            ListStudentWithCourseNameAndGrade();

            insertSampleData();
        }
    }
}