package com.ruth.jahan.pathoinfo;

import android.os.Handler;
import java.util.ArrayList;

//import static com.ruth.jahan.pathoinfo.AddTestActivity.cost;
//import static com.ruth.jahan.pathoinfo.AddTestActivity.newtest;
import static com.ruth.jahan.pathoinfo.SignupActivity.newuser;

public class UserDataRepository implements Subject {

    private String mUserName;
    //private int mTk;
    private static UserDataRepository INSTANCE = null;

    private ArrayList<RepositoryObserver> mObservers;

    private UserDataRepository() {
        mObservers = new ArrayList<>();
        getNewDataFromRemote();
    }

    // Simulate network
    private void getNewDataFromRemote() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUserData(newuser);
            }
        }, 10000);
    }

    // Creates a Singleton of the class
    public static UserDataRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserDataRepository();
        }
        return INSTANCE;
    }

    @Override
    public void registerObserver(RepositoryObserver repositoryObserver) {
        if(!mObservers.contains(repositoryObserver)) {
            mObservers.add(repositoryObserver);
        }
    }


    @Override
    public void notifyObservers() {
        for (RepositoryObserver observer: mObservers) {
            observer.onUserDataChanged(mUserName);
        }
    }

    public void setUserData(String userName){    //, int tk) {
        mUserName = userName;
       // mTk = tk;
        notifyObservers();
    }


}
