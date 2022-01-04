package com.example.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class PersonViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Person>> people;

    /**
     * Main people collection function tied to observers. If the dataset changes
     * then getPeople() is called, the observers will be notified of the change.
     * @return MutableLiveData<ArrayList<Person>>
     */
    public MutableLiveData<ArrayList<Person>> getPeople() {
        if (people == null) {
            people = new MutableLiveData<>();
            initPeople();
        }
        return people;
    }

    /**
     * Adds a new person to the dataset by copying the collection to a temporary ArrayList
     * then adding a Person object to the temporary ArrayList. The original collection is updated
     * with the setValue() function containing the new ArrayList. The function getPeople() is
     * then called to update the observers.
     * @param person - Object of type Person
     * @return MutableLiveData<ArrayList<Person>>
     */
    public MutableLiveData<ArrayList<Person>> addPerson(Person person) {
        if (people.getValue() != null) {
            ArrayList<Person> temp = people.getValue();
            temp.add(person);
            people.setValue(temp);
        }
        return getPeople();
    }

    /**
     * Initializes the dataset
     */
    private void initPeople() {
        ArrayList<Person> temp = new ArrayList<>();
        temp.add(new Person("Kasey", "7891"));
        people.setValue(temp);
    }
}
