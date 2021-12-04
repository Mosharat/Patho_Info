package com.ruth.jahan.pathoinfo;

public interface Subject {
    void registerObserver(RepositoryObserver repositoryObserver);
    void notifyObservers();
}
